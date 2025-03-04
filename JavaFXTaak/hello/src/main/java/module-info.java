module be.ugent.jvl.hello {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ugent.jvl.hello to javafx.fxml;
    exports be.ugent.jvl.hello;
}