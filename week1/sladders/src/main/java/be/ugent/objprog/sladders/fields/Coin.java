package be.ugent.objprog.sladders.fields;

import be.ugent.objprog.sladders.Field;
import be.ugent.objprog.sladders.Game;

public class Coin extends Field {

    public Coin() {
    }

    @Override
    public void handlePlayerLanded(Game game) {
        super.handlePlayerLanded(game);

        game.setCoins(game.getCoins() + 1);
    }
}
