package com.geloodev.rpgcharactersheet.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.geloodev.rpgcharactersheet.models.Character;

public interface CharacterRepository extends MongoRepository<Character, String> {}