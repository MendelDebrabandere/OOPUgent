package cards;

import game.Game;

public abstract class Card implements CardEffect {
    // The color of the card.
    private String color;

    /**
     * Constructor to create a card with a color.
     * @param color The color of the card.
     */
    public Card(String color) {
        this.color = color;
    }

    /**
     * Get the color of the card.
     * @return The color of the card.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Set the color of the card.
     * @param color The color of the card.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Check if the card is a wild card.
     * @return True if the card is a wild card, false otherwise.
     */
    public boolean isWildCard() {
        return false;
    }

    /**
     * Get the value of the card as a string.
     * @return The value of the card.
     */
    public abstract String getValue();

    @Override
    public void handleEffect(Game game) {
        game.nextPlayer();
    }

    @Override
    public String toString() {
        return getColor() + getValue() + "\033[0m";
    }
}
