package com.example.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name =  "user")
public class User {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "value")
    private String value;

    private static final String roles = "ADMIN";

    public User() {
    }

    public User(Integer id, String username, String password, String value){
        this.id = id;
        this.username = username;
        this.password = password;
        this.value = value;
    }

    public User(Integer id){
        this.id = id;
    }

    public User(String username, String password, String value){
        this.username = username;
        this.password = password;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public String getValue() {
        return value;
    }
    public String getRoles() {
        return roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setValue(String value) {
        this.value = value;
    }

    
}
