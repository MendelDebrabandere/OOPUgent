package be.ugent.objprog.vormen;

/**
 * Geeft aan welke bewerkingen er op alle ondersteunde vormen moeten worden toegestaan
 */
public interface Vorm {

    <R> R accept(VormVisitor<R> visitor);

}
