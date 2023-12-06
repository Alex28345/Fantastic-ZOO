package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Swimmer;
import fr.fantasticzoo.enums.Sex;

public class Siren extends AbstractCreature implements Swimmer, Viviparous {
    public Siren(String name, int age, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
    }
    public void giveBirth() {
        System.out.println("The lycanthrope gave birth to a baby lycanthrope.");
    }
}