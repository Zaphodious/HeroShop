package io.github.zaphodious.heroshop.gamelogic;

import java.util.Random;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public class Reference {
    public static GameController instance = new GameController();


    public static int DEFAULT_MAX_STACK_SIZE = 42000;
    public static Random rand = new Random();

    public static int WHAT_LEVEL(int experience) {
        return experience / 100;
    }

    public static int EXPERIENCE_GAIN(int victorExperience, int deadExperience) {

        int victorLevel = WHAT_LEVEL(victorExperience);
        int deadLevel = WHAT_LEVEL(deadExperience);

        if (victorLevel - deadLevel > 5) {
            return 1;
        } else if (deadLevel < victorLevel) {
            return 2;
        }

        return (deadLevel - victorLevel) + 3;
    }



}
