module be.ugent.objprog.bss {
    requires javafx.controls;
    requires javafx.fxml;

    opens be.ugent.objprog.bss to javafx.fxml;
    exports be.ugent.objprog.bss;
}