package fr.fantasticzoo;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Immortal;
import fr.fantasticzoo.enclosures.Enclosure;

import javax.json.JsonObject;
import java.util.Random;

public class GameLoop{
    private Zoo zoo;
    private JsonObject jsonParameters;

    /**
     * Initialise l'instance de Zoo en utilisant les paramètres JSON spécifiés
     * @param jsonParameters
     */
    public GameLoop( JsonObject jsonParameters) {
        this.zoo = Zoo.getInstance();
        this.jsonParameters = jsonParameters;
    }

    /**
     * Effectue une itération du cycle de jeu
     * Simule les activités des créatures dans chaque enclos en fonction des probabilités spécifiées
     */
    public void doLoop() {

        this.creaturesGrow();

        for (Enclosure<?> enclosure : zoo.getEnclosures()) {
            if(enclosure == null)
                return;
            if (enclosure.getCreatureCount() > 0) {
                for (AbstractCreature<?> creature : enclosure.getCreatures()) {

                        if (new Random().nextInt(100) < jsonParameters.getInt("sickProbability")) {
                            if(creature.isSick()) {
                                System.out.println(creature.getName() + " est mort");
                                creature.die();
                                break;
                            }
                            else{
                                creature.setSick(true);
                                System.out.println(creature.getName() + " est malade");
                            }
                        }
                        if (new Random().nextInt(100) < jsonParameters.getInt("sleepProbability")) {
                            if(creature.isSleeping()) {
                                creature.setSleeping(false);
                                System.out.println(creature.getName() + " se reveille");
                            }
                            else {
                                creature.setSleeping(true);
                                System.out.println(creature.getName() + " dort");
                            }
                        }
                        if (new Random().nextInt(100) < jsonParameters.getInt("hungerProbability")) {
                            if(creature.isHungry()) {
                                System.out.println(creature.getName() + " est mort");
                                creature.die();
                                break;
                            }
                            creature.setHungry(true);
                            System.out.println(creature.getName() + " a faim");
                        }

                }
                if (new Random().nextInt(100) < jsonParameters.getInt("cleanProbability")) {
                    enclosure.setCleanliness(false);
                    System.out.println(enclosure.getName() + " est sale");
                }
            }
        }
    }

    /**
     * Fait vieillir les créatures du zoo
     */
    private void creaturesGrow(){
        for (AbstractCreature<?> creature : this.zoo.getCreatures()) {
            if(creature.getAge() < creature.getMaxAge())
                creature.setAge(creature.getAge() + 1);
            else if (creature instanceof Immortal){
                ((Immortal) creature).resurrect();
            }else {
                creature.die();
            }
        }
    }
}
