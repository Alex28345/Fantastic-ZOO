package fr.fantasticzoo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.fantasticzoo.creatures.abstractClasses.Creature;
import fr.fantasticzoo.enclosures.Enclosure;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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


                for(Enclosure enclosure : zoo.getEnclosures()) {
                    int randomForEnclosures = new Random().nextInt(100);
                    if(enclosure.getCreatureCount() > 0){
                        for(Creature creature : enclosure.getCreatures()) {
                            int randomForCreatures = new Random().nextInt(100);
                            if(!enclosure.getCleanliness()) {
                                if (randomForCreatures < rootNode.get("sickProbability").asInt()*1.5) {
                                    creature.setSick(true);
                                    System.out.println(creature.getName() + " est malade");
                                }
                                if (randomForCreatures < rootNode.get("sleepProbability").asInt()/1.5) {
                                    creature.setSleeping(true);
                                    System.out.println(creature.getName() + " dort");
                                }
                                if (randomForCreatures < rootNode.get("hungerProbability").asInt()*1.5) {
                                    creature.setHungry(true);
                                    System.out.println(creature.getName() + " a faim");
                                }
                            } else {
                                if (randomForCreatures < rootNode.get("sickProbability").asInt()) {
                                    creature.setSick(true);
                                    System.out.println(creature.getName() + " est malade");
                                }
                                if (randomForCreatures < rootNode.get("sleepProbability").asInt()) {
                                    creature.setSleeping(true);
                                    System.out.println(creature.getName() + " dort");
                                }
                                if (randomForCreatures < rootNode.get("hungerProbability").asInt()) {
                                    creature.setHungry(true);
                                    System.out.println(creature.getName() + " a faim");
                                }
                            }
                        }
                        if (randomForEnclosures < rootNode.get("cleanProbalility").asInt()) {
                            enclosure.setCleanliness(false);
                        }
                    }
                }


                i++;
            }
            public void creaturesGrow(){
                for (Creature creature : zoo.getCreatures()) {
                    creature.setAge(creature.getAge() + 1);
                }
            }


        };
        timer.schedule(task, 0, 3000);
    }


}
