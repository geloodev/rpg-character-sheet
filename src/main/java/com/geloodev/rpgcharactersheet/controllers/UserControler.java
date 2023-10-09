package com.geloodev.rpgcharactersheet.controllers;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.geloodev.rpgcharactersheet.models.User;
import com.geloodev.rpgcharactersheet.models.Character;
import com.geloodev.rpgcharactersheet.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserControler {
    
    @Autowired
    private final UserRepository userRepository;

    public UserControler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public ModelAndView getUsers() {
        List<User> users = userRepository.findAll();
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", users);
        return mv;
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") String id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") String id, @RequestBody User request) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            userRepository.save(user);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent())
            userRepository.deleteById(id);
    }

    @GetMapping("/{userId}/characters")
    public ResponseEntity<List<Character>> getCharacters(@PathVariable("userId") String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Character> characters = user.getCharacters();
            return ResponseEntity.ok(characters);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{userId}/characters")
    private ResponseEntity<String> createCharacter(
        @PathVariable("userId") String userId,
        @RequestBody Character character
    ) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            ObjectId objectId = new ObjectId();
            character.setId(objectId.toString());

            User user = optionalUser.get();
            user.getCharacters().add(character);
            userRepository.save(user);
            
            return ResponseEntity.ok("Character created successfully!");
        }

        return ResponseEntity.notFound().build();
    }
}