package com.geloodev.rpgcharactersheet.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geloodev.rpgcharactersheet.models.User;
import com.geloodev.rpgcharactersheet.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(Model model) {
        Collection<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/{username}")
    public String getUserByUsername(@PathVariable("username") String username, Model model) {
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping
    public void createUser(@ModelAttribute User user, Model model) {
        userService.createUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") String id, @RequestBody User request) {
        userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
    }
}