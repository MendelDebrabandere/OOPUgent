package be.ugent.objprog.mouseselect;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

/**
 * Stelt één enkele vierkante tegel voor.
 */
public class Tile extends Region {

    private boolean selected;

    public Tile() {
        selected = false;
        setOnMousePressed(this::handleMousePressed);
        setOnMouseReleased(this::handleMouseReleased);
        setOnMouseEntered(this::handleMouseEntered);
        setOnMouseExited(this::handleMouseExited);
    }

    private void handleMouseExited(MouseEvent mouseEvent) {
        getStyleClass().remove("hovering");
    }

    private void handleMouseEntered(MouseEvent mouseEvent) {
        getStyleClass().add("hovering");
    }


    private void handleMousePressed(MouseEvent event) {
        getStyleClass().add("gewapend");
    }

    private void handleMouseReleased(MouseEvent mouseEvent) {
        if (contains(mouseEvent.getX(), mouseEvent.getY())) {
            selected = !selected;
            if (selected) getStyleClass().add("selected");
            else getStyleClass().remove("selected");
        }

        getStyleClass().remove("gewapend");
    }

}
