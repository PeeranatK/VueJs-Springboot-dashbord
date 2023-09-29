package com.example.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.example.backend.entities.AuthRequest;
import com.example.backend.entities.TokenResponse;
import com.example.backend.entities.User;
import com.example.backend.repositories.UserRepository;
import com.example.backend.services.JwtService;
import com.example.backend.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired 
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userRepository.findAll();
    } 

    @GetMapping("/getAllQuery")
    public List<User> getAllQuery() {
        return userRepository.getAllQuery();
    } 

    @GetMapping("/getSingle")
    public User getUser(@RequestBody User user) {
        return userRepository.getUser(user.getId());
    }

    @PostMapping("/addUser")
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user.getUsername(), user.getPassword(), user.getValue());
    }
    
    @PostMapping("/updateUser")
    public boolean updateUser(@RequestBody User user){
        System.out.println(user);
        return userService.updateUser(user.getUsername(), user.getPassword(), user.getValue(), user.getId());
    }
    
    @PostMapping("/deleteUser")
    public boolean deleteUser(@RequestBody User user){
        return userService.deleteUser(user.getId());
    }

    @PostMapping("/getToken")
    public TokenResponse authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        //return jwtService.generateToken(authRequest.getUsername());
        //return jwtService.generateToken(authRequest.getUsername());
        TokenResponse res = new TokenResponse();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            res.setStatus(true);
            res.setToken(jwtService.generateToken(authRequest.getUsername()));
            return res;
        } else {
            //res.setStatus(false);
            //return res;
            throw new UsernameNotFoundException("invalid user request !");
        }


    }
    
}
