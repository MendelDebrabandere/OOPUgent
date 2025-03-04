module be.ugent.jvl.user {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ugent.jvl.user to javafx.fxml;
    exports be.ugent.jvl.user;
}