package be.ugent.objprog.colors;

import javafx.event.ActionEvent;
import javafx.scene.shape.Circle;

public class ColorsCompanion {

    public Circle circle;

    public void handle (ActionEvent event) {
        ColorButton button = (ColorButton) event.getSource();

        circle.setFill(button.getColor());
    }

}
