package be.ugent.objprog.mouseselect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new TilePanel ());
        stage.setTitle("Selecteer tegels");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}