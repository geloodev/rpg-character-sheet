package com.geloodev.rpgcharactersheet.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "characters")
public class Character {

    @Id
    private String id;

    private String name;
    private String description;
    
    @Field("class")
    private CharacterClass characterClass;
    
    private CharacterAbilities abilities;
    private List<CharacterEquipment> equipments;
    private ObjectId userId;

    public Character(String name, String description, CharacterAbilities abilities, ObjectId userId) {
        this.name = name;
        this.description = description;
        this.abilities = abilities;
        this.userId = userId;
    }
}
