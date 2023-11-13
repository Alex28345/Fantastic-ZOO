module fr.fantasticzoo {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.fantasticzoo to javafx.fxml;
    exports fr.fantasticzoo;
}