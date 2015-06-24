package io.github.zaphodious.heroshop;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import io.github.zaphodious.heroshop.gamelogic.Hero;
import io.github.zaphodious.heroshop.gamelogic.Reference;
import io.github.zaphodious.heroshop.gamelogic.Weapon;


public class MainGameView extends ActionBarActivity {

    Hero hero;
    Hero enemy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game_view);
        this.makeHeroAndVillan();

        writeCharacterInfo();
    }

    public void writeCharacterInfo() {
        setContentView(R.layout.activity_main_game_view);
        TextView textView =(TextView)findViewById(R.id.heroInfo);
        textView.setText(hero.toString());
        textView = (TextView) findViewById(R.id.enemyInfo);
        textView.setText(enemy.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_game_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void makeHeroAndVillan() {
        hero = new Hero("galfankis");
        enemy = new Hero("zarkadon");

        hero.equipWeapon(new Weapon("GreatAxe", Reference.rand.nextInt(4)+1, 2));
        enemy.equipWeapon(new Weapon("LongSword", Reference.rand.nextInt(4)+1, 2));
    }

    public void makeRandomHero(View view) {


        setContentView(R.layout.activity_main_game_view);

        this.makeHeroAndVillan();

        this.writeCharacterInfo();


        System.out.println("New characters!");
    }

    public void combatRound(View view) {
        setContentView(R.layout.activity_main_game_view);

        hero.makeAttackOn(enemy);
        enemy.makeAttackOn(hero);

        this.writeCharacterInfo();


        // Create the text view
        /*TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(hero.toString());

        // Set the text view as the activity layout
        setContentView(textView);*/

        System.out.println("An attack has been made!");
    }
}
