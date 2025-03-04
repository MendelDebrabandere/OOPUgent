package be.ugent.objprog.eightqueens;

import java.util.ArrayList;
import java.util.List;

/**
 * Model voor deze toepassing. Bevat alle gegevens die nodig zijn om het bord te kunnen afbeelden.
 */
public class EightQueensModel {

    /*
     * Je zal wellicht enkele velden nodig hebben om informatie bij te houden over waar de koninginnen
     * staan en of een veld door een koningin bedreigt wordt of niet.
     *
     * Je mag aannemen dat het bord dat we gebruiken steeds 8 rijen en 8 kolommen heeft.
     *
     * Tip: houd van elke veld bij *hoeveel keer* het wordt bedreigt, dit maakt het eenvoudiger om
     * een koningin terug weg te nemen zonder dat je alle gegevens opnieuw moet herberekenen.
     */


    private record IntPaar(int x, int y){};


    private boolean[][] queens;
    private List<EightQueensListener> listeners;

    /**
     * Het hoofdprogramma roept de constructor zonder argumenten op om een nieuw model aan te maken.
     */
    public EightQueensModel() {
        queens = new boolean[8][8];
        listeners = new ArrayList<>();
    }

    /**
     * Deze methode wordt gebruikt door de luisteraars om zichzelf bij het model te registreren.
     * @param listener Luisteraar die moet worden geregistreerd.
     */
    public void registerListener(EightQueensListener listener) {
        listeners.add(listener);
    }

    /*
     * Onderstaande methoden worden gebruikt door luisteraars om te weten  hoe het bord eruit ziet
     */

    /**
     * Staat er een dame op de gegeven positie?
     * @param row Rijnummer van de bedoelde positie (0..7)
     * @param column Kolomnummer van de bedoelde positie (0..7)
     */
    public boolean hasQueen (int row, int column) {
        return queens[row][column];
    }

    /**
     * Wordt de gegeven positie bedreigd?
     * @param row Rijnummer van de bedoelde positie (0..7)
     * @param column Kolomnummer van de bedoelde positie (0..7)
     */
    public boolean isThreatened (int row, int column) {
        for (int i = 0; i < 8; i++) {
            // check horizontaal en verticaal
            if (queens[i][column] || queens[row][i]) {
                return true;
            }
            // check + + diagonaal
            if (row+i < 8 && column+i < 8) {
                if (queens[row+i][column+i]) {
                    return true;
                }
            }
            // check - - diagonaal
            if (row-i >= 0 && column-i >= 0) {
                if (queens[row-i][column-i]) {
                    return true;
                }
            }
            // check - + diagonaal
            if (row-i >= 0 && column+i < 8) {
                if (queens[row-i][column+i]) {
                    return true;
                }
            }
            // check + - diagonaal
            if (row+i < 8 && column-i >= 0) {
                if (queens[row+i][column-i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Onderstaande methoden worden gebruikt door de controllers om de inhoud van het bord te veranderen.
     * Let erop dat je bij elke verandering *alle* luisteraars op de hoogte brengt dat er iets is veranderd
     * door hun methode {@link EightQueensListener#modelHasChanged} op te roepen.
     */

    /**
     * Als er een koningin staat op de gegeven positie, verwijder ze dan
     * Is het veld leeg, en wordt het niet bedreigd, plaats dan een koningin.
     * Is het veld leeg en wordt het veld wel bedreigd, dan doe je niets.
     * @param row Rijnummer van de bedoelde positie (0..7)
     * @param column Kolomnummer van de bedoelde positie (0..7)
     *
     */
    public void toggleQueen(int row, int column) {
        queens[row][column] = !queens[row][column];
        updateListeners();
    }


    /**
     * Maak het veld volledig leeg.
     */
    public void cleanAll () {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                queens[i][j] = false;
            }
        }
        updateListeners();
    }

    private void updateListeners() {
        for (EightQueensListener listener : listeners) {
            listener.modelHasChanged();
        }
    }

}
