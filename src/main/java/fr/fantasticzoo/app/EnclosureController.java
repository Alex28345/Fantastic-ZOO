package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Creature;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enclosures.StandardEnclosure;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


    public void setData(Enclosure<T> buttonStandardEnclosure) {
        this.enclosure = buttonStandardEnclosure;
        label.setText(this.enclosure.getName());
        this.zoo = Zoo.getInstance();

        enclosureName.setText(label.getText());
        System.out.println(this.enclosure);



        //informations de l'enclos
        enclosureSurface.setText(enclosureSurface.getText() + String.valueOf(this.enclosure.getSurface()) + "m²");
        enclosureCreaturesMax.setText(enclosureCreaturesMax.getText() + String.valueOf(this.enclosure.getCapacity()));
        enclosureCleanliness.setText(enclosureCleanliness.getText() + this.enclosure.getCleanlinessToString());
        enclosureCreaturesCount.setText(enclosureCreaturesCount.getText() + String.valueOf(this.enclosure.getCreatureCount()));

        ArrayList<String> creatureName = new ArrayList<>(this.enclosure.getCreaturesNames());
        for (String name : creatureName) {
            Label creatureShow = new Label(name);
            creaturesName.getChildren().add(creatureShow);
        }

        gridPane.add(name, 0, 0);
        gridPane.add(age, 1, 0);
        gridPane.add(gender, 2, 0);
        gridPane.add(weight, 3, 0);
        gridPane.add(height, 4, 0);
        gridPane.add(health, 5, 0);

        int rowIndex = 1;

        for (AbstractCreature abstractCreature : this.enclosure.getCreatures()) {
            if (abstractCreature != null) {
                Label creatureLabel = new Label(abstractCreature.getName() + " : ");
                gridPane.add(creatureLabel, 0, rowIndex);

                Label creatureInfoLabel = new Label(String.valueOf(abstractCreature.getAge()  + " " + abstractCreature.getSex() + abstractCreature.getWeight() + abstractCreature.getHeight() + abstractCreature.isSick()));
                age.setText(String.valueOf(abstractCreature.getAge()));
                gender.setText(String.valueOf(abstractCreature.getSex()));
                weight.setText(String.valueOf(abstractCreature.getWeight()));
                height.setText(String.valueOf(abstractCreature.getHeight()));
                health.setText(String.valueOf(abstractCreature.isSick()));

                gridPane.add(age, rowIndex,1);
                gridPane.add(gender, rowIndex, 2);
                gridPane.add(weight, rowIndex, 3);
                gridPane.add(height, rowIndex, 4);
                gridPane.add(health, rowIndex, 5);

                rowIndex++;
            }
        }
    }

    @FXML
    public void addCreature(ActionEvent actionEvent){
        actions.getChildren().removeAll(actions.getChildren());

        Label labelAdd = new Label("Entrez le nom d'une Créature à ajouter");
        TextField textField = new TextField();
        actions.getChildren().addAll(labelAdd, textField);

        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {

                String creatureName = textField.getText();
//                Creature newCreature = new Creature(creatureName);
//                enclosure.addCreatures(newCreature);

                Label creatureLabel = new Label("Nouvelle créature : " + creatureName);
                actions.getChildren().add(creatureLabel);

                textField.clear();
            }
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
//                            this.enclosure.removeCreatures();
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
