package fractions;

/**
 * Eenvoudige uitdrukking. Bestaat uit één enkele string.
 */
public class Simple extends Expression {

    private String text;

    public Simple(String text) {
        this.text = text;
    }

    // code niet wijzigen! Wordt gebruikt om te debuggen.
    public String toString() {
        return text;
    }

    @Override
    public void computeWidth() {
        // TODO
        // De breedte van een simple is de lengte van de corresponderende string.
        width = text.length();
    }

    @Override
    public void computeHeightAndDepth() {
        // TODO
    }

    @Override
    public void computeCoordinates() {
        // TODO
    }

    @Override
    public char charAt(int rij, int kolom) {
        return ' '; // TODO
    }
}
