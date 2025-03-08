package com.example.fruitkiezer;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class HelloController {
    @FXML
    private ImageView fruitImage;
    @FXML
    private ComboBox<String> fruitChooseBox;


    @FXML
    protected void OnFruitSelection() {
        String fruit = fruitChooseBox.getValue();

        try (InputStream in = HelloController.class.getResourceAsStream("fotos/" + fruit + ".png")) {
            assert in != null;
            fruitImage.setImage(new Image(in));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() {
        fruitChooseBox.getItems().addAll(
                "aardbei",
                "ajuin",
                "ananas",
                "appel",
                "asperge",
                "banaan",
                "broccoli",
                "druiven",
                "framboos",
                "kiwi",
                "mais",
                "meloen",
                "peer",
                "peper",
                "perzik",
                "pickle",
                "pompelmoes",
                "tomaat",
                "watermeloen",
                "wortel"
        );
    }
}