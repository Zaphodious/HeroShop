package io.github.zaphodious.heroshop.gamelogic;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public enum Attribute {
    GOLD("gold", 0),
    EXPERIENCE("experience", 1),
    MAX_HEALTH("max_health", 2),
    CURRENT_HEALTH("current_health", 3),
    ACTION_POINTS("action_points", 4),
    ATK_STRENGTH("atk_strength", 5),
    ATK_DEXTERITY("atk_dexterity", 6),
    ATK_INTELLIGENCE("atk_intelligence", 7),
    DEF_STRENGTH("def_strength", 8),
    DEF_DEXTERITY("def_dexterity", 9),
    DEF_INTELLIGENCE("def_intelligence", 10);


    private String name;
    private int index;

    Attribute(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public static Attribute getAttributeForIndex(int queryIndex) {
        for (Attribute attribute: Attribute.values()) {
            if (attribute.getIndex() == queryIndex) return attribute;
        }

        return null;
    }
}
