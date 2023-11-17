package fr.fantasticzoo.app;

import fr.fantasticzoo.creatures.Dragon;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private ComboBox selectedCreature;
    @FXML
    protected void createCreature() {
        new Dragon("salut");
        welcomeText.setText(selectedCreature.getValue().toString());
    }

}