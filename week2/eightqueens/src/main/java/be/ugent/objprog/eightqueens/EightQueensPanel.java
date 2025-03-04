package be.ugent.objprog.eightqueens;

import javafx.scene.layout.GridPane;

/**
 * Een paneel met 8 x 8 schaakbordvelden
 */
public class EightQueensPanel extends GridPane {

    public EightQueensPanel(EightQueensModel model) {
        for (int i=0; i < 8; i++) {
            for (int j=0; j < 8; j++) {
                add(new Field(model, i, j), i, j);
            }
        }
    }
}
