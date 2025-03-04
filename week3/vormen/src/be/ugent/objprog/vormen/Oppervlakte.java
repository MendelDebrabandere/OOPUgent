package be.ugent.objprog.vormen;

public class Oppervlakte implements VormVisitor<Double> {
    @Override
    public Double visit(Cirkel cirkel) {
        return cirkel.getStraal() * cirkel.getStraal() * Math.PI;
    }

    @Override
    public Double visit(Rechthoek rechthoek) {
        return rechthoek.getHoogte() * rechthoek.getBreedte();
    }

    @Override
    public Double visit(RechthoekigeDriehoek rechthoekigeDriehoek) {
        return rechthoekigeDriehoek.getHoogte() * rechthoekigeDriehoek.getBreedte() / 2;
    }

    public static double of (Vorm vorm) {
        return vorm.accept(new Oppervlakte());
    }

}
