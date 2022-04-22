package com.haziq.crbs.controllers.auth;

import com.haziq.crbs.models.Customer;
import com.haziq.crbs.models.User;
import com.haziq.crbs.payload.request.LoginRequest;
import com.haziq.crbs.payload.request.RegisterCustomerRequest;
import com.haziq.crbs.payload.request.RegisterRequest;
import com.haziq.crbs.payload.response.JwtAuthResponse;
import com.haziq.crbs.payload.response.MessageResponse;
import com.haziq.crbs.repositories.CustomerRepository;
import com.haziq.crbs.repositories.UserRepository;
import com.haziq.crbs.security.jwt.JwtUtils;
import com.haziq.crbs.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping(value = "/api/auth")
public class CustomerAuthController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/customer/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        // authenticate user
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // get the user's roles
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity
                .ok(new JwtAuthResponse(
                        jwt,
                        userDetails.getEmail(),
                        userDetails.getId(),
                        roles
                ));

    }

    @PostMapping(value="/customer/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterCustomerRequest registerRequest) {
        if(customerRepository.existsByEmail(registerRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Email has been used"));
        }
        Customer customer = new Customer(registerRequest.getUsername(),
                passwordEncoder.encode(registerRequest.getPassword()),
                registerRequest.getEmail(),
                registerRequest.getPhoneNumber(),
                registerRequest.getIcNumber());
        customerRepository.save(customer);

        return ResponseEntity
                .ok(new MessageResponse("User Successfully Registered"));
    }
}
