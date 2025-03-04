package be.ugent.objprog.sladders.fields;

import be.ugent.objprog.sladders.Field;
import be.ugent.objprog.sladders.Game;

public class Ladder extends Field {

    private final int goalPos;

    public Ladder(int goalPos) {
        this.goalPos = goalPos;
    }


    @Override
    public void handlePlayerLanded(Game game) {
        //super.handlePlayerLanded(game);

        game.setPosition(goalPos);

    }
}
