package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.abstractClasses.Creature;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enums.Age;
import fr.fantasticzoo.enums.Sex;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EnclosureController {
    private Zoo zoo;

    public void setZoo(Zoo zoo) { this.zoo = zoo; }
    private Button newButton = new Button();

     //private ArrayList <Enclosure> enclosureList = new ArrayList<Enclosure>(List.of(this.zoo.getEnclosures()));
     private Enclosure actualEnclosure;

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
    VBox creaturesName;
    @FXML
    VBox creaturesInfo;

    @FXML
    VBox actions;


    private String creatures;

    private Label label = new Label("");

    @FXML
    GridPane gridPane = new GridPane();

    private Label name = new Label("Nom");
    private Label age = new Label("Age");
    private Label gender = new Label("Sexe");
    private Label weight = new Label("Poids");
    private Label height = new Label("Hauteur");
    private Label health = new Label("Santé");


    public void setData(String data) {
        label.setText(data);
        enclosureName.setText(label.getText());


        System.out.println(data);
        this.zoo = Zoo.getInstance();

        Enclosure enclosure = zoo.getEnclosureByName(data);

        //informations de l'enclos
        enclosureSurface.setText(enclosureSurface.getText() + String.valueOf(enclosure.getSurface()) + "m²");
        enclosureCreaturesMax.setText(enclosureCreaturesMax.getText() + String.valueOf(enclosure.getCapacity()));
        enclosureCleanliness.setText(enclosureCleanliness.getText() + enclosure.getCleanlinessToString());
        enclosureCreaturesCount.setText(enclosureCreaturesCount.getText() + String.valueOf(enclosure.getCreatureCount()));
        //

        ArrayList<String> creatureName = new ArrayList<>(enclosure.getCreaturesNames());
        for (String name : creatureName) {
            Label creatureShow = new Label(name);
            creaturesName.getChildren().add(creatureShow);
        }
        int rowIndex = 1;

        for (Creature creature : enclosure.getCreatures()) {
            if (creature != null) {
                Label creatureLabel = new Label(creature.getName() + " : ");
                gridPane.add(creatureLabel, 0, rowIndex);

                Label creatureInfoLabel = new Label(String.valueOf(creature.getAge()  + " " + creature.getSex() + creature.getWeight() + creature.getHeight() + creature.getHealth()));
                age.setText(String.valueOf(creature.getAge()));
                gender.setText(String.valueOf(creature.getSex()));
                weight.setText(String.valueOf(creature.getWeight()));
                height.setText(String.valueOf(creature.getHeight()));
                health.setText(String.valueOf(creature.getHealth()));
                rowIndex++;
            }
        }
    }

    @FXML
    public void addCreature(ActionEvent actionEvent){
        Enclosure enclosure = zoo.getEnclosureByName(String.valueOf(label.getText()));

        actions.getChildren().removeAll(actions.getChildren());

        //zone infos de la créature à ajouter
        Label nameLabelAdd = new Label("Entrez le nom d'une Créature à ajouter");
        TextField NameTextFieldAdd = new TextField();

        Label ageLabelAdd = new Label("Choissiez l'age de la créature à ajouter");
        ObservableList<Age> ageList = FXCollections.observableArrayList(Age.values());
        ComboBox ageChoicBox = new ComboBox(ageList);

        Label genderLabelAdd = new Label("Choissiez le sexe de la créature à ajouter");
        ObservableList<Sex> genderList = FXCollections.observableArrayList(Sex.values());
        ComboBox genderChoicBox = new ComboBox(genderList);

        Label weightLabelAdd = new Label("Choissiez le poids de la créature à ajouter");
        TextField weightTextFieldAdd = new TextField();

        Label heightLabelAdd = new Label("Choissiez la hauteur de la créature à ajouter");
        TextField heightTextFieldAdd = new TextField();

        Label healthLabelAdd = new Label("Choissiez la santé de la créature à ajouter");
        ObservableList<String> healthList = FXCollections.observableArrayList("Mauvais", "Bon");
        ComboBox healthChoicBox = new ComboBox(healthList);


        actions.getChildren().addAll(nameLabelAdd, NameTextFieldAdd, ageLabelAdd, ageChoicBox, genderLabelAdd,
        genderChoicBox, weightLabelAdd, weightTextFieldAdd, heightLabelAdd, heightTextFieldAdd, healthLabelAdd, healthChoicBox);

        Button addButton = newButton("Ajouter la créature");
        //

        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {

                String creatureName = textField.getText(); //On récupère le nom de la r=créature dans le textField
//                Creature newCreature = new Creature(creatureName);
//                enclosure.addCreatures(newCreature);

                Label creatureLabel = new Label(creatureName);
                Label creatureage = new Label("4");

                actions.getChildren().add(creatureLabel);
                creaturesName.getChildren().add(creatureLabel);
                gridPane.addRow(gridPane.getRowCount(), creatureLabel, creatureage);
                textField.clear();
            }
        });
    }

    @FXML
    public  void removeCreature(ActionEvent actionEvent){
        Enclosure enclosure = zoo.getEnclosureByName(String.valueOf(label.getText()));

        actions.getChildren().removeAll(actions.getChildren());

        Label labelAdd = new Label("Entrez le nom d'une Créature à retirer");
        TextField textField = new TextField();
        actions.getChildren().addAll(labelAdd, textField);

        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String creatureName = textField.getText();
                if (enclosure.getCreaturesProperty() != null) {
                    for (Creature creature : enclosure.getCreaturesProperty()) {
                        if (creature != null && creature.getName().equals(creatureName)) {
                            enclosure.removeCreatures(creature);
                            //System.out.println(enclosure.showCreatures());
                            Label creatureLabel = new Label("Créature retirée : " + creatureName);
                            actions.getChildren().add(creatureLabel);
                            textField.clear();
                            return;
                        }
                    }
                    // La boucle est terminée et la créature n'a pas été trouvée
                    Label notFoundLabel = new Label("Créature non trouvée : " + creatureName);
                    actions.getChildren().add(notFoundLabel);
                } else {
                    // La liste de créatures est null
                    Label nullListLabel = new Label("La liste de créatures est null.");
                    actions.getChildren().add(nullListLabel);
                }
            }
        });
    }
    @FXML
    public void feedCreatures(ActionEvent actionEvent){
        Enclosure enclosure = zoo.getEnclosureByName(String.valueOf(label.getText()));
        ArrayList <Creature> creatureList = enclosure.getCreatures();

        actions.getChildren().removeAll(actions.getChildren());

        if(enclosure != null){
            for (Creature creature : creatureList) {
                enclosure.feedCreatures(creature);
            }

            Label areFeededLabel = new Label("Les créatures ont été nourrits !");
            actions.getChildren().add(areFeededLabel);
        }
        else {
            Label notFoundLabel = new Label("L'enclos n'a pas été trouvé !");
            actions.getChildren().add(notFoundLabel);
        }
    }

    @FXML
    public void cleanEnclosure(ActionEvent actionEvent){
        Enclosure enclosure = zoo.getEnclosureByName(String.valueOf(label.getText()));

        actions.getChildren().removeAll(actions.getChildren());

        if (enclosure != null){
            enclosure.clean();
            enclosure.setCleanliness();
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
}
