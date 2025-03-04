package game;

import cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    // The players of the game
    private final List<Player> players;

    // The index of the current player
    private int currentPlayerIndex;

    // The direction of the game (1 for clockwise, -1 for counter-clockwise)
    private int direction;

    // The deck of invisible cards (that players draw from)
    private final Deck deck;

    // The field where the cards are played
    private final Field field;

    /**
     * Creates a new game with no players, a shuffled deck of cards,
     * and a field with a valid starting card. Wild cards are not allowed as
     * the starting card. Special effects of the starting card are not applied.
     */
    public Game() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;

        // The game starts with the direction being clockwise
        this.direction = 1;

        // Create a new deck of Uno cards and shuffle it
        this.deck = new Deck();
        this.deck.shuffle();

        // Draw the first card from the deck and place it on the field
        // Note: This card cannot be a wild card
        this.field = new Field();
        Card card = deck.drawCard();
        while (card.isWildCard()) {
            this.field.placeCard(card);
            card = deck.drawCard();
        }
        this.field.placeCard(card);
    }

    /**
     * Add a player to the game and give them 7 cards from the deck.
     * @param player The player to add to the game.
     */
    public void addPlayer(Player player) {
        players.add(player);

        // Draw 7 cards from the deck for this player
        for (int i = 0; i < 7; i++) {
            player.getHand().giveCard(deck.drawCard());
        }
    }

    /**
     * Move to the next player in the game.
     */
    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + direction + players.size()) % players.size();
    }

    /**
     * Get the current player in the game.
     * @return The current player in the game.
     */
    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    /**
     * Get the number of players in the game.
     * @return The number of players in the game.
     */
    public int amountOfPlayers() {
        return players.size();
    }

    /**
     * Check if the game has finished.
     * @return True if one of the players has no cards left, false otherwise.
     */
    public boolean finished() {
        return players.stream().anyMatch(p -> p.getHand().size() == 0);
    }

    /**
     * Reverse the direction of the game.
     */
    public void reverseDirection() {
        direction *= -1;
    }

    /**
     * Draw n cards from the deck for the current player.
     * If the deck does not have enough cards, the field is reshuffled.
     * @param n The number of cards to draw.
     */
    public void drawCards(int n) {
        // If the deck does not have enough cards, we need to reshuffle the field
        if (n > deck.size()) {
            getCurrentPlayer().getHand().giveCards(deck.drawCards(deck.size()));
            List<Card> cards = field.removeAllButTopCard();
            deck.addCards(cards);
            deck.shuffle();
        } else {
            getCurrentPlayer().getHand().giveCards(deck.drawCards(n));
        }
    }

    /**
     * Check if the current player can play a card. a card can be played
     * if it has the same color, value, or is a wild card.
     * @param card The card to check if it can be played.
     * @return True if the card can be played, false otherwise.
     */
    public boolean canPlayCard(Card card) {
        return field.getTopCard().getColor().equals(card.getColor())
                || field.getTopCard().getValue().equals(card.getValue())
                || card.isWildCard();
    }

    /**
     * Play a card from the current player's hand.
     * @param index The index of the card to play.
     */
    public void playCard(int index) {
        Card card = getCurrentPlayer().getHand().takeCardAt(index);
        field.placeCard(card);
        card.handleEffect(this);
    }

    /**
     * Get the top card on the field.
     * @return The top card on the field.
     */
    public Card GetFieldTopCard() {
        return field.getTopCard();
    }
}
