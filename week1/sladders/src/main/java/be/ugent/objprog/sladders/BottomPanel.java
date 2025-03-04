package be.ugent.objprog.sladders;

import javafx.beans.Observable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class BottomPanel extends HBox {

    private final Game game;
    private final Label dieLabel;
    private final Label positionLabel;

    public BottomPanel(Game game) {
        this.dieLabel = new Label();
        dieLabel.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(dieLabel, Priority.ALWAYS);
        this.positionLabel = new Label();
        Button dieButton = new Button("Rol");
        getChildren().addAll (
                positionLabel,
                dieLabel,
                dieButton
        );

        this.game = game;
        game.positionProperty().addListener(this::changePositionLabel);
        game.dieProperty().addListener(this::changeDieLabel);
        dieButton.setOnAction(e -> game.rollDie());

        changeDieLabel(null);
        changePositionLabel(null);
    }

    private void changeDieLabel(Observable ignored) {
        dieLabel.setText("Worp: " + game.getDie());
    }

    private void changePositionLabel(Observable ignored) {
        positionLabel.setText("Positie: " + game.getPosition());
    }
}
