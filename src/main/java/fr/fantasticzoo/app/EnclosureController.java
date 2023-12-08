package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enclosures.StandardEnclosure;
import fr.fantasticzoo.enums.Age;
import fr.fantasticzoo.enums.Sex;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class EnclosureController implements Initializable {
    private Zoo zoo;
    private Enclosure<?> enclosure;

    private Button newButton = new Button();

     //private ArrayList <Enclosure> enclosureList = new ArrayList<Enclosure>(List.of(this.zoo.getEnclosures()));
     private StandardEnclosure actualStandardEnclosure;

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
    VBox creaturesName;
    @FXML
    VBox creatureInfo;
    @FXML
    Label creatureLabel;

    public EnclosureController(Enclosure<?> enclosureWithButton) {
        this.enclosure = enclosureWithButton;
    }

    private void creatureButtonAction(ActionEvent actionEvent) {
        creatureInfo.getChildren().clear();
        Button clickedButton = (Button) actionEvent.getSource();

        // On parcourt la Map observable pour trouver la créature associée au bouton
        for (Map.Entry<AbstractCreature, Node> entry : this.enclosure.getObservableCreatureMap().entrySet()) {
            if(entry.getValue() instanceof Button && entry.getValue() == clickedButton){
                AbstractCreature clickedCreature = entry.getKey();

                age.setText("Age : " + clickedCreature.getAge());
                gender.setText("Genre : " + clickedCreature.getSex());
                weight.setText("Poids : " + clickedCreature.getWeight());
                height.setText("Hauteur : " + clickedCreature.getHeight());
                health.setText("Etat de santé : " + clickedCreature.isSick());

                creatureLabel.setText("Informations sur " + clickedCreature.getName());

                creatureInfo.getChildren().addAll(creatureLabel,age,gender,weight,height,health);
                break;
            }
        }
    }

    @FXML
    public void addCreature(ActionEvent actionEvent){
        creatureInfo.getChildren().clear();
        actions.getChildren().removeAll(actions.getChildren());

        //zone infos de la créature à ajouter
        Label nameLabelAdd = new Label("Entrez le nom d'une Créature à ajouter");
        TextField NameTextFieldAdd = new TextField();
        //

        Button addButton = new Button("Ajouter la créature");
        addButton.setDisable(false);

        actions.getChildren().addAll(nameLabelAdd, NameTextFieldAdd, addButton);

        creatureInfo.getChildren().add(actions);

       /* if (NameTextFieldAdd.getText() != null && ageChoicBox.getValue() != null && genderChoicBox.getValue() != null &&
                weightTextFieldAdd.getText() != null && heightTextFieldAdd.getText() != null && healthChoicBox.getValue() != null){
            addButton.setDisable(false);
        }*/
        //
        addButton.setOnAction(event ->{
            String creatureName = NameTextFieldAdd.getText(); //On récupère le nom de la r=créature dans le textField

            Label creatureNameLabel = new Label(creatureName);
            //this.enclosure.addCreatures(this.getClass().getResource());
            //gridPane.addRow(gridPane.getRowCount(), creatureNameLabel, creatureageAgeLabel, creatureageGenderLabel, creatureWeightLabel, creatureHeightLabel, creatureHealthLabel);
        });
    }

    //TODO : Faire la méthode removeCreature
//    @FXML
//    public void removeCreature(ActionEvent actionEvent){
//
//        actions.getChildren().removeAll(actions.getChildren());
//
//        Label labelAdd = new Label("Entrez le nom d'une Créature à retirer");
//        TextField textField = new TextField();
//        actions.getChildren().addAll(labelAdd, textField);
//
//        textField.setOnKeyPressed(event -> {
//            if (event.getCode() == KeyCode.ENTER) {
//                String creatureName = textField.getText();
//                if (this.enclosure.getObservableCreatureMap() != null) {
//                    for (AbstractCreature abstractCreature : this.enclosure.getCreatures()) {
//                        if (abstractCreature != null && abstractCreature.getName().equals(creatureName)) {
//                            this.enclosure.removeCreatures((T) abstractCreature);
//                            //System.out.println(enclosure.showCreatures());
//                            Label creatureLabel = new Label("Créature retirée : " + creatureName);
//                            actions.getChildren().add(creatureLabel);
////                            gridPane.getChildren().remove();
//                            textField.clear();
//                            return;
//                        }
//                    }
//                    // La boucle est terminée et la créature n'a pas été trouvée
//                    Label notFoundLabel = new Label("Créature non trouvée : " + creatureName);
//                    actions.getChildren().add(notFoundLabel);
//                } else {
//                    // La liste de créatures est null
//                    Label nullListLabel = new Label("La liste de créatures est null.");
//                    actions.getChildren().add(nullListLabel);
//                }
//            }
//        });
//    }
    @FXML
    public void feedCreatures(ActionEvent actionEvent){
        actions.getChildren().removeAll(actions.getChildren());
        for (AbstractCreature abstractCreature : this.enclosure.getCreatures()) {
            abstractCreature.feed();
        }
        Label areFeededLabel = new Label("Les créatures ont été nourrits !");
        actions.getChildren().add(areFeededLabel);
    }

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

    @FXML
    public void returnMenu(ActionEvent actionEvent){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("app.fxml"));
        try {
            Parent root = loader.load();
            Controller controller = loader.getController();
            Scene currentScene = ((Node) actionEvent.getSource()).getScene();
            Scene newScene = new Scene(root, 800, 800);
            Stage stage = (Stage) currentScene.getWindow();
            stage.setScene(newScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.zoo = Zoo.getInstance();

        enclosureName.setText(this.enclosure.getName());

        //informations de l'enclos
        enclosureSurface.setText(enclosureSurface.getText() + String.valueOf(enclosure.getSurface()) + "m²");
        enclosureCreaturesMax.setText(enclosureCreaturesMax.getText() + String.valueOf(enclosure.getCapacity()));
        enclosureCleanliness.setText(enclosureCleanliness.getText() + enclosure.getCleanlinessToString());
        enclosureCreaturesCount.setText(enclosureCreaturesCount.getText() + String.valueOf(enclosure.getCreatureCount()));


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
            } else if (change.wasRemoved()) {
                // Supprimer le bouton correspondant à chaque suppression dans la map
                creaturesName.getChildren().remove(change.getValueRemoved());
            }
        });
    }
}
