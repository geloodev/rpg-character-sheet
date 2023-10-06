package com.geloodev.rpgcharactersheet.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("users")
public class User {

    @Id
    private String id;

    private String username;
    private String email;
    private String password;
    private List<Character> characters;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
