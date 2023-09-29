package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.entities.User;
import com.example.backend.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public boolean addUser(String username, String password, String value) {
        try {
            User user =  new User(username, password, value);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false; // User with that id doesn't exist
        } catch (Exception e) {
            // Handle any other exceptions
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean updateUser(String username, String password, String value, Integer id) {
        try {
            userRepository.updateUser(username, password, value, id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false; // User with that id doesn't exist
        } catch (Exception e) {
            // Handle any other exceptions
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    public boolean deleteUser(Integer id) {
        try {
            userRepository.deleteUser(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false; // User with that id doesn't exist
        } catch (Exception e) {
            // Handle any other exceptions
            e.printStackTrace();
            return false;
        }
    }
}

