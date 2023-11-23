package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.enclosures.Aquarium;
import fr.fantasticzoo.enclosures.Aviary;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enums.EnclosureType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

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
    Button newButton = new Button();

    @FXML
    public void createEnclosure() {
        Button newButton = new Button();
        switch (selectedCreature.getValue().toString()){
            case "Vivarium" :
                Enclosure enclosure = new Enclosure("Enclos de type : "+ selectedCreature.getValue().toString(), 100, 100);
                this.zoo.addEnclosure(enclosure);
                this.zoo.getVivariumsEnclosures().add(enclosure);
                enclosure.setName(enclosure.getName() + " " + zoo.getVivariumsEnclosures().size());
                newButton.setText(enclosure.getName());
            break;

            case "Aquarium" :
                Aquarium aquarium = new Aquarium("Enclos de type : "+ selectedCreature.getValue().toString(), 100, 100, 100);
                this.zoo.addEnclosure(aquarium);
                this.zoo.getAquariumsEnclosures().add(aquarium);
                aquarium.setName(aquarium.getName() + " " + zoo.getAquariumsEnclosures().size());
                newButton.setText(aquarium.getName());
            break;

            case "Volière" :
                Aviary aviary = new Aviary("Enclos de type : "+ selectedCreature.getValue().toString(), 100, 100, 100);
                this.zoo.addEnclosure(aviary);
                this.zoo.getAviariesEnclosures().add(aviary);
                aviary.setName(aviary.getName() + " " + zoo.getAviariesEnclosures().size());
                newButton.setText(aviary.getName());
            break;
        }
        enclosures.getChildren().add(newButton);
        newButton.setOnAction(this::handleButtonAction);
        i++;
        for(Enclosure enclosure1 : zoo.getEnclosures()){
            if (enclosure1 != null){
                System.out.print(enclosure1.getName());
            }
        }
        System.out.println(' ');
    }

    private void handleButtonAction(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("enclosureView.fxml"));
        try {
            Parent root = loader.load();
            Scene currentScene = ((Node) actionEvent.getSource()).getScene();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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