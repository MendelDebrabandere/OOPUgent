package be.ugent.jvl.viewer;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ViewerController {

    @FXML
    private ImageView imageView;

    private void showImageFromFile (File file) {
        try (InputStream stream = Files.newInputStream(Path.of(file.getPath()))) {
            imageView.setImage(new Image(stream));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    protected void onOpenOption() {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(imageView.getScene().getWindow());
        if ( file != null) {
            showImageFromFile(file);
        }
    }

    @FXML
    protected void onExitOption() {

    }
}