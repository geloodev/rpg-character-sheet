package com.geloodev.rpgcharactersheet.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geloodev.rpgcharactersheet.models.character.Character;
import com.geloodev.rpgcharactersheet.repositories.CharacterRepository;

@Service
public class CharacterServiceImpl implements CharacterService {
    
    @Autowired
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Collection<Character> getCharactersByUsername(String username) {
        return characterRepository.findByUsername(username);
    }

    public Collection<Character> getCharacters() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(String id) {
        return characterRepository.findById(id).orElse(null);
    }

    public Character updateCharacter(String id, Character character) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);
        if (optionalCharacter.isPresent()) {
            Character updatedCharacter = optionalCharacter.get();
            updatedCharacter.setName(character.getName());
            updatedCharacter.setDescription(character.getDescription());
            updatedCharacter.setCharacterClass(character.getCharacterClass());
            updatedCharacter.setAbilities(character.getAbilities());
            updatedCharacter.setEquipments(character.getEquipments());
            updatedCharacter.setUsername(character.getUsername());
            return characterRepository.save(updatedCharacter);
        }
        return null;
    }

    public void createCharacter(Character character) {
        characterRepository.save(character);
    }

    public void deleteCharacter(String id) {
        characterRepository.deleteById(id);
    }
}
