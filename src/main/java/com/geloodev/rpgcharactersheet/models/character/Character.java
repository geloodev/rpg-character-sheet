package com.geloodev.rpgcharactersheet.models.character;

import java.util.Collection;

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
    private Collection<Equipment> equipments;
    private String username;

    public Character(String name, String description, CharacterClass characterClass, 
                     CharacterAbilities abilities, Collection<Equipment> equipments, 
                     String username) {
        this.name = name;
        this.description = description;
        this.characterClass= characterClass;
        this.abilities = abilities;
        this.equipments = equipments;
        this.username = username;
    }

    public Character() {}
}
