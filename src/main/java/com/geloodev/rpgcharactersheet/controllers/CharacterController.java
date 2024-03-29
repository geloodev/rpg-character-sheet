package com.geloodev.rpgcharactersheet.controllers;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geloodev.rpgcharactersheet.models.character.Armor;
import com.geloodev.rpgcharactersheet.models.character.Character;
import com.geloodev.rpgcharactersheet.models.character.CharacterClass;
import com.geloodev.rpgcharactersheet.models.character.Equipment;
import com.geloodev.rpgcharactersheet.models.character.Omens;
import com.geloodev.rpgcharactersheet.models.character.Weapons;
import com.geloodev.rpgcharactersheet.services.CharacterService;

@Controller
@RequestMapping("/{username}/characters")
public class CharacterController {
    
    @Autowired
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @ModelAttribute("allClasses")
    public List<CharacterClass> populateClasses() {
        return Arrays.asList(CharacterClass.values());
    }

    @ModelAttribute("allWeapons")
    public List<Weapons> populateWeapons() {
        return Arrays.asList(Weapons.values());
    }

    @ModelAttribute("allArmors")
    public List<Armor> populateArmors() {
        return Arrays.asList(Armor.values());
    }

    @ModelAttribute("allEquipments") 
    public List<Equipment> populateEquipments() {
        return Arrays.asList(Equipment.values());
    }

    @ModelAttribute("allOmens")
    public List<Omens> populateOmens() {
        return Arrays.asList(Omens.values());
    }

    @GetMapping
    public String getCharactersByUsername(@PathVariable("username") String username, Model model) {
        Collection<Character> characters = characterService.getCharactersByUsername(username);
        model.addAttribute("characters", characters);
        model.addAttribute("username", username);
        return "user-characters";
    }

    @GetMapping("/create")
    public String createCharacterForm(@PathVariable("username") String username, Model model) {
        model.addAttribute("character", new Character());
        model.addAttribute("username", username);
        return "create-character";
    }

    @PostMapping("/delete/{id}")
    public String deleteCharacter(@PathVariable("username") String username, @PathVariable("id") String id) {
        characterService.deleteCharacter(id);
        return "redirect:/{username}/characters";
    }

    @PostMapping("/create")
    public String createCharacterFormSubmit(@PathVariable("username") String username, @ModelAttribute Character character) {
        characterService.createCharacter(character);
        return "redirect:/{username}/characters";
    }
}
