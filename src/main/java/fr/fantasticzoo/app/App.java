package fr.fantasticzoo.app;

import fr.fantasticzoo.FantasticZooMaster;
import fr.fantasticzoo.Game;
import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.creatures.Dragon;
import fr.fantasticzoo.creatures.Nymph;
import fr.fantasticzoo.enclosures.StandardEnclosure;
import fr.fantasticzoo.enums.Sex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

import static fr.fantasticzoo.creatures.StaticCreator.*;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Zoo zoo = Zoo.getInstance("Zoo de la mort", new FantasticZooMaster("Jean", Sex.male));

        StandardEnclosure<Dragon> standardEnclosure = new StandardEnclosure<Dragon>("Enclos de Dragons", 100, 100);
        standardEnclosure.addCreatures(createDragon("stormFly"));
        standardEnclosure.addCreatures(createDragon("Thornado"));
        standardEnclosure.addCreatures(createDragon("Toothless"));

        StandardEnclosure<Nymph> standardEnclosure1 = new StandardEnclosure<Nymph>("Enclos de Nymphes", 100, 60);
        standardEnclosure1.addCreatures(createNymph("Azra"));
        standardEnclosure1.addCreatures(createNymph("Barde"));
        standardEnclosure1.addCreatures(createNymph("Tieffelin"));

        zoo.addEnclosure(standardEnclosure);
        zoo.addEnclosure(standardEnclosure1);

        Game game = new Game();
        Thread gameThread = new Thread(game);
        gameThread.start();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app.fxml"));
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