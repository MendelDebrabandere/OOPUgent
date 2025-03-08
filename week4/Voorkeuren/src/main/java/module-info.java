module com.example.voorkeuren {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.voorkeuren to javafx.fxml;
    exports com.example.voorkeuren;
}