package be.ugent.objprog.eightqueens;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        EightQueensModel model = new EightQueensModel();
        root.setCenter(new EightQueensPanel(model));

        Button button = new Button("Bord wissen");
        button.setOnAction(ev -> model.cleanAll());

        HBox buttonPanel = new HBox();
        buttonPanel.setPadding(new Insets(10));
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.setStyle("-fx-background-color: antiquewhite;");
        buttonPanel.getChildren().add(button);

        root.setBottom(buttonPanel);

        stage.setScene(new Scene(root));
        stage.setTitle("De acht koninginnen");
        
        stage.show();
        stage.setResizable(false);
        stage.sizeToScene(); // moet hier staan om één of andere reden...
    }


    public static void main(String[] args) {
        launch(args);
    }
}
