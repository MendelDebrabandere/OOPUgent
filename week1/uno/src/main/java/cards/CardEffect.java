package cards;

import game.Game;

public interface CardEffect {
    /**
     * Handle the effect of a card on the current game.
     * @param game The game to handle the effect on.
     */
    void handleEffect(Game game);
}
