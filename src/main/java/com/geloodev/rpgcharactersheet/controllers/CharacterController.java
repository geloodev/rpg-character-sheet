package com.geloodev.rpgcharactersheet.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geloodev.rpgcharactersheet.models.Character;
import com.geloodev.rpgcharactersheet.services.CharacterService;

@Controller
@RequestMapping("/{username}/characters")
public class CharacterController {
    
    @Autowired
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public String getCharactersByUsername(@PathVariable("username") String username, Model model) {
        Collection<Character> characters = characterService.getCharactersByUsername(username);
        model.addAttribute("characters", characters);
        model.addAttribute("username", username);
        return "characters";
    }

    @GetMapping("/create")
    public String createCharacterPage() {
        return "create-character";
    }
}
