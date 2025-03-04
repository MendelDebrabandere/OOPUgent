module be.ugent.jvl.wwgen {
    requires javafx.controls;
    requires javafx.fxml;


    opens be.ugent.jvl.wwgen to javafx.fxml;
    exports be.ugent.jvl.wwgen;
}