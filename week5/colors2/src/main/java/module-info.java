module be.ugent.objprog.colors {
    requires javafx.controls;
    requires javafx.fxml;

    opens be.ugent.objprog.colors to javafx.fxml;
    exports be.ugent.objprog.colors;
}
