package io.github.zaphodious.heroshop.gamelogic;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public class Weapon extends Item {

    private int power;
    private int durability;

    public Weapon(String name, int power, int durability) {
        super(name);
        this.power = power;
        this.durability = durability;
    }

    public int getPower() {
        return power;
    }

    public int getDurability() {
        return durability;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + getDurability() * 10 + getPower();
    }

    @Override
    public String toString() {
        return name + ": " +
                "power=" + power +
                ", durability=" + durability;
    }
}
