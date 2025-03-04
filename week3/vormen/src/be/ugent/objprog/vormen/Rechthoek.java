package be.ugent.objprog.vormen;

public class Rechthoek extends RechteVorm {

    public Rechthoek(double breedte, double hoogte) {
        super(breedte, hoogte);
    }

    @Override
    public <R> R accept(VormVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
