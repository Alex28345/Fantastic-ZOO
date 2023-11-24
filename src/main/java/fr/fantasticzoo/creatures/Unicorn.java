package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Runner;
import fr.fantasticzoo.enums.Sex;

public class Unicorn extends Viviparous implements Runner {
    public Unicorn(String name, int age, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
    }
    @Override
    public void run() {

    }

}
