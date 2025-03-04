package be.ugent.objprog.muizenhuis;

import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class MuizenhuisCompanion implements Kamers {

    public Label aantalLinks;
    public Label aantalRechts;

    private int links;
    private int rechts;

    public ToggleButton knopLinks;
    public ToggleButton knopRechts;

    public MuizenhuisCompanion () {
        links = 4;
        rechts = 4;
        toestand = Toestand.BASIS;
    }

    public void initialize () {
        knopLinks.selectedProperty().addListener(ob -> {
            if (knopLinks.isSelected()) {
                toestand = toestand.linksAan(MuizenhuisCompanion.this);
            } else {
                toestand = toestand.linksUit(MuizenhuisCompanion.this);
            }
        });


        knopRechts.selectedProperty().addListener(ob -> {
            if (knopRechts.isSelected()) {
                toestand = toestand.rechtsAan(MuizenhuisCompanion.this);
            } else {
                toestand = toestand.rechtsUit(MuizenhuisCompanion.this);
            }
        });

        // toon beginlabels
        labelsAanpassen();
    }

    private void labelsAanpassen () {
        aantalLinks.setText(String.valueOf(links));
        aantalRechts.setText(String.valueOf(rechts));
    }

    private Toestand toestand;

    @Override
    public void vanLinksNaarRechts() {
        links --;
        rechts ++;
        labelsAanpassen();
    }

    @Override
    public void vanRechtsNaarLinks() {
        rechts --;
        links ++;
        labelsAanpassen();
    }
}
