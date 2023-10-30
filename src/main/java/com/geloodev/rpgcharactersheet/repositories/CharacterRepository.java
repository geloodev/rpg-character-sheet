package com.geloodev.rpgcharactersheet.repositories;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.geloodev.rpgcharactersheet.models.character.Character;

public interface CharacterRepository extends MongoRepository<Character, String> {
    Collection<Character> findByUsername(String username);
}