package game;

import cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    // Cards in the hand
    private final List<Card> cards;

    /**
     * Creates a new hand with no cards.
     */
    public Hand() {
        this.cards = new ArrayList<>();
    }

    /**
     * Adds a card to the hand.
     * @param card The card to add to the hand.
     */
    public void giveCard(Card card) {
        this.cards.add(card);
    }

    /**
     * Adds a list of cards to the hand.
     * @param cards The list of cards to add to the hand.
     */
    public void giveCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    /**
     * Returns the card at the specified index.
     * @param index The index of the card to return.
     * @return the card at the specified index
     */
    public Card getCardAt(int index) {
        return this.cards.get(index);
    }

    /**
     * Removes and returns the card at the specified index.
     * @param index The index of the card to remove.
     * @return the card at the specified index
     */
    public Card takeCardAt(int index) {
        return this.cards.remove(index);
    }

    /**
     * The number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size() {
        return this.cards.size();
    }
}
