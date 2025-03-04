package be.ugent.objprog.vormen;

public class Cirkel implements Vorm {

    private double straal;

    public Cirkel(double straal) {
        this.straal = straal;
    }

    public double getStraal() {
        return straal;
    }

    public void setStraal(double straal) {
        this.straal = straal;
    }

    @Override
    public Vorm kopie() {
        return new Cirkel(straal);
    }

    @Override
    public <R> R accept(VormVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
