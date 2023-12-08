package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enclosures.StandardEnclosure;
import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnclosureController implements Initializable {
    private Zoo zoo;
    private Enclosure<?> enclosure;
    private Button newButton = new Button();

    //Informations de l'enclos FXML
    @FXML
    Label enclosureName;
    @FXML
    Label enclosureSurface;
    @FXML
    Label enclosureCreaturesMax;
    @FXML
    Label enclosureCreaturesCount;
    @FXML
    Label enclosureCleanliness;

    @FXML
    VBox creaturesInfo;

    @FXML
    VBox actions;
    @FXML
    Label age;
    @FXML
    Label gender;
    @FXML
    Label weight;
    @FXML
    Label height;
    @FXML
    Label health;
    @FXML
    Label hunger;
    @FXML
    Label sleep;

    @FXML
    VBox creaturesName;
    @FXML
    VBox creatureInfo;
    @FXML
    Label creatureLabel;

    public EnclosureController(Enclosure<?> enclosureWithButton) {
        this.enclosure = enclosureWithButton;
    }

    /**
     * Gestion de l'évènement "Click sur une créature"
     * @param actionEvent
     * @param <creatureType>
     */
    @FXML
    private <creatureType extends AbstractCreature<?>> void creatureButtonAction(ActionEvent actionEvent) {
        Button b;
        // Vérifie si la source de l'évènement est un bouton
        if (actionEvent.getSource() instanceof Button) {
            b = (Button) actionEvent.getSource();
        } else {
            return;
        }
        creatureInfo.getChildren().clear();
        if(this.enclosure.getCreatureWithButton(b) == null)
            return;
        // Affiche les informations relatives à la créature
        creatureType clickedCreature = (creatureType) this.enclosure.getCreatureWithButton(b);
        age.setText("Age : " + clickedCreature.getAge());
        gender.setText("Genre : " + clickedCreature.getSex());
        weight.setText("Poids : " + clickedCreature.getWeight() + " kg");
        height.setText("Hauteur : " + clickedCreature.getHeight() + " cm");

        // Gestion de la créature
        if (clickedCreature.isHungry())
            hunger.setText("Faim : Oui");
        else
            hunger.setText("Faim : Non");

        if (clickedCreature.isSick())
            health.setText("Etat de santé : Malade");
        else
            health.setText("Etat de santé : En bonne santé");

        creatureLabel.setText("Informations sur " + clickedCreature.getName());
        if (clickedCreature.isSleeping())
            sleep.setText("la creature se repose...");
        else
            sleep.setText("");

        Button feedButton = new Button("Nourrir");
        feedButton.setOnAction(event -> clickedCreature.feed());
        Button healButton = new Button("Soigner");
        healButton.setOnAction(event -> clickedCreature.heal());

        feedButton.setDisable(!clickedCreature.isHungry());
        healButton.setDisable(!clickedCreature.isSick());
        if(clickedCreature.isSleeping()) {
            feedButton.setDisable(true);
            healButton.setDisable(true);
        }


        creatureInfo.getChildren().addAll(creatureLabel, age, gender, weight, height, health, hunger, feedButton, healButton, sleep);

    }

    /**
     * Permet d'ajouter une créature à l'enclos (ici cette méthode n'est pas fonctionnelle mais elle était en cours de façonnage)
     * @param actionEvent
     */
    @FXML
    public void addCreature(ActionEvent actionEvent){
        creatureInfo.getChildren().clear();
        actions.getChildren().removeAll(actions.getChildren());

        //zone infos de la créature à ajouter
        Label nameLabelAdd = new Label("Entrez le nom d'une Créature à ajouter");
        TextField NameTextFieldAdd = new TextField();

        Button addButton = new Button("Ajouter la créature");
        addButton.setDisable(false);

        actions.getChildren().addAll(nameLabelAdd, NameTextFieldAdd, addButton);

        creatureInfo.getChildren().add(actions);

        addButton.setOnAction(event ->{
            String creatureName = NameTextFieldAdd.getText(); //On récupère le nom de la créature dans le textField
            Label creatureNameLabel = new Label(creatureName);
        });
    }

    /**
     * Nourrir les créatures lorsque que l'on clique sur bouton "Nourrir"
     * @param actionEvent
     */
    @FXML
    public void feedCreatures(ActionEvent actionEvent){
        actions.getChildren().removeAll(actions.getChildren());
        for (AbstractCreature<?> abstractCreature : this.enclosure.getCreatures()) {
            abstractCreature.feed();
        }
        Label areFeededLabel = new Label("Les créatures ont été nourrits !");
        actions.getChildren().add(areFeededLabel);
    }

    /**
     * Nettoie l'enclos
     * @param actionEvent
     */
    @FXML
    public void cleanEnclosure(ActionEvent actionEvent){

        actions.getChildren().removeAll(actions.getChildren());
        if (this.enclosure != null){
            this.enclosure.clean();
            this.enclosure.setCleanliness(true);
            Label isCleanLabel = new Label("L'enclos a été nettoyé !");
            actions.getChildren().add(isCleanLabel);
        }

        else {
            Label notFoundLabel = new Label("L'enclos n'a pas été trouvé !");
            actions.getChildren().add(notFoundLabel);
        }
    }

    /**
     * Retourner au menu (à la vue sur le zoo)
     * @param actionEvent
     */
    @FXML
    public void returnMenu(ActionEvent actionEvent){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app.fxml"));
        try {
            Parent root = loader.load();
            Scene currentScene = ((Node) actionEvent.getSource()).getScene();
            Scene newScene = new Scene(root, 800, 800);
            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialisation des données
     * @param url
     * @param resourceBundle
     */
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.zoo = Zoo.getInstance();

        enclosureName.setText(this.enclosure.getName());

        //informations de l'enclos
        enclosureSurface.setText(enclosureSurface.getText() + String.valueOf(enclosure.getSurface()) + "m²");
        enclosureCreaturesMax.setText(enclosureCreaturesMax.getText() + String.valueOf(enclosure.getCapacity()));
        enclosureCleanliness.setText(enclosureCleanliness.getText() + enclosure.getCleanlinessToString());

        for(Node b : this.enclosure.getObservableCreatureMap().values()){
            if (b instanceof Button button) {
                button.setOnAction(this::creatureButtonAction);
                creaturesName.getChildren().add(button);
            }
        }
        this.enclosure.getObservableCreatureMap().addListener((MapChangeListener<AbstractCreature, Node>) change -> {
            if (change.wasAdded()) {
                // Ajouter un nouveau bouton à la HBox pour chaque ajout dans la map
                if (change.getValueAdded() instanceof Button button) {
                    button.setOnAction(this::creatureButtonAction);
                    creaturesName.getChildren().add(button);
                }
            }
        });
    }
}
