package be.ugent.objprog.vormen;

public class IsSymmetrisch implements VormVisitor<Boolean> {
    @Override
    public Boolean visit(Cirkel cirkel) {
        return true;
    }

    @Override
    public Boolean visit(Rechthoek rechthoek) {
        return rechthoek.getBreedte() == rechthoek.getHoogte();
    }

    @Override
    public Boolean visit(RechthoekigeDriehoek rechthoekigeDriehoek) {
        return rechthoekigeDriehoek.getBreedte() == rechthoekigeDriehoek.getHoogte();
    }

    public static boolean of (Vorm vorm) {
        return vorm.accept(new IsSymmetrisch());
    }
}
