package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Swimmer;
import fr.fantasticzoo.enums.Sex;

public class Kraken extends Oviparous implements Swimmer {

    public Kraken(String name, int age, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
    }

    @Override
    public void swim() {
    }
}