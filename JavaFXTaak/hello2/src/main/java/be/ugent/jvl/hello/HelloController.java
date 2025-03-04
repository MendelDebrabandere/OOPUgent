package be.ugent.jvl.hello;

import javafx.scene.control.Label;

public class HelloController {

    public Label label;

    public  void handleButtonAction() {
        label.setText("Hello World!");
    }

}
