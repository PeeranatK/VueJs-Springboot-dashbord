package com.example.backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.QueryString.MysqlQuery;
import com.example.backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Query(nativeQuery = true, value = MysqlQuery.GET_ALL_USER)
    List<User> getAllQuery();

    @Query(nativeQuery = true, value = MysqlQuery.GET_USER)
    User getUser(Integer id);

    @Query(nativeQuery = true, value = MysqlQuery.GET_USER_BY_NAME)
    User getUserByName(String username);

    @Query(nativeQuery = true, value = MysqlQuery.ADD_USER)
    void addUser(String username, String password, String value);

    @Modifying
    @Query(nativeQuery = true, value = MysqlQuery.UPDATE_USER)
    void updateUser(String username, String password, String value, Integer id);

    @Modifying
    @Query(nativeQuery = true, value = MysqlQuery.DELETE_USER)
    void deleteUser(Integer id);

    Optional<User> findByUsername(String username);
}
