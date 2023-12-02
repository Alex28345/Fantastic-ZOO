package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.abstractClasses.Creature;
import fr.fantasticzoo.enclosures.Enclosure;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EnclosureController {
    private Zoo zoo;

    public void setZoo(Zoo zoo) {

        this.zoo = zoo;
    }
    private Button newButton = new Button();

     //private ArrayList <Enclosure> enclosureList = new ArrayList<Enclosure>(List.of(this.zoo.getEnclosures()));
     private Enclosure actualEnclosure;

    @FXML
    Label enclosureName;

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

        creatureShow.setText(enclosure.showCreatures());
        creaturesName.getChildren().add(creatureShow);
        /*for (int index = 0; index < enclosure.getCreatureCount(); ++index) {

        }*/
    }


}
