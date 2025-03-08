package com.example.voorkeuren;



import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class VoorkeurenController {

    public ToggleGroup size;
    private Properties props;

    public TextField familienaamField;
    public TextField voornaamField;
    public TextField minABCField;
    public TextField maxABCField;
    public Label minLabel;
    public Label maxLabel;

    public ToggleButton small;
    public ToggleButton medium;
    public ToggleButton large;


    public void handleSave() {
        if (saveBuffer())
            javafx.application.Platform.exit();
    }

    public void handleCancel() {
        javafx.application.Platform.exit();
    }


    private boolean saveBuffer() {
        // check if min and max are integers
        if (! isNumeric(minABCField.getText())) {
            minABCField.getStyleClass().add("error");
            minLabel.getStyleClass().add("error");
            return false;
        }
        if (! isNumeric(maxABCField.getText())) {
            maxABCField.getStyleClass().add("error");
            maxLabel.getStyleClass().add("error");
            return false;
        }






        // save to props
        props.setProperty("name", familienaamField.getText());
        props.setProperty("firstName", voornaamField.getText());
        props.setProperty("min", minABCField.getText());
        props.setProperty("max", maxABCField.getText());


        Map<ToggleButton, String> buttons = Map.of(
                small, "small",
                medium, "medium",
                large, "large"
        );

        props.setProperty("size", buttons.get((ToggleButton) size.getSelectedToggle()));


        try (FileOutputStream output = new FileOutputStream("my.properties")) {
            props.store(output, "Application Settings");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }




    public void initialize() throws IOException {
        props = new Properties();

        try (FileInputStream fis = new FileInputStream("my.properties")) {
            props.load(fis);
            familienaamField.setText(props.getProperty("name"));
            voornaamField.setText(props.getProperty("firstName"));
            minABCField.setText(props.getProperty("min"));
            maxABCField.setText(props.getProperty("max"));

            Map<String, ToggleButton> buttons = Map.of(
                    "small", small,
                    "medium", medium,
                    "large", large
            );

            ToggleButton toggle = buttons.get(props.getProperty("size"));

            size.selectToggle(toggle);
        }
    }


    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}