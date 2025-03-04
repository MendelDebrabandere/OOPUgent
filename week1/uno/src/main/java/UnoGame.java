import cards.Card;
import game.Game;
import game.Player;

import java.util.Optional;

public class UnoGame  {
    private static final String ADD_NEW_PLAYER_STRING = "Add new player (press a) or start the game (press c)";
    private static final String PLAYING_FIELD_STRING = "Current player: %s\n\n\t\t%s\n";
    private static final String CHOOSE_CARD_STRING = "Choose a card from your hand to play or else draw a card from the deck:\n%s\n";

    public static void main(String[] args) {
        UnoCli unoCli = new UnoCli();

        Game game = new Game();

        Optional<String> input;
        do {
            input = unoCli.waitForInput(ADD_NEW_PLAYER_STRING);
            if (input.isPresent() && input.get().equals("a")) {
                unoCli.waitForInput("Enter player name:").ifPresent(n -> game.addPlayer(new Player(n)));
            }
            unoCli.clearTerminal();
        } while (game.amountOfPlayers() < 2 || (input.isPresent() && !input.get().equals("c")));

        String[] colors = { "\033[31m", "\033[33m", "\033[32m", "\033[34m" };
        while (!game.finished()) {
            Player currentPlayer = game.getCurrentPlayer();

            unoCli.clearTerminal();
            unoCli.displayMessage(String.format(PLAYING_FIELD_STRING, currentPlayer.getName(), game.GetFieldTopCard()));

            Optional<Integer> selectedCardIndex = unoCli.waitForInput(
                    String.format(CHOOSE_CARD_STRING, currentPlayer),
                    Integer::parseInt
            );

            if (selectedCardIndex.isEmpty()) {
                game.drawCards(1);
                game.nextPlayer();
            } else {
                Card card = currentPlayer.getHand().getCardAt(selectedCardIndex.get());

                if (game.canPlayCard(card)) {
                    if (card.isWildCard()) {
                        unoCli.displayMessage("Choose a color:");
                        unoCli.waitForInput(
                                "0: \033[31mRed\033[0m    1: \033[33mYellow\033[0m    2: \033[32mGreen\033[0m    3: \033[34mBlue\033[0m",
                                Integer::parseInt
                        ).ifPresent(i -> card.setColor(colors[i]));
                    }

                    game.playCard(selectedCardIndex.get());
                }
            }
        }
    }
}
