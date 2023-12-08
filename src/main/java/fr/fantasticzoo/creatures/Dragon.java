package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.*;
import fr.fantasticzoo.enums.Sex;

public class Dragon extends AbstractCreature<Dragon> implements Runner, Swimmer, Flyer, Immortal, Oviparous{
    public Dragon(String name, int age, Sex sex, int weight, int height) {
        this.name = name;
        this.setWeight(weight);
        this.setHeight(height);
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
        this.setMaxAge(500);
    }
    public void layEggs() {
        System.out.println("The dragon gave birth to a baby dragon.");
    }
    public void resurrect() {
        System.out.println("The dragon resurrected.");
        this.setAge(0);
        this.setHungry(false);
        this.setSick(false);
        this.setSleeping(false);
    }
}