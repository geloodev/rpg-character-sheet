package com.geloodev.rpgcharactersheet.models;

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
    private Collection<CharacterEquipment> equipments;
    private String username;

    public Character(String name, String description, CharacterClass characterClass, 
                     CharacterAbilities abilities, Collection<CharacterEquipment> equipments, 
                     String username) {
        this.name = name;
        this.description = description;
        this.characterClass= characterClass;
        this.abilities = abilities;
        this.equipments = equipments;
        this.username = username;
    }
}
