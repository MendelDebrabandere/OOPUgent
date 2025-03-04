import java.util.Optional;
import java.util.Scanner;

public final class UnoCli {
    public static final String CLEAR_TERMINAL_STRING = System.lineSeparator().repeat(50);

    private final Scanner scanner;

    /**
     * Create a new UnoCli instance.
     */
    public UnoCli() {
        this.scanner = new Scanner(System.in);
        clearTerminal();
    }

    /**
     * Display a message to the user.
     *
     * @param message The message to display.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Display a message to the user and wait for input.
     *
     * @param message The message to display.
     * @return The input from the user.
     */
    public Optional<String> waitForInput(String message) {
        try {
            displayMessage(message);
            return Optional.of(scanner.nextLine());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Display a message to the user and wait for input.
     *
     * @param message The message to display.
     * @param parser  The parser to use to parse the input.
     * @param <T>     The type of the parsed input.
     * @return The parsed input from the user.
     */
    public <T> Optional<T> waitForInput(String message, InputParser<T> parser) {
        try {
            displayMessage(message);
            return Optional.of(parser.parse(scanner.nextLine()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    /**
     * Clear the terminal by printing a lot of newlines.
     */
    public void clearTerminal() {
        System.out.print(CLEAR_TERMINAL_STRING);
    }
}
