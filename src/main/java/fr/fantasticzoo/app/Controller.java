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

    private void handleButtonAction(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("enclosureView.fxml"));

        Controller controller = loader.<Controller>getController();

        Object source = actionEvent.getSource(); // Récupère la source de l'évènement

        //if (source instanceof Button) { // vérifie si la source est une instance de la classe Button (si c'est de type Button)
            Button clickedButton = (Button) source; // crée un bouton qui va s'appeler clickedButton (Bouton sur lequel nous avons cliqué)
            String buttonText = clickedButton.getText(); // La chaine de caractère aura pour valeur le texte qui a été assigné au bouton

        try {
            Parent root = loader.load();

            EnclosureController enclosureController = loader.getController(); // on récupère le controller Enclosure controller

            enclosureController.setData(buttonText); // cette fonction est juste un setter qui permet de récupérer le texte se trouvant sur le bouton sur lequel on a cliqué

            Scene currentScene = ((Node) actionEvent.getSource()).getScene();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void getAge() {
        int age = this.zoo.getEnclosures()[0].getCreatures()[0].getAge();
        System.out.println(age);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.zoo = Zoo.getInstance();
        for (EnclosureType type : EnclosureType.values()) {
            selectedCreature.getItems().add(type);
        }
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
    public void enclosureButtonAction(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        System.out.println(zoo.getEnclosureWithButton(button).getName());
        zoo.getEnclosureWithButton(button).showCreatures();
    }
}