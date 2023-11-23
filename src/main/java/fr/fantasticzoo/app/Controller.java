package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enums.EnclosureType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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
    private FlowPane enclosures;

    @FXML
    public void createEnclosure() {
        Enclosure enclosure = new Enclosure("Enclos de type : "+ selectedCreature.getValue().toString(), 100, 100);
        this.zoo.addEnclosure(enclosure);
        Button newButton = new Button(enclosure.getName());
        newButton.setText(enclosure.getName());
        enclosures.getChildren().add(newButton);
        newButton.setOnAction(e -> {
            System.out.println("Bouton cliqué");
        });
        i++;
        for(Enclosure enclosure1 : zoo.getEnclosures()){
            if (enclosure1 != null){
                System.out.print(enclosure1.getName());
            }
        }
        System.out.println(' ');
    }

    public void inspectEnclosure(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (EnclosureType type : EnclosureType.values()) {
            selectedCreature.getItems().add(type);
        }
    }
}