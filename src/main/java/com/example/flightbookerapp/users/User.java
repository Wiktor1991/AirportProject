package com.example.flightbookerapp.users;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USERS")
@ToString
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name="id")
    Integer id;
    @Column(name="email")
    String email;
    @Column(name="password")
    String password;
    @Column(name="type")
    String type;

    public User(String email, String password, String typeOfUser) {
        this.email = email;
        this.password = password;
        this.type = typeOfUser;
    }

    public User() {
    }

    public User(Integer id, String email, String password, String type) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

