package fractions;

import java.util.List;

/**
 * Een reeks uitdrukkingen die naast elkaar worden afgebeeld, met telkens
 * één spatie ertussen
 */
public class Sequence extends Expression {

    public Sequence(List<Expression> children) {
        this.children = children;
    }

    private List<Expression> children;

    // code niet wijzigen! Wordt gebruikt om te debuggen.
    public String toString() {
        if (children.isEmpty()) {
            return "{}";
        } else {
            StringBuilder result = new StringBuilder();
            for (Expression child : children) {
                result.append(" ").append(child);
            }
            return "{" + result.substring(1) + "}";
        }
    }


    @Override
    public void computeWidth() {
        // TODO
        // De breedte van een sequence is de som van de breedten van zijn kinderen,
        // + 1 voor elke spatie die je tussen twee opeenvolgende kinderen zult plaatsen.
        children.forEach(Expression::computeWidth);
        width = children.stream().mapToInt(Expression::getWidth).sum();
        width += children.size() - 1; // +1 spatie tussen elk kind
    }

    @Override
    public void computeHeightAndDepth() {
        // TODO
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

