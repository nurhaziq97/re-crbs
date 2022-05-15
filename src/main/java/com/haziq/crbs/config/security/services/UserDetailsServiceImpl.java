package com.haziq.crbs.config.security.services;

import com.haziq.crbs.modules.accounts.generic.User;
import com.haziq.crbs.modules.accounts.generic.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    final
    UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // load by username: using email instead of username
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
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
