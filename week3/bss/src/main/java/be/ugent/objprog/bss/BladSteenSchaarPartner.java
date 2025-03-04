package be.ugent.objprog.bss;

import javafx.scene.control.Label;

public class BladSteenSchaarPartner {

    private Model model;
    private int speler;

    public Label infoLabel;

    // opgeroepen door het hoofdprogramma - niet wijzigen
    public void setModel(Model model) {
        this.model = model;
    }

    // opgeroepen door het hoofdprogramma - niet wijzigen
    public void setSpeler(int speler) {
        this.speler = speler;
    }

    /**
     * Wordt door het model opgeroepen om aan te geven dat een spelbeurt ten einde is
     */
    public void eindeBeurt() {
        // TODO
        int winner = model.getWinnaar();
        String outputText;

        if (winner == speler) {
            outputText = "Je bent gewonnen!";
        } else if (winner == 0) {
            outputText = "Er is geen winnaar";
        } else {
            outputText = "Je bent verloren";
        }

        infoLabel.setText(outputText);
    }

    public void pressedBlad() {
        model.speel(BSS.BLAD, speler);
    }

    public void pressedSteen() {
        model.speel(BSS.STEEN, speler);
    }

    public void pressedSchaar() {
        model.speel(BSS.SCHAAR, speler);
    }

}
