module fr.fantasticzoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens fr.fantasticzoo to javafx.fxml;
    exports fr.fantasticzoo;
    exports fr.fantasticzoo.app;
    opens fr.fantasticzoo.app to javafx.fxml;
}