package be.ugent.objprog.vormen;

public class Kopie implements VormVisitor<Vorm>{
    @Override
    public Vorm visit(Cirkel cirkel) {
        return new Cirkel(cirkel.getStraal());
    }

    @Override
    public Vorm visit(Rechthoek rechthoek) {
        return new Rechthoek(rechthoek.getBreedte(), rechthoek.getHoogte());
    }

    @Override
    public Vorm visit(RechthoekigeDriehoek rechthoekigeDriehoek) {
        return new Rechthoek(rechthoekigeDriehoek.getBreedte(), rechthoekigeDriehoek.getHoogte());
    }

    public static Vorm of (Vorm vorm) {
        return vorm.accept(new Kopie());
    }
}
