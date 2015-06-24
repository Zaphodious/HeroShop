package io.github.zaphodious.heroshop.gamelogic;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public class Hero extends Entity {


    public Hero(String unlocalizedName, int... newStats) {
        super(unlocalizedName, newStats);
    }

    public Hero(String unlocalizedName) {
        super(unlocalizedName);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
