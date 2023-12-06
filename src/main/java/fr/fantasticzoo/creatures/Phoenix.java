package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Flyer;
import fr.fantasticzoo.creatures.propertiesInterfaces.Immortal;
import fr.fantasticzoo.enums.Sex;

public class Phoenix extends AbstractCreature implements Flyer, Immortal, Oviparous {
    public Phoenix(String name, int age, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
    }
    public void layEggs() {
        System.out.println("The dragon gave birth to a baby dragon.");
    }
}