package cards;

public class ColorChangeCard extends Card{
    /**
     * Constructor to create a card with a color.
     */
    public ColorChangeCard() {
        super("\033[39m");
    }

    @Override
    public String getValue() {
        return "Color changing card";
    }

    @Override
    public boolean isWildCard() {
        return true;
    }
}
