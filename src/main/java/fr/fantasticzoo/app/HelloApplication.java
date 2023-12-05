package fr.fantasticzoo.app;

import fr.fantasticzoo.FantasticZooMaster;
import fr.fantasticzoo.Game;
import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enums.Sex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

import static fr.fantasticzoo.creatures.StaticCreator.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Zoo zoo = Zoo.getInstance("Zoo de la mort", new FantasticZooMaster("Jean", Sex.male));

        Enclosure enclosure = new Enclosure("Enclos de Dragons", 100, 100);
        enclosure.addCreatures(createDragon("stormFly"));
        enclosure.addCreatures(createDragon("Thornado"));
        enclosure.addCreatures(createDragon("Toothless"));

        Enclosure enclosure1 = new Enclosure("Enclos de Nymphes", 100, 60);
        enclosure1.addCreatures(createNymph("Azra"));
        enclosure1.addCreatures(createNymph("Barde"));
        enclosure1.addCreatures(createNymph("Tieffelin"));

        zoo.addEnclosure(enclosure);
        zoo.addEnclosure(enclosure1);

        Game game = new Game();
        Thread gameThread = new Thread(game);
        gameThread.start();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("app.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 800);
        stage.setTitle("Zoo fantastique");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest((WindowEvent event) -> {
            System.exit(0);
        });
    }

    //TO DO : changeScene() method en generic
    public static EnclosureController changeScene(Stage stage, String fxml, String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 900, 800);
        stage.setTitle(name);
        stage.setScene(scene);
        stage.show();
        return fxmlLoader.getController();
    }

    public static void main(String[] args) {
        launch();
    }
}