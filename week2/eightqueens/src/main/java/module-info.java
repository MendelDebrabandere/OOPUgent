module be.ugent.objprog.eightqueens {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ugent.objprog.eightqueens to javafx.fxml;
    exports be.ugent.objprog.eightqueens;
}