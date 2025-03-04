package be.ugent.objprog.eightqueens;

/**
 * Luisteraar voor het {@link EightQueensModel}
 */
public interface EightQueensListener {

    /**
     * Deze methode wordt door het model opgeroepen telkens wanneer er iets
     * aan (de gegevens in) het model verandert.
     */
    void modelHasChanged ();

}
