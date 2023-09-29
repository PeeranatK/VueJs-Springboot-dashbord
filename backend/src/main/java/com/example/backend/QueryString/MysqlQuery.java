package com.example.backend.QueryString;

public class MysqlQuery {
    public static final String GET_ALL_USER = "SELECT * FROM user";
    public static final String GET_USER = "SELECT * FROM user WHERE id = ?1";
    public static final String GET_USER_BY_NAME = "SELECT * FROM user WHERE username = ?1";
    public static final String ADD_USER = "INSERT INTO `user` (username, password, value) VALUES (?1, ?2, ?3)";
    public static final String UPDATE_USER = "UPDATE `user` SET username = ?1, password = ?2, value = ?3 WHERE id = ?4";
    public static final String DELETE_USER = "DELETE FROM `user` WHERE id = ?1";
}
