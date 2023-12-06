package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Creature;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enclosures.StandardEnclosure;
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

public class EnclosureController<T extends AbstractCreature> {
    private Zoo zoo;
    private Enclosure<T> enclosure;
    private AbstractCreature creature;

    public void setZoo(Zoo zoo) { this.zoo = zoo; }
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

    private Label label = new Label("");

    @FXML
    GridPane gridPane = new GridPane();

    private Label name = new Label("Nom");
    private Label age = new Label("Age");
    private Label gender = new Label("Sexe");
    private Label weight = new Label("Poids");
    private Label height = new Label("Hauteur");
    private Label health = new Label("Santé");

    @FXML
    VBox creaturesName;

    public void setData(Enclosure<T> buttonStandardEnclosure) {
        this.enclosure = buttonStandardEnclosure;
        label.setText(this.enclosure.getName());
        this.zoo = Zoo.getInstance();

        enclosureName.setText(label.getText());
        System.out.println(this.enclosure);

        //informations de l'enclos
        enclosureSurface.setText(enclosureSurface.getText() + String.valueOf(enclosure.getSurface()) + "m²");
        enclosureCreaturesMax.setText(enclosureCreaturesMax.getText() + String.valueOf(enclosure.getCapacity()));
        enclosureCleanliness.setText(enclosureCleanliness.getText() + enclosure.getCleanlinessToString());
        enclosureCreaturesCount.setText(enclosureCreaturesCount.getText() + String.valueOf(enclosure.getCreatureCount()));

        int rowIndex = 1;

        for (AbstractCreature creature : this.enclosure.getCreatures()){
            Button creatureShow = new Button(creature.getName());
            creaturesName.getChildren().add(creatureShow);
            creatureShow.setOnAction(this::showCreatureInfo);
        }

        for (AbstractCreature creature : this.enclosure.getCreatures()) {
            if (creature != null) {
                Label creatureLabel = new Label(creature.getName() + " : ");
                gridPane.add(creatureLabel, 0, rowIndex);

                age.setText(String.valueOf(creature.getAge()));
                gender.setText(String.valueOf(creature.getSex()));
                weight.setText(String.valueOf(creature.getWeight()));
                height.setText(String.valueOf(creature.getHeight()));
                health.setText(String.valueOf(creature.isSick()));

                gridPane.add(age, 1, rowIndex);
                gridPane.add(gender, 2, rowIndex);
                gridPane.add(weight, 3, rowIndex);
                gridPane.add(height, 4, rowIndex);
                gridPane.add(health, 5, rowIndex);

                rowIndex++;
            } else {
                System.out.println("Il n'y a pas de créatures");
            }
        }
    }

    private void showCreatureInfo(ActionEvent actionEvent) {

    }

    @FXML
    public void addCreature(ActionEvent actionEvent){
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
        //

        Button addButton = new Button("Ajouter la créature");
        addButton.setDisable(false);

        actions.getChildren().addAll(nameLabelAdd, NameTextFieldAdd, ageLabelAdd, ageChoicBox, genderLabelAdd,
        genderChoicBox, weightLabelAdd, weightTextFieldAdd, heightLabelAdd, heightTextFieldAdd, healthLabelAdd, healthChoicBox, addButton);

       /* if (NameTextFieldAdd.getText() != null && ageChoicBox.getValue() != null && genderChoicBox.getValue() != null &&
                weightTextFieldAdd.getText() != null && heightTextFieldAdd.getText() != null && healthChoicBox.getValue() != null){
            addButton.setDisable(false);
        }*/
        //
        addButton.setOnAction(event ->{
            String creatureName = NameTextFieldAdd.getText(); //On récupère le nom de la r=créature dans le textField
            String creatureAge = ageChoicBox.getValue().toString();
            String creatureGender = genderChoicBox.getValue().toString();
            String creatureWeight = weightTextFieldAdd.getText();
            String creatureHeight = heightTextFieldAdd.getText();
            String creatureHealth = healthChoicBox.getValue().toString();

            Label creatureNameLabel = new Label(creatureName);
            Label creatureageAgeLabel = new Label(creatureAge);
            Label creatureageGenderLabel = new Label(creatureGender);
            Label creatureWeightLabel = new Label(creatureWeight);
            Label creatureHeightLabel = new Label(creatureHeight);
            Label creatureHealthLabel = new Label(creatureHealth);

            gridPane.addRow(gridPane.getRowCount(), creatureNameLabel, creatureageAgeLabel, creatureageGenderLabel, creatureWeightLabel, creatureHeightLabel, creatureHealthLabel);
        });
    }

    @FXML
    public  void removeCreature(ActionEvent actionEvent){

        actions.getChildren().removeAll(actions.getChildren());

        Label labelAdd = new Label("Entrez le nom d'une Créature à retirer");
        TextField textField = new TextField();
        actions.getChildren().addAll(labelAdd, textField);

        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String creatureName = textField.getText();
                if (this.enclosure.getCreaturesProperty() != null) {
                    for (AbstractCreature abstractCreature : this.enclosure.getCreaturesProperty()) {
                        if (abstractCreature != null && abstractCreature.getName().equals(creatureName)) {
                            this.enclosure.removeCreatures((T) abstractCreature);
                            //System.out.println(enclosure.showCreatures());
                            Label creatureLabel = new Label("Créature retirée : " + creatureName);
                            actions.getChildren().add(creatureLabel);
//                            gridPane.getChildren().remove();
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
        ArrayList<T> creatureList = (ArrayList<T>) this.enclosure.getCreatures();
        actions.getChildren().removeAll(actions.getChildren());
        for (T creature : creatureList) {
            this.enclosure.feedCreatures(creature);
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
}
