package be.ugent.objprog.bss;

import java.util.HashMap;

/**
 * Model van het spel. Houdt bij wie er al gespeeld heeft, wat die gespeeld heeft en wie uiteindelijk de winnaar was
 */
public class Model {

    private HashMap<Integer, BladSteenSchaarPartner> spelers;

    private HashMap<Integer, BSS> playedMoves;

    private int prevGameWinner;

    public Model() {
        spelers = new HashMap<>();
        playedMoves = new HashMap<>();
        prevGameWinner = 0;
    }


    /**
     * Hiermee registreren de beide objecten van de partnerklasse (de partners) zich bij het model. Hou bij welk object
     * bij welke speler hoort.
     */
    public void registreer (int speler, BladSteenSchaarPartner partner) {
        // TODO
        spelers.put(speler, partner);
    }

    /**
     *  Wordt door de partners opgeroepen om aan te geven welke keuze de gegeven speler heeft gemaakt
     */
    public void speel (BSS bss, int speler) {
        // TODO
        if (!playedMoves.containsKey(speler)) {
            playedMoves.put(speler, bss);
            checkForWinner();
        }
    }

    private void checkForWinner() {
        if (playedMoves.size() == 2) {
            prevGameWinner = BSS.gameOutcomeVersus(playedMoves.get(1), playedMoves.get(2));
            spelers.get(1).eindeBeurt();
            spelers.get(2).eindeBeurt();
            resetGame();
        }
    }

    private void resetGame() {
        playedMoves = new HashMap<>();
    }


    /** Wordt door de partners opgeroepen om te weten wie de winnaar is
     * @return 0=geen winnaar, 1=speler 1 wint, 2=speler 2 wint
     */
    public int getWinnaar() {
        return prevGameWinner; // TODO
    }
}
