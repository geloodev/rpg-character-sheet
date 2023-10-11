package com.geloodev.rpgcharactersheet.services;

import java.util.Collection;

import com.geloodev.rpgcharactersheet.models.User;

public interface UserService {
    Collection<User> getUsers();
    User getUserById(String id);
    User updateUser(String id, User user);
    void createUser(User user);
    void deleteUser(String id);
}