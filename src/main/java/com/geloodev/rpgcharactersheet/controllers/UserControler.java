package com.geloodev.rpgcharactersheet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geloodev.rpgcharactersheet.models.User;
import com.geloodev.rpgcharactersheet.services.UserService;

@Controller
@RequestMapping("/users")
public class UserControler {
    
    @Autowired
    private final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers() {
        // Collection<User> users = userService.getUsers();
        // ModelAndView mv = new ModelAndView("users");
        // mv.addObject("users", users);
        // return mv;
        return "users";
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
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

    // @GetMapping("/{userId}/characters")
    // public ResponseEntity<List<Character>> getCharacters(@PathVariable("userId") String userId) {
    //     Optional<User> optionalUser = userRepository.findById(userId);

    //     if (optionalUser.isPresent()) {
    //         User user = optionalUser.get();
    //         List<Character> characters = user.getCharacters();
    //         return ResponseEntity.ok(characters);
    //     }
    //     return ResponseEntity.notFound().build();
    // }

    // @PostMapping("/{userId}/characters")
    // private ResponseEntity<String> createCharacter(
    //     @PathVariable("userId") String userId,
    //     @RequestBody Character character
    // ) {
    //     Optional<User> optionalUser = userRepository.findById(userId);

    //     if (optionalUser.isPresent()) {
    //         ObjectId objectId = new ObjectId();
    //         character.setId(objectId.toString());

    //         User user = optionalUser.get();
    //         user.getCharacters().add(character);
    //         userRepository.save(user);
            
    //         return ResponseEntity.ok("Character created successfully!");
    //     }

    //     return ResponseEntity.notFound().build();
    // }
}