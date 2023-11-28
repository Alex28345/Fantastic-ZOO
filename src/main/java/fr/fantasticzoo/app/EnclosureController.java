package fr.fantasticzoo.app;

import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.abstractClasses.Creature;
import fr.fantasticzoo.enclosures.Enclosure;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

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

    private String creatures;

    Label creatureShow;

    private Label label = new Label("");
    public void setData(String data) {
        label.setText(data);
        enclosureName.setText(label.getText());
        System.out.println(data);
        //actualEnclosure = enclosureList.get(enclosureList.indexOf(label.getText()));
        //int creatureCount = actualEnclosure.getCreatureCount();
        //actualEnclosure.showCreatures();
        /*
        for (int i = 0; i < creatureCount; i++) {
            //newButton.setText(toString(actualEnclosure.showCreatures()));
            actualEnclosure.showCreatures();
        }*/
    }


}
