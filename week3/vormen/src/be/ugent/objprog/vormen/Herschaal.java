package be.ugent.objprog.vormen;

public class Herschaal implements VormVisitor<Void>{

    double schaal;

    public Herschaal(double schaal) {
        this.schaal = schaal;
    }

    @Override
    public Void visit(Cirkel cirkel) {
        cirkel.setStraal(cirkel.getStraal() * schaal);
        return null;
    }

    @Override
    public Void visit(Rechthoek rechthoek) {
        rechthoek.setBreedte(rechthoek.getBreedte() * schaal);
        rechthoek.setHoogte(rechthoek.getHoogte() * schaal);
        return null;
    }

    @Override
    public Void visit(RechthoekigeDriehoek rechthoekigeDriehoek) {
        rechthoekigeDriehoek.setBreedte(rechthoekigeDriehoek.getBreedte() * schaal);
        rechthoekigeDriehoek.setHoogte(rechthoekigeDriehoek.getHoogte() * schaal);
        return null;
    }

    public static Void of (Vorm vorm, double schaal) {
        return vorm.accept(new Herschaal(schaal));
    }
}
