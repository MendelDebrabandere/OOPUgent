module be.ugent.objprog.muizenhuis {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ugent.objprog.muizenhuis to javafx.fxml;
    exports be.ugent.objprog.muizenhuis;
}