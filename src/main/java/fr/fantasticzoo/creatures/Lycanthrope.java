package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Flyer;
import fr.fantasticzoo.creatures.propertiesInterfaces.Runner;
import fr.fantasticzoo.enums.Sex;

public class Lycanthrope extends Viviparous implements Flyer, Runner {
    public Lycanthrope(String name, int age, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
    }
}
