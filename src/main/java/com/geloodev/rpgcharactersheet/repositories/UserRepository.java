package com.geloodev.rpgcharactersheet.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.geloodev.rpgcharactersheet.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}