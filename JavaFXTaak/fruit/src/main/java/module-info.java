module be.ugent.jvl.fruit {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ugent.jvl.fruit to javafx.fxml;
    exports be.ugent.jvl.fruit;
}