package cards;

import game.Game;

public class ReverseCard extends Card{

    /**
     * Constructor to create a card with a color.
     *
     * @param color The color of the card.
     */
    public ReverseCard(String color) {
        super(color);
    }

    @Override
    public String getValue() {
        return "Reverse Card";
    }

    @Override
    public void handleEffect(Game game) {
        game.reverseDirection();
        game.nextPlayer();
    }
}
