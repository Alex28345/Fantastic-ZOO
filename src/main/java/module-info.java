module fr.fantasticzoo {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.fantasticzoo to javafx.fxml;
    exports fr.fantasticzoo;
    exports fr.fantasticzoo.app;
    opens fr.fantasticzoo.app to javafx.fxml;
}