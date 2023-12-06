package fr.fantasticzoo;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Creature;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enclosures.StandardEnclosure;

import javax.json.JsonObject;
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

        for (Enclosure<?> enclosure : zoo.getEnclosures()) {
            if(enclosure == null)
                return;
            if (enclosure.getCreatureCount() > 0) {
                for (AbstractCreature creature : enclosure.getCreatures()) {
//                    if (!enclosure.getCleanliness()) {
//                        if (new Random().nextInt(100) < jsonParameters.getInt("sickProbability") *1.5) {
//                            creature.setSick(true);
//                            System.out.println(creature.getName() + " est malade");
//                        }
//                        if (new Random().nextInt(100) < jsonParameters.getInt("sleepProbability") / 1.5) {
//                            creature.setSleeping(true);
//                            System.out.println(creature.getName() + " dort");
//                        }
//                        if (new Random().nextInt(100) < jsonParameters.getInt("hungerProbability") * 1.5) {
//                            creature.setHungry(true);
//                            System.out.println(creature.getName() + " a faim");
//                        }
//                    } else {
                        if (new Random().nextInt(100) < jsonParameters.getInt("sickProbability")) {
                            creature.setSick(true);
                            System.out.println(creature.getName() + " est malade");
                        }
                        if (new Random().nextInt(100) < jsonParameters.getInt("sleepProbability")) {
                            creature.setSleeping(true);
                            System.out.println(creature.getName() + " dort");
                        }
                        if (new Random().nextInt(100) < jsonParameters.getInt("hungerProbability")) {
                            creature.setHungry(true);
                            System.out.println(creature.getName() + " a faim");
                        }
//                    }
                }
                if (new Random().nextInt(100) < jsonParameters.getInt("cleanProbability")) {
                    enclosure.setCleanliness(false);
                }
            }
        }
    }
    private void creaturesGrow(){
        for (AbstractCreature creature : this.zoo.getCreatures()) {
            creature.setAge(creature.getAge() + 1);
        }
    }
}
