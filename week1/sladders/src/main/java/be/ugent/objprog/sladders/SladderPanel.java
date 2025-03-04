package be.ugent.objprog.sladders;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;

public class SladderPanel extends VBox {

    public SladderPanel() {
        getStylesheets().add(SladderPanel.class.getResource("style.css").toExternalForm());

        Game game = new Game (); // model
        getChildren().addAll(
                new BoardPanel(game),
                new BottomPanel(game)
        );
        game.gameOverProperty().addListener(this::showGameOver);
    }

    public void showGameOver(Observable ignored) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Proficiat. Je hebt het doel bereikt");
        alert.setTitle("Game over!");
        alert.showAndWait();
        Platform.exit();
    }
}
