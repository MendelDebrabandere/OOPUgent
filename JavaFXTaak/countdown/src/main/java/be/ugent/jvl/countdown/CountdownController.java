package be.ugent.jvl.countdown;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class CountdownController {

    private Timeline timeline;
    private boolean alarm;
    private int teller;

    public void initialize () {
        teller = 11;
        alarm = false;
        puls();

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1.0), e -> puls())
        );
        timeline.setCycleCount(10);
    }

    private void puls() {
        teller--;
        if (teller == 0) {
            timeline.stop();
            timeText.setText("Einde");
            timeText.getStyleClass().remove ("alarm");
            alarm = false;
        } else {
            if (teller <= 5 && !alarm) {
                alarm = true;
                timeText.getStyleClass().add("alarm");
            }
            timeText.setText(Integer.toString(teller));
        }
    }

    @FXML
    private Label timeText;

    @FXML
    protected void startTimer() {
        timeline.playFromStart();
    }
}