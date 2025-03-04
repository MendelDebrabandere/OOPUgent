module be.ugent.jvl.countdown {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ugent.jvl.countdown to javafx.fxml;
    exports be.ugent.jvl.countdown;
}