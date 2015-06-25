package io.github.zaphodious.heroshop.gamelogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public class Encounter {

    private List<Entity> enemies;
    private List<Entity> party;

    public Encounter() {
        this.enemies = new ArrayList<Entity>();
        this.party = new ArrayList<Entity>();

    }

    public void addEnemies(Entity... entities) {
         this.enemies.addAll(Arrays.asList(entities));
    }

    public void addParty(Entity... entities) {
        this.party.addAll(Arrays.asList(entities));
    }

    public List<Entity> getEnemies() {
        return enemies;
    }

    public List<Entity> getParty() {
        return party;
    }


}
