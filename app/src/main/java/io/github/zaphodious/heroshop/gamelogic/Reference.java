package io.github.zaphodious.heroshop.gamelogic;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public class Reference {
    public static int DEFAULT_MAX_STACK_SIZE = 42000;
    public static Random rand = new Random();

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

    public static Map<Attribute, Integer> makeAttributeMap() {
        int[] values = new int[Attribute.values().length];
        for (int i = 0; i < Attribute.values().length; i++) {
            values[i] = rand.nextInt(15)+3;
        }

        return makeAttributeMap(values);
    }
}
