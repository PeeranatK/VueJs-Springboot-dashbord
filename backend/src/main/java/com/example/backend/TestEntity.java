package com.example.backend;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class TestEntity {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public TestEntity() {
    }

    public TestEntity(Integer id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
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


}
