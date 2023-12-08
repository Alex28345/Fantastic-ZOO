package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Swimmer;
import fr.fantasticzoo.enums.Sex;

public class Kraken extends AbstractCreature<Kraken> implements Swimmer, Oviparous {

    public Kraken(String name, int age, Sex sex, int weight, int height) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
        this.setMaxAge(150);
        this.setWeight(weight);
        this.setHeight(height);

    }

    /**
     * Pond des oeufs
     */
    public void layEggs() {
        System.out.println("The dragon gave birth to a baby dragon.");
    }

}