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
        /*for (int index = 0; index < enclosure.getCreatureCount(); ++index) {

        }*/
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
