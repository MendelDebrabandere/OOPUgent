package be.ugent.objprog.bss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BladSteenSchaar extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Model model = new Model ();
        initStage(primaryStage, 1, model);
        Stage secondaryStage = new Stage();
        secondaryStage.setX(primaryStage.getX() + 200);
        secondaryStage.setY(primaryStage.getY() + 100);
        initStage(secondaryStage, 2, model);
    }

    private void initStage(Stage stage, int speler, Model model) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BladSteenSchaar.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Blad Steen Schaar (" + speler + ")");
        stage.show();
        BladSteenSchaarPartner partner = loader.getController();
        partner.setModel (model);
        model.registreer(speler, partner);
        partner.setSpeler(speler);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
