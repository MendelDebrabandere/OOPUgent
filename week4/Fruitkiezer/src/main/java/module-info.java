module com.example.fruitkiezer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.fruitkiezer to javafx.fxml;
    exports com.example.fruitkiezer;
}