package fr.fantasticzoo;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class Game implements Runnable{
    private int i = 0;
    private Timer timer = new Timer();
    private JsonObject jsonParameters;
    private final GameLoop gameLoop;

    /**
     * Constructeur de la classe Game
     * Initialise les paramètres du jeu en lisant un fichier JSON et crée une instance de GameLoop
     * @throws FileNotFoundException
     */
    public Game() throws FileNotFoundException {
        jsonParameters = this.readJSON("src/main/resources/fr/fantasticzoo/app/properties.json");
        gameLoop = new GameLoop(jsonParameters);
    }

    /**
     * Exécute une tâche de manière répétée à intervalles réguliers en utilisant un TimerTask
     */
    public void run() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tour " + i);
                gameLoop.doLoop();
                i++;
            }
        };
        timer.schedule(task, 0, jsonParameters.getInt("timeBetweenTurns"));
    }

    /**
     * Lit le contenu d'un fichier JSON à partir du chemin spécifié
     * @param path
     * @return un objet JsonObject
     * @throws FileNotFoundException
     */
    private JsonObject readJSON(String path) throws FileNotFoundException {
        try {
            InputStream fis = new FileInputStream(path);
            JsonReader reader = Json.createReader(fis);
            JsonObject json = reader.readObject();
            reader.close();
            return json;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
    }


}
