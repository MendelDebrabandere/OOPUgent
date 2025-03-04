package be.ugent.jvl.wwgen;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import java.util.Random;

public class WWGenController {

    private static final Random RG = new Random();


    @FXML
    private Label wachtwoord;

    @FXML
    private ChoiceBox<Integer> choiceBox;

    @FXML
    protected void onOkButtonClick() {
        wachtwoord.setText(generateWachtwoord(choiceBox.getValue()));
    }


    private String generateWachtwoord(int length) {

        String returnstr = "";

        while (length > 0)
        {
            int rgInt = RG.nextInt(2*26+10);

            if (rgInt < 26) {
                returnstr += (char)('a' + rgInt);
            } else if (rgInt < 2 * 26) {
                returnstr += (char)('A' + (rgInt - 26));
            } else {
                returnstr += (char)('0' + (rgInt - 2 * 26));
            }

            length--;
        }

        return returnstr;
    }


}