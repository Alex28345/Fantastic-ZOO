package fr.fantasticzoo.app;

import fr.fantasticzoo.FantasticZooMaster;
import fr.fantasticzoo.Zoo;
import fr.fantasticzoo.enums.Sex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("app.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Controller controller = fxmlLoader.<Controller>getController();

        Zoo zoo = new Zoo("Zoo de la mort", new FantasticZooMaster("Jean", Sex.male));
        controller.setZoo(zoo);


        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}