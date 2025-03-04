package be.ugent.objprog.vormen;

public interface VormVisitor <T> {
    T visit(Cirkel cirkel);
    T visit(Rechthoek rechthoek);
    T visit(RechthoekigeDriehoek rechthoekigeDriehoek);
}
