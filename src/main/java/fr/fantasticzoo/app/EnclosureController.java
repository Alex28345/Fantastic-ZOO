package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.abstractClasses.Creature;
import fr.fantasticzoo.enclosures.Enclosure;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

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

    Label creatureShow = new Label("");

    private Label label = new Label("");

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

        creatureShow.setText(enclosure.showCreatures());
        creaturesName.getChildren().add(creatureShow);

        for (Creature creature : enclosure.getCreatures()) {
            if (creature != null){
                Label creatureLabel = new Label(creature.getName() + " : ");
                creaturesInfo.getChildren().add(creatureLabel);

                Label creatureInfoLablel = new Label("Age : " + String.valueOf(creature.getAge()
                        + " Sexe : " + creature.getSex() + " Poids : "+ creature.getWeight() +
                        " Hauteur : " + creature.getHeight() + " Etat de santé : " +  creature.getHealth()));
                creaturesInfo.getChildren().add(creatureInfoLablel);
            }
        }
    }

    @FXML
    public void addCreature(ActionEvent actionEvent){
        Enclosure enclosure = zoo.getEnclosureByName(String.valueOf(label));

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
        Enclosure enclosure = zoo.getEnclosureByName(String.valueOf(label));

        actions.getChildren().removeAll(actions.getChildren());

        Label labelAdd = new Label("Entrez le nom d'une Créature à retirer");
        TextField textField = new TextField();
        actions.getChildren().addAll(labelAdd, textField);

        textField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {

                String creatureName = textField.getText();
                for (Creature creature : enclosure.getCreatures()) {
                    if (creature.getName().equals(creatureName)){
                        enclosure.removeCreatures(creature);
                    }

                }

                Label creatureLabel = new Label("Créature retirée : " + creatureName);
                actions.getChildren().add(creatureLabel);

                textField.clear();
            }
        });
    }
    @FXML
    public void feedCreatures(ActionEvent actionEvent){
        Enclosure enclosure = zoo.getEnclosureByName(String.valueOf(label));

        actions.getChildren().removeAll(actions.getChildren());

        if(enclosure != null){
            for (Creature creature : enclosure.getCreatures()) {
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
        Enclosure enclosure = zoo.getEnclosureByName(String.valueOf(label));

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
