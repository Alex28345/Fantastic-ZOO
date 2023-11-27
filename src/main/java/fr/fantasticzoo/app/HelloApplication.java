package fr.fantasticzoo.app;

import fr.fantasticzoo.FantasticZooMaster;
import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.Dragon;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enums.Sex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Zoo zoo = Zoo.getInstance("Zoo de la mort", new FantasticZooMaster("Jean", Sex.male));
        Enclosure enclosure = new Enclosure("premier enclos", 100, 100);
        enclosure.addCreatures(new Dragon("paul"));
        enclosure.showCreatures();
        zoo.addEnclosure(enclosure);


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("app.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Zoo fantastique");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}