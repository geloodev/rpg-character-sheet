package com.geloodev.rpgcharactersheet.services;

import java.util.Collection;

import com.geloodev.rpgcharactersheet.models.Character;

public interface CharacterService {
    Collection<Character> getCharacters();
    Collection<Character> getCharactersByUsername(String username);
    Character getCharacterById(String id);
    Character updateCharacter(String id, Character character);
    void createCharacter(Character character);
    void deleteCharacter(String id);
}
