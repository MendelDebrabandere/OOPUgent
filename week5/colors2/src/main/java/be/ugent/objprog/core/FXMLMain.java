/* FXMLMain.java
 * ============================================================
 * Copyright © 2012-2022 Universiteit Gent
 *
 * Bijlage bij het vak 'Objectgericht programmeren'.
 *
 * Auteur: Kris Coolsaet
 */
package be.ugent.objprog.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Gemeenschappelijke hoofdklasse voor programma's die volledig zijn
 * gespecifieerd door een FXML-bestand.
 */
public class FXMLMain extends Application {

    /**
     * Geeft de naam terug van het FXML-bestand waarop deze toepassing is
     * gebaseerd.
     */
    protected String getFXMLResourceName() {
        String className = getClass().getSimpleName();
        if (className.endsWith("Main")) {
            className = className.substring(0, className.length() - 4);
        }
        return className + ".fxml";
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader  = new FXMLLoader(getClass().getResource(getFXMLResourceName()));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
