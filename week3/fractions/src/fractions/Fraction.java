package fractions;

/**
 * Een teller en noemer met een breukstreep ertussen. Teller en noemer zijn horizontaal
 * gecenteerd. Breukstreep staat op de 'baseline'.
 */
public class Fraction extends Expression {

    private Expression top;

    private Expression bottom;

    public Fraction(Expression top, Expression bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    // code niet wijzigen! Wordt gebruikt om te debuggen.
    public String toString() {
        return "[" + top + "/" + bottom + "]";
    }

    @Override
    public void computeWidth() {
        // TODO
        // De breedte van een fraction is het maximum van de breedtes van teller en noemer,
        // + 2 omdat de breukstreep aan beide kanten 1 letterteken uitsteekt.
        top.computeWidth();
        bottom.computeWidth();
        width = Math.max(top.getWidth(), bottom.getWidth()) + 2;
    }

    @Override
    public void computeHeightAndDepth() {
        // TODO
        top.computeHeightAndDepth();
        bottom.computeHeightAndDepth();
        
        children.forEach(Expression::computeHeightAndDepth);

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
