package fr.fantasticzoo.app;

import fr.fantasticzoo.FantasticZooMaster;
import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.Dragon;
import fr.fantasticzoo.creatures.StaticCreator;
import fr.fantasticzoo.creatures.Kraken;
import fr.fantasticzoo.creatures.Nymph;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enums.Sex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Zoo zoo = Zoo.getInstance("Zoo de la mort", new FantasticZooMaster("Jean", Sex.male));

        Enclosure enclosure = new Enclosure("Enclos de Dragons", 100, 100);
        enclosure.addCreatures(StaticCreator.createDragon("stormFly"));
        enclosure.addCreatures(StaticCreator.createDragon("Thornado"));
        enclosure.addCreatures(StaticCreator.createDragon("Toothless"));

        Enclosure enclosure1 = new Enclosure("Enclos de Nymphes", 100, 60);
        enclosure1.addCreatures(StaticCreator.createNymph("Azra"));
        enclosure1.addCreatures(StaticCreator.createNymph("Barde"));
        enclosure1.addCreatures(StaticCreator.createNymph("Tieffelin"));

        zoo.addEnclosure(enclosure);
        zoo.addEnclosure(enclosure1);

        zoo.start();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("app.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 800);
        stage.setTitle("Zoo fantastique");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest((WindowEvent event) -> {
            System.exit(0);
        });
    }

    public static void main(String[] args) {
        launch();
    }
}