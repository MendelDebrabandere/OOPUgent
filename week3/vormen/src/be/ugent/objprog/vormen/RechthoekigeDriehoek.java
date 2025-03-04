package be.ugent.objprog.vormen;

public class RechthoekigeDriehoek extends RechteVorm {

    public RechthoekigeDriehoek(double breedte, double hoogte) {
        super(breedte, hoogte);
    }

    @Override
    public <R> R accept(VormVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
