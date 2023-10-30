package com.geloodev.rpgcharactersheet.models.character;

public enum Armor {
    TIER_0 (
        "no armor (tier 0)",
        0,
        ""
    ),
    TIER_1 (
        "light (fur,padded cloth, leather etc, -d2 damage, tier 1)",
        20,
        ""
    ),
    TIER_2 (
        "medium arm (scale, mail etc, -d4 damage, tier 2)",
        100,
        "DR +2 on Agility tests including defence."
    ),
    TIER_3 (
        "heavy armor (splint, plate etc, -d6 damage, tier 3)",
        200,
        "DR +4 on Agility tests, defence is DR +2."
    );

    private String description;
    private int silverPrice;
    private String otherInfo;

    Armor (String description, int silverPrice, String otherInfo) {
        this.description = description;
        this.silverPrice = silverPrice;
        this.otherInfo = otherInfo;
    }
}
