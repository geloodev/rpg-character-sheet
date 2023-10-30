package com.geloodev.rpgcharactersheet.models.character;

public enum Weapons {

    BATTLE_AXE (
        "Battle Axe",
        "d8",
        35
    ),
    BOW (
        "Bow",
        "d6",
        25
    ),
    CLUB (
        "Club",
        "d6",
        10
    );
    
    private String weaponName;
    private String damage;
    private int silverPrice;

    Weapons(String weaponName, String damage, int silverPrice) {
        this.weaponName = weaponName;
        this.damage = damage;
        this.silverPrice = silverPrice;
    }

    private String weaponName() { return weaponName; }
    private String damage() { return damage; }
    private int silverPrice() { return silverPrice; }
}
