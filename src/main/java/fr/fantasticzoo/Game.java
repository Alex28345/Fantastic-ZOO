package fr.fantasticzoo;

import fr.fantasticzoo.creatures.abstractClasses.Creature;
import fr.fantasticzoo.enclosures.Enclosure;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Game implements Runnable{
    private int i = 0;
    private Timer timer = new Timer();
    private JsonObject jsonParameters;
    private final GameLoop gameLoop;

    public Game() throws FileNotFoundException {
        jsonParameters = this.readJSON("src/main/resources/fr/fantasticzoo/app/properties.json");
        gameLoop = new GameLoop(jsonParameters);
    }


    public void run() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tour " + i);
                gameLoop.doLoop();
                i++;
            }
        };
        timer.schedule(task, 0, 3000);
    }


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
