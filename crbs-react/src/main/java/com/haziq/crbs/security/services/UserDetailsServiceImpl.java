package com.haziq.crbs.security.services;

import com.haziq.crbs.models.User;
import com.haziq.crbs.repositories.UserRepository;
import com.haziq.crbs.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    // load by username: using email instead of username
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with Username" + username));
        System.out.println(user);
        return UserDetailsImpl.build(user);
    }

    public UserDetails loadByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found with Email " + email));
        return UserDetailsImpl.build(user);
    }
}
