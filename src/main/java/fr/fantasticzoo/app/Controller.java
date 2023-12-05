package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.enclosures.Aquarium;
import fr.fantasticzoo.enclosures.Aviary;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enums.EnclosureType;
import javafx.beans.binding.Bindings;
import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Zoo zoo;
    private final int i = 0;
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
        Enclosure enclosure = switch (selectedCreature.getValue().toString()) {
            case "Vivarium" -> new Enclosure("Enclos de type : " + selectedCreature.getValue().toString(), 100, 100);
            case "Aquarium" -> new Aquarium("Enclos de type : " + selectedCreature.getValue().toString(), 100, 100, 100);
            case "Volière" -> new Aviary("Enclos de type : " + selectedCreature.getValue().toString(), 100, 100, 100);
            default -> null;
        };
        if(enclosure != null){
            this.zoo.addEnclosure(enclosure);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (EnclosureType type : EnclosureType.values()) {
            selectedCreature.getItems().add(type);
        }

        this.zoo = Zoo.getInstance();

        for(Node b : zoo.getObservableEnclosureMap().values()){
            if (b instanceof Button button) {
                button.setOnAction(this::enclosureButtonAction);
                enclosures.getChildren().add(button);
            }
        }
        zoo.getObservableEnclosureMap().addListener((MapChangeListener<Enclosure, Node>) change -> {
            if (change.wasAdded()) {
                // Ajouter un nouveau bouton à la HBox pour chaque ajout dans la map
                if(change.getValueAdded() instanceof Button button){
                        button.setOnAction(this::enclosureButtonAction);
                    enclosures.getChildren().add(button);
                }
            } else if (change.wasRemoved()) {
                // Supprimer le bouton correspondant à chaque suppression dans la map
                enclosures.getChildren().remove(change.getValueRemoved());
            }
        });
    }

    @FXML
    public void enclosureButtonAction(ActionEvent actionEvent) {
        EnclosureController controller = null;
        try {
            controller = HelloApplication.changeScene((Stage) ((Node) actionEvent.getSource()).getScene().getWindow(), "enclosureView.fxml", "Enclos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Button b = (Button) actionEvent.getSource();
        controller.setData(zoo.getEnclosureWithButton(b));
    }
}