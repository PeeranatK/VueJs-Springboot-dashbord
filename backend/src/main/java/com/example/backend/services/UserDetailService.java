package com.example.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.backend.entities.User;
import com.example.backend.entities.UserDetail;
import com.example.backend.repositories.UserRepository;

@Component
public class UserDetailService implements UserDetailsService{
     @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = repository.findByUsername(username);
        return userInfo.map(UserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
}
