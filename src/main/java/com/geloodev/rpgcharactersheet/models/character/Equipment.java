package com.geloodev.rpgcharactersheet.models.character;

public enum Equipment {
    BACKPACK (
        "Backpack",
        6,
        "Holds 7 normal-sized items"
    ),
    BEAR_TRAP (
        "Bear Trap",
        20,
        "Presence DR14 to spot, d8 damage"
    ),
    BLANKET (
        "Blanket",
        4,
        ""
    );

    private String equipmentName;
    private int silverPrice;
    private String description;

    Equipment(String equipmentName, int silverPrice, String description) {
        this.equipmentName = equipmentName;
        this.silverPrice = silverPrice;
        this.description = description;
    }
}
