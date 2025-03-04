package game;

import cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Field {
    // Cards on the field
    private final List<Card> cards;

    /**
     * Creates a new field with no cards.
     */
    public Field() {
        this.cards = new ArrayList<>();
    }

    /**
     * Returns the top card on the field.
     * @return the top card on the field
     */
    public Card getTopCard() {
        return this.cards.getLast();
    }

    /**
     * Removes all cards from the field except the top card.
     * @return the removed cards
     */
    public List<Card> removeAllButTopCard() {
        Card topCard = this.cards.removeLast();
        List<Card> removedCards = new ArrayList<>(this.cards);
        this.cards.clear();
        this.cards.add(topCard);
        return removedCards;
    }

    /**
     * Places a card on the field.
     * @param card the card to place on the field
     */
    public void placeCard(Card card) {
        this.cards.add(card);
    }
}
