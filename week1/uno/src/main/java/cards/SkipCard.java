package cards;

import game.Game;

public class SkipCard extends Card{
    /**
     * Constructor to create a card with a color.
     *
     * @param color The color of the card.
     */
    public SkipCard(String color) {
        super(color);
    }

    @Override
    public String getValue() {
        return "Skip card";
    }

    @Override
    public void handleEffect(Game game) {
        game.nextPlayer();
        game.nextPlayer();
    }
}
