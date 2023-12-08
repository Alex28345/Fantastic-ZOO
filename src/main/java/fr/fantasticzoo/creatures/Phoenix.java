package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Flyer;
import fr.fantasticzoo.creatures.propertiesInterfaces.Immortal;
import fr.fantasticzoo.enums.Sex;

public class Phoenix extends AbstractCreature<Phoenix> implements Flyer, Immortal, Oviparous {
    public Phoenix(String name, int age, Sex sex, int weight, int height) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
        this.setMaxAge(100);
        this.setWeight(weight);
        this.setHeight(height);
    }
    /**
     * Le phoenix pond des oeufs
     */
    public void layEggs() {
        System.out.println("The dragon gave birth to a baby dragon.");
    }

    /**
     * Le phoenix renaît
     */
    public void resurrect() {
        System.out.println("The dragon resurrected.");
        this.setAge(0);
        this.setHungry(false);
        this.setSick(false);
        this.setSleeping(false);
    }
}