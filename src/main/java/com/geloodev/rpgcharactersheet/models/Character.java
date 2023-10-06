package com.geloodev.rpgcharactersheet.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "characters")
public class Character {

    @Id
    private String id;

    private String name;
    private String description;
    private CharacterClass characterClass;
    private CharacterAbilities abilities;
    private List<CharacterEquipment> equipments;

    public Character(String name, CharacterAbilities abilities) {
        this.name = name;
        this.abilities = abilities;
    }
}
