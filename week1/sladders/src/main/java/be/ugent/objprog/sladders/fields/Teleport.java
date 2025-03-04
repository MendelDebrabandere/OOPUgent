package be.ugent.objprog.sladders.fields;

import be.ugent.objprog.sladders.Field;
import be.ugent.objprog.sladders.Game;

import java.util.Random;

public class Teleport extends Field {

    private static final Random RG = new Random();

    @Override
    public void handlePlayerLanded(Game game) {
        super.handlePlayerLanded(game);

        game.setPosition(RG.nextInt(63) + 1);

    }
}
