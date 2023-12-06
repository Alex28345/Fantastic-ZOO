package fr.fantasticzoo.app;

import fr.fantasticzoo.FantasticZooMaster;
import fr.fantasticzoo.Game;
import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.enclosures.StandardEnclosure;
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

        StandardEnclosure standardEnclosure = new StandardEnclosure("Enclos de Dragons", 100, 100);
        standardEnclosure.addCreatures(createDragon("stormFly"));
        standardEnclosure.addCreatures(createDragon("Thornado"));
        standardEnclosure.addCreatures(createDragon("Toothless"));

        StandardEnclosure standardEnclosure1 = new StandardEnclosure("Enclos de Nymphes", 100, 60);
        standardEnclosure1.addCreatures(createNymph("Azra"));
        standardEnclosure1.addCreatures(createNymph("Barde"));
        standardEnclosure1.addCreatures(createNymph("Tieffelin"));

        zoo.addEnclosure(standardEnclosure);
        zoo.addEnclosure(standardEnclosure1);

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