package fr.fantasticzoo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.fantasticzoo.creatures.abstractClasses.Creature;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class Game implements Runnable{
    private Zoo zoo;
    public Game(Zoo zoo) {
        this.zoo = zoo;
    }
    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            ObjectMapper objectMapper = new ObjectMapper();
            String filePath = "properties.json";
            JsonNode rootNode;

            {
                try {
                    rootNode = objectMapper.readTree(new File(filePath));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            String name = rootNode.get("name").asText();
            private int i = 0;

            public void run() {
                System.out.println("temps : " + i);
                this.creaturesGrow();
                int random = new Random().nextInt(100);
                if (random < rootNode.get("sickProbalility").asInt()) {
                    creaturesSick(new Random().nextInt(rootNode.get("sickMaxCount").asInt()));
                }
                if (random < rootNode.get("sickProbalility").asInt()) {
                    System.out.println("Un animal est né");
                }
                if (random < rootNode.get("sickProbalility").asInt()) {
                    System.out.println("Un animal est né");
                }
                if (random < rootNode.get("sickProbalility").asInt()) {
                    System.out.println("Un animal est né");
                }
                if (random < rootNode.get("sickProbalility").asInt()) {
                    System.out.println("Un animal est né");
                }
                if (random < rootNode.get("sickProbalility").asInt()) {
                    System.out.println("Un animal est né");
                }


                i++;
            }
            public void creaturesGrow(){
                for (Creature creature : zoo.getCreatures()) {
                    creature.setAge(creature.getAge() + 1);
                }
            }

            public void creaturesSick(int creatureSickCount){
                for(int i = 0; i < creatureSickCount; i++){
                    int random = new Random().nextInt(zoo.getCreatures().length);
                    if(!zoo.getCreatures()[random].isSick()){
                        zoo.getCreatures()[random].setSick(true);
                    }
                }
            }
        };
        timer.schedule(task, 0, 3000);
    }


}
