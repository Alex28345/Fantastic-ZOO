package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.*;
import fr.fantasticzoo.enums.Sex;

public class Dragon extends AbstractCreature implements Runner, Swimmer, Flyer, Immortal, Oviparous{
    public Dragon(String name, int age, Sex sex) {
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