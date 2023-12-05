package fr.fantasticzoo;

import fr.fantasticzoo.creatures.abstractClasses.Creature;
import fr.fantasticzoo.enclosures.Enclosure;

import javax.json.JsonObject;
import java.io.FileNotFoundException;
import java.util.Random;

public class GameLoop{
    private Zoo zoo;
    private JsonObject jsonParameters;
    public GameLoop( JsonObject jsonParameters) {
        this.zoo = Zoo.getInstance();
        this.jsonParameters = jsonParameters;
    }

    public void doLoop() {

        this.creaturesGrow();

        for (Enclosure enclosure : zoo.getEnclosures()) {
            int randomForEnclosures = new Random().nextInt(100);
            if (enclosure.getCreatureCount() > 0) {
                for (Creature creature : enclosure.getCreatures()) {
                    int randomForCreatures = new Random().nextInt(100);
                    if (!enclosure.getCleanliness()) {
                        if (randomForCreatures < jsonParameters.getInt("sickProbability") *1.5) {
                            creature.setSick(true);
                            System.out.println(creature.getName() + " est malade");
                        }
                        if (randomForCreatures < jsonParameters.getInt("sleepProbability") / 1.5) {
                            creature.setSleeping(true);
                            System.out.println(creature.getName() + " dort");
                        }
                        if (randomForCreatures < jsonParameters.getInt("hungerProbability") * 1.5) {
                            creature.setHungry(true);
                            System.out.println(creature.getName() + " a faim");
                        }
                    } else {
                        if (randomForCreatures < jsonParameters.getInt("sickProbability")) {
                            creature.setSick(true);
                            System.out.println(creature.getName() + " est malade");
                        }
                        if (randomForCreatures < jsonParameters.getInt("sleepProbability")) {
                            creature.setSleeping(true);
                            System.out.println(creature.getName() + " dort");
                        }
                        if (randomForCreatures < jsonParameters.getInt("hungerProbability")) {
                            creature.setHungry(true);
                            System.out.println(creature.getName() + " a faim");
                        }
                    }
                }
                if (randomForEnclosures < jsonParameters.getInt("cleanProbability")) {
                    enclosure.setCleanliness(false);
                }
            }
        }
    }
    private void creaturesGrow(){
        for (Creature creature : this.zoo.getCreatures()) {
            creature.setAge(creature.getAge() + 1);
        }
    }
}
