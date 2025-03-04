package cards;

import game.Game;

public class WildTakeCard extends Card{
    /**
     * Constructor to create a card with a color.
     */
    public WildTakeCard() {
        super("\033[39m");
    }

    @Override
    public String getValue() {
        return "Wild take card";
    }

    @Override
    public boolean isWildCard() {
        return true;
    }

    @Override
    public void handleEffect(Game game) {
        game.nextPlayer();
        game.drawCards(4);
        game.nextPlayer();
    }
}
