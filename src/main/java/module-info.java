module fr.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.demo to javafx.fxml;
    exports fr.demo;
}