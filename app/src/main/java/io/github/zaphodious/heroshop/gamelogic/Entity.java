package io.github.zaphodious.heroshop.gamelogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public abstract class Entity {

    protected String unlocalizedName;

    protected Map<Attribute, Integer> stats;

    protected Weapon weapon;

    protected List<Item> inventory;

    protected Entity(String unlocalizedName, Map<Attribute, Integer> stats) {
        this.unlocalizedName = unlocalizedName;
        this.stats = stats;
        inventory = new ArrayList<Item>();
    }

    protected Entity(String unlocalizedName, int... newStats) {
         this(unlocalizedName, Reference.makeAttributeMap(newStats));
    }

    protected Entity(String unlocalizedName) {
        this(unlocalizedName, Reference.makeAttributeMap());
    }

    public boolean addAttribute(Attribute attribute, int value) {
        this.stats.put(attribute, value);
        return true;
    }

    public int getAttribute(Attribute attribute) {
        return stats.get(attribute);
    }

    public boolean changeAttribute(Attribute attribute, int value) {
        if (this.stats.containsValue(attribute)) {
            this.stats.put(attribute, this.stats.get(attribute) + value);
            return true;
        }
        return false;

    }

    public Map<Attribute, Integer> getStats() {
        return stats;
    }

    public boolean addToInventory(Item item) {
        if (inventory.contains(item)) {
            inventory.get(inventory.indexOf(item)).addToStack(item.getStackSize());
        } else {
            inventory.add(item);
        }

        return true;
    }

    public void setUnlocalizedName(String unlocalizedName) {
        this.unlocalizedName = unlocalizedName;
    }

    public void equipWeapon(Weapon weapon) {
        if (this.weapon != null) this.addToInventory(this.weapon);
        this.weapon = weapon;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        StringBuilder thisGuy = new StringBuilder();
        thisGuy.append("Character Name: " + this.unlocalizedName + "\n");
        thisGuy.append("Character attributes: \n");
        for (Attribute attribute : Attribute.values()) {
            thisGuy.append(attribute.getName().toUpperCase() + ": " + this.stats.get(attribute) + "\n");
        }

        if (this.weapon != null) {
            thisGuy.append("Weapon: " + weapon.toString());
        }


        return thisGuy.toString();
    }

    public void hurt(int amount) {
        this.stats.put(Attribute.CURRENT_HEALTH, this.stats.get(Attribute.CURRENT_HEALTH) - amount);
    }

    public void makeAttackOn(Entity entity) {
        entity.hurt(this.weapon.getPower());
    }
}
