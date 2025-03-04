package be.ugent.objprog.sladders.fields;

import be.ugent.objprog.sladders.Field;
import be.ugent.objprog.sladders.Game;

public class Slang extends Field {

    private final int goalPos;

    public Slang(int goalPos) {
        this.goalPos = goalPos;
    }

    @Override
    public void handlePlayerLanded(Game game) {
        //super.handlePlayerLanded(game);

        if (game.getCoins() >= 1){
            game.setCoins(game.getCoins() - 1);
        } else {
            game.setPosition(goalPos);
        }

    }
}
