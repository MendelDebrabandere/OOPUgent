package game;

import cards.*;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    // The deck of cards
    protected List<Card> cards;

    /**
     * Create a new deck of 108 UNO cards, each deck consists of:
     * - 0, one of each color (4 cards)
     * - 1-9, two of each color (72 cards)
     * - Skip, Reverse, Draw Two, two of each color (24 cards)
     * - Wild, four cards (4 cards)
     * - Wild Draw Four, four cards (4 cards)
     */
    public Deck() {
        // TODO: Implement the creation of a deck of UNO cards

        String[] colors = { "\033[31m", "\033[32m", "\033[33m", "\033[34m" };

        cards = new ArrayList<Card>();

        // 0, one of each color (4 cards)
        for (int i = 0; i < 4; i++) {
            cards.add(new NumberCard(colors[i], 0));
        }
        // 1-9, two of each color (72 cards)
        for (int i = 0; i < 72; i++) {
            cards.add(new NumberCard(colors[i%4], i/4));
        }
        // Skip, Reverse, Draw Two, two of each color (24 cards)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; i < 2; i++) {
                cards.add(new SkipCard(colors[i]));
                cards.add(new ReverseCard(colors[i]));
                cards.add(new ColoredTakeCard(colors[i]));
            }
        }
        // Wild, four cards (4 cards)
        for (int i = 0; i < 4; i++) {
            cards.add(new ColorChangeCard());
        }
        // Wild Draw Four, four cards (4 cards)
        for (int i = 0; i < 4; i++) {
            cards.add(new WildTakeCard());
        }




    }

    /**
     * Add a list of cards to the deck
     * @param cards The list of cards to add to the deck
     */
    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    /**
     * Draw a single card from the deck
     * @return The card drawn from the deck
     */
    public Card drawCard() {
        Card card =  cards.getLast();
        cards.removeLast();
        return card;
    }

    /**
     * Draw n cards from the deck
     * @param n The number of cards to draw
     * @return A list of cards drawn from the deck
     */
    public List<Card> drawCards(int n) {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0;  i < n;  i++) {
            drawnCards.add(drawCard());
        }
        return drawnCards;
    }

    /**
     * Get the number of cards in the deck
     * @return The number of cards in the deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * Shuffle (Fisher-Yates) the deck of cards
     */
    public void shuffle() {
        for (int i = cards.size() - 1;  i > 0;  i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }
}
