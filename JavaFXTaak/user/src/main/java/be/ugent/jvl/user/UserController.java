package be.ugent.jvl.user;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserController {

//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    public TextField voornaam;
    public TextField familienaam;
    public Label resultaat;
    public Label voornaamleeg;
    public Label familienaamleeg;

    public void maakNummer() {
        boolean a = checkLabel(voornaam, voornaamleeg);
        boolean b = checkLabel(familienaam, familienaamleeg);
        if (!a || !b) {
            resultaat.setText("");
        } else {
            resultaat.setText(
                    nummerUitNaam(voornaam.getText(), familienaam.getText())
            );
        }
    }

    private String nummerUitNaam (String s1, String s2) {
        s1 = s1.trim ();
        if (! s1.isEmpty()) {
            s2 = s1.substring(0,1) + s2;
        }
        s2 = s2.replaceAll ("\\s", "").toLowerCase();
        if (s2.isEmpty()) {
            return "(leeg)";
        } else if (s2.length() < 8) {
            return s2;
        } else {
            return s2.substring(0, 8);
        }
    }

    private boolean checkLabel (TextField field, Label errorLabel) {
        Parent parent = field.getParent();
        boolean empty = field.getText().trim().isEmpty();
        if (empty) {
            parent.getStyleClass().add("alarm");
        } else {
            parent.getStyleClass().removeAll("alarm");
        }
        return !empty;
    }

}