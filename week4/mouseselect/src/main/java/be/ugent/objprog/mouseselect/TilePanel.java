package be.ugent.objprog.mouseselect;

import javafx.scene.layout.GridPane;

public class TilePanel extends GridPane {
    public TilePanel() {
        getStylesheets().add(getClass().getResource("main.css").toExternalForm());

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                add(new Tile(), i, j);
            }
        }
    }
}
