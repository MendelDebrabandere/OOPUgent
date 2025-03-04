package be.ugent.objprog.sladders.fields;

import be.ugent.objprog.sladders.Field;
import be.ugent.objprog.sladders.Game;

public class Ster extends Field {
    @Override
    public void handlePlayerLanded(Game game) {
        super.handlePlayerLanded(game);

        game.setGameOver();
    }
}
