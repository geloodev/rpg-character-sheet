package com.geloodev.rpgcharactersheet.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "characters")
public class Character {

    @Id
    private String id;

    private String name;
    private CharacterAbilities abilities;

    public Character(String name, CharacterAbilities abilities) {
        this.name = name;
        this.abilities = abilities;
    }
}
