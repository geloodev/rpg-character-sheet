package com.geloodev.rpgcharactersheet.repositories;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.geloodev.rpgcharactersheet.models.Character;

public interface CharacterRepository extends MongoRepository<Character, String> {
    Collection<Character> findByUserId(ObjectId userId);
}