package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EnclosureController {
    private Zoo zoo;

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
    @FXML
    Label enclosureName;


}
