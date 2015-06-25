package io.github.zaphodious.heroshop.gamelogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public abstract class Entity {

    protected String name;

    protected Map<Attribute, Integer> stats;

    protected Weapon weapon;

    protected List<Item> inventory;

    protected Entity(String name, Map<Attribute, Integer> stats) {
        this.name = name;
        this.stats = stats;
        inventory = new ArrayList<Item>();
    }

    protected Entity(String name, int... newStats) {
         this(name, StatMaker.makeAttributeMap(newStats));
    }

    protected Entity(String name, int experience) {

    }

    protected Entity(String name) {
        this(name, StatMaker.makeAttributeMap(Reference.rand));
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

    public void setName(String name) {
        this.name = name;
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
        thisGuy.append("Character Name: " + this.name + "\n");
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

    public void rename(String newName) {
        this.name = newName;
    }
}

class StatMaker {
    public static Map<Attribute, Integer> makeAttributeMap(int[] values) {
        Map<Attribute, Integer> theseStats = new HashMap<Attribute, Integer>();
        try {

            for (int i = 0; i < Attribute.values().length; i++) {
                theseStats.put(Attribute.getAttributeForIndex(i), values[i]);
            }
        } catch (Exception e) {
            System.out.println("You fool! You can't make a new Entity with less then " + (Attribute.values().length) + " attribute values!");
            e.printStackTrace();
        }

        return theseStats;
    }

    public static Map<Attribute, Integer> makeAttributeMap(){
        return makeAttributeMap(makeBasicAttributeArray());
    }

    public static Map<Attribute, Integer> makeAttributeMap(Random rand) {
        int[] values = new int[Attribute.values().length];
        for (int i = 0; i < Attribute.values().length; i++) {
            values[i] = rand.nextInt(11)+7;
        }

        return makeAttributeMap(values);
    }


    public static Map<Attribute, Integer> makeAttributeMap(Random rand, int experience) {
        int[] values = new int[Attribute.values().length];
        for (int i = 0; i < Attribute.values().length; i++) {
            values[i] = rand.nextInt((Reference.WHAT_LEVEL(experience)+7)*2)+(Reference.WHAT_LEVEL(experience));
        }

        return makeAttributeMap(values);
    }

    public static Map<Attribute, Integer> makeAttributeMap(Random rand, int experience, Attribute... attributes){
        Map<Attribute, Integer> toReturn = makeAttributeMap(makeBasicAttributeArray());

        List<Attribute> selected = Arrays.asList(attributes);

        int thisLevel = Reference.WHAT_LEVEL(experience);

        for (Attribute thisAttribute : Attribute.values()) {
            int newAttributeValue = toReturn.get(thisAttribute);
            if (selected.contains(thisAttribute)) {
                newAttributeValue += (rand.nextInt(thisLevel*2));
            } else {
                newAttributeValue += (rand.nextInt(thisLevel*2)-(thisLevel/2));
            }
            toReturn.put(thisAttribute, newAttributeValue);
        }

        return toReturn;
    }

    private static int[] makeBasicAttributeArray() {
        int[] values = new int[Attribute.values().length];
        for (int i = 0; i < Attribute.values().length; i++) {
            values[i] = 7;
        }
        return values;
    }

}