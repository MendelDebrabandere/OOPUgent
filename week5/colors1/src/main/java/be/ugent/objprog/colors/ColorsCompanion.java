package be.ugent.objprog.colors;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class ColorsCompanion {

    public Circle circle;

    public void doChangeCircleColor(ActionEvent e) {

        Button sourceButton = (Button) e.getSource();

        circle.setFill(Color.valueOf((String)sourceButton.getUserData()));

    }

}
