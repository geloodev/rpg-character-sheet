package com.geloodev.rpgcharactersheet.models.character;

public enum CharacterClass {
    FANGED_DESERTER (
        "Fanged Deserter",
        "You have thirty or so friends who never let you down: YOUR TEETH. Disloyal, deranged or simply uncontrollable, any group that didn’t boot you out you left anyway. But your parliament of teeth—enormous, protruding, thick and sharp—have always been your allies."
    ),
    GUTTERBORN_SCUM (
        "Gutterborn Scum",
        "An ill star smiled upon your birth. Poverty, crime and bad parenting didn’t help either. In your community an honest day’s work was never an option. Not that you ever tried, what are you, some kind of mug? A razor blade and a moonless night are worth a week of chump-work."
    ),
    ESOTERIC_HERMIT (
        "Esoteric Hermit",
        "The stone of your cave is one with the stars. Silence and perfection. Now the chaos of a fallen world disturbs your rituals and the caul of night grows blacker than your cavern’s gloom. Irritating!"
    ),
    WRETCHED_ROYALTY (
        "Wretched Royalty",
        "Bowed down only by the memories of your own lost glory, you could never submit to anyone else. Not you, of noble blood! (Not that you expect any of these peons to understand the depths of your sorrow.)"
    ), 
    HERETICAL_PRIEST (
        "Heretical Priest",
        "Hunted by the Two-Headed Basilisks of the One True Faith, this heretic can be found raving in ruins, traipsing endlessly down dusty roads and desecrating cathedrals by night."
    ),
    OCCULT_HERBMASTER (
        "Occult Herbmaster",
        "Born of the mushroom, raised in the glade, watched by the eye of the moon in a silverblack pool."
    );

    private final String className;
    private final String description;

    CharacterClass(String className, String description) {
        this.className = className;
        this.description = description;
    }

    public String className() { return className; }
    public String description() { return description; }
}
