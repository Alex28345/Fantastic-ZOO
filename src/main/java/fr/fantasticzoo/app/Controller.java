package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.enclosures.Enclosure;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Controller {
    private Zoo zoo;
    private int i = 0;
    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    @FXML
    private Label welcomeText;

    @FXML
    private ComboBox selectedCreature;
    @FXML
    private HBox enclosures;
    @FXML
    public void createEnclosure() {

        Enclosure enclosure = new Enclosure("enclos"+i, 100, 100);
        this.zoo.addEnclosure(enclosure);
        for(Enclosure enclosure1 : zoo.getEnclosures()) {
            if(enclosure1 != null)
                System.out.println(enclosure1.getName());
        }
        i++;
    }


}