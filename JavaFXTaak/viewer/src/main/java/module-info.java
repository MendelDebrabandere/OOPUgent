module be.ugent.jvl.viewer {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ugent.jvl.viewer to javafx.fxml;
    exports be.ugent.jvl.viewer;
}