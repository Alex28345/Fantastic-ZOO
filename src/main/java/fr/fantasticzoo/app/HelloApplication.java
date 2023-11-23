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
import javafx.stage.WindowEvent;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("app.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);

        Controller controller = fxmlLoader.<Controller>getController();

        Zoo zoo = new Zoo("Zoo de la mort", new FantasticZooMaster("Jean", Sex.male));
        controller.setZoo(zoo);
        zoo.start();
        Enclosure enclosure = new Enclosure("premier enclos", 100, 10);
        enclosure.addCreatures(new Dragon("paul"));
        zoo.addEnclosure(enclosure);

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