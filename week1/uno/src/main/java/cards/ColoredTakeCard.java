package cards;

import game.Game;

public class ColoredTakeCard extends Card{
    /**
     * Constructor to create a card with a color.
     *
     * @param color The color of the card.
     */
    public ColoredTakeCard(String color) {
        super(color);
    }

    @Override
    public String getValue() {
        return "Colored take card";
    }

    @Override
    public void handleEffect(Game game) {
        game.nextPlayer();
        game.drawCards(2);
        game.nextPlayer();
    }
}
