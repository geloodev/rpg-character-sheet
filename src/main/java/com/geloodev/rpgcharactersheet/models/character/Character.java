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
    private Abilities abilities;
    private Collection<Weapons> weapons;
    private Armor armor;
    private Collection<Equipment> equipments;
    private Collection<Powers> powers;
    private Collection<Omens> omens;
    private String username;

    public Character(String name, String description, CharacterClass characterClass, 
                     Abilities abilities, Collection<Weapons> weapons, Armor armor, 
                     Collection<Equipment> equipments, Collection<Powers> powers, 
                     Collection<Omens> omens, String username) {
        this.name = name;
        this.description = description;
        this.characterClass= characterClass;
        this.abilities = abilities;
        this.weapons = weapons;
        this.armor = armor;
        this.equipments = equipments;
        this.powers = powers;
        this.omens = omens;
        this.username = username;
    }

    public Character() {}
}
