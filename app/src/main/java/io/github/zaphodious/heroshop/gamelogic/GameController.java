package io.github.zaphodious.heroshop.gamelogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by achyt_000 on 6/24/2015.
 */
public class GameController {

    private Hero playerCharacter;
    private Hero sideKick;
    private List<Hero> employees;


    public GameController() {
        playerCharacter = new Hero("Marco");
        sideKick = new Hero("Zabroni");
        employees = new ArrayList<Hero>();
    }


    public void nameThePlayer(String name) {
        playerCharacter.rename(name);
    }

    public Hero getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(Hero playerCharacter) {
        this.playerCharacter = playerCharacter;
    }




}
