package be.ugent.jvl.fruit;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FruitController {
    @FXML
    private ImageView imageView;

    @FXML
    private ListView<String> lijst;

    public void initialize () {
        lijst .getSelectionModel().selectedItemProperty().addListener(ob -> kiesFruit());
    }

    private void kiesFruit() {
        Image image = new Image (
                getClass().getResourceAsStream ("images/" + lijst.getSelectionModel().getSelectedItem() + ".png")
        );
        imageView.setImage (image);
    }
}