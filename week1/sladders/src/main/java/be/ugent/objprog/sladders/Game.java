package be.ugent.objprog.sladders;

import be.ugent.objprog.sladders.fields.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.HashMap;
import java.util.Random;

/**
 * Bevat de modellen (worp, positie) en de velden.
 */
public class Game {

    private final IntegerProperty die;
    private final IntegerProperty position;
    private final BooleanProperty gameOver;

    private final Field[] fields;

    // HIER VELDEN TOEVOEGEN
    private final IntegerProperty coins;
    
    public Game() {
        die = new SimpleIntegerProperty(0);
        position = new SimpleIntegerProperty(1);
        coins = new SimpleIntegerProperty(0);
        gameOver = new SimpleBooleanProperty(false);


        // Define special fields using a Map
        HashMap<Integer, Field> specialFields = new HashMap<>();

        specialFields.put(2, new Ladder(19));
        specialFields.put(9, new Ladder(23));
        specialFields.put(21, new Ladder(46));
        specialFields.put(34, new Ladder(48));
        specialFields.put(43, new Ladder(55));

        specialFields.put(20, new Slang(5));
        specialFields.put(40, new Slang(12));
        specialFields.put(53, new Slang(28));
        specialFields.put(63, new Slang(29));

        specialFields.put(11, new Coin());
        specialFields.put(32, new Coin());
        specialFields.put(39, new Coin());
        specialFields.put(51, new Coin());

        specialFields.put(27, new Teleport());
        specialFields.put(60, new Teleport());

        specialFields.put(64, new Ster());

        fields = new Field[65]; // 0 wordt niet gebruikt

        for (int i = 1; i <= 64; i++) {
            if (specialFields.containsKey(i)) {
                fields[i] = specialFields.get(i);
            } else {
                fields[i] = new Field();
            }

        }



        // HIER TOEVOEGEN
    }

    public IntegerProperty positionProperty() {
        return position;
    }

    public IntegerProperty dieProperty() {
        return die;
    }

    public BooleanProperty gameOverProperty() {
        return gameOver;
    }

    public int getPosition() {
        return position.get();
    }
    
    public void setPosition(int target) {
        position.set(target);
    }

    public int getDie() {
        return die.get();
    }

    public void setGameOver() {
        gameOver.set(true);
    }

    private static final Random RG = new Random();

    public void rollDie() {
        die.set(RG.nextInt(6) + 1);
        int newPosition = position.get() + die.get();
        if (newPosition > 64) {
            newPosition = 64 - (newPosition - 64);
        }
        position.set(newPosition);

        // HIER TOEVOEGEN
        fields[position.get()].handlePlayerLanded(this);
    }


    // HIER METHODES TOEVOEGEN
    public int getCoins() {
        return coins.get();
    }

    public void setCoins(int newVal) {
        coins.set(newVal);
    }


}
