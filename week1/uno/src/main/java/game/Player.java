package game;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {
    // The name of the player
    private final String name;

    // The hand of the player
    private final Hand hand;

    /**
     * Creates a new player with the specified name and empty hand.
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    /**
     * Get the name of the player.
     * @return The name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the hand of the player.
     * @return The hand of the player.
     */
    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return IntStream
                .range(0, hand.size())
                .mapToObj(i -> i + ": " + hand.getCardAt(i) + "    ")
                .collect(Collectors.joining());
    }
}
