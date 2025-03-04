package cards;

public class NumberCard extends Card{

    private int value;

    /**
     * Constructor to create a card with a color.
     *
     * @param color The color of the card.
     */
    public NumberCard(String color, int value) {
        super(color);
        this.value = value;
    }

    @Override
    public String getValue() {
        return Integer.toString(value);
    }
}
