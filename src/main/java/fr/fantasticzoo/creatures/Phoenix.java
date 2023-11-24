package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Flyer;
import fr.fantasticzoo.creatures.propertiesInterfaces.Immortal;
import fr.fantasticzoo.enums.Sex;

public class Phoenix extends Oviparous implements Flyer, Immortal {
    public Phoenix(String name, int age, Sex sex) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
    }
    @Override
    public void fly() {

    }
    @Override
    public void resurrect() {

    }
}