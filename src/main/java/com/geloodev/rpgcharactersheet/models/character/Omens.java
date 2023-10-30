package com.geloodev.rpgcharactersheet.models.character;

public enum Omens {
    MAXIMUM_DAMAGE ("deal maximum damage with one attack"),
    REROLL ("reroll a dice roll (yours or someone else's)"),
    MINUS_D6_DAMAGE ("lower damage dealt to you by d6"),
    NO_CRIT_OR_FUMBLE ("neutralize a Crit or Fumble"),
    DR_MINUS_4 ("lower one test's DR by -4");

    private final String description;
    
    Omens(String description) {
        this.description = description;
    }

    private String description() { return description; }
}
