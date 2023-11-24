package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.*;
import fr.fantasticzoo.enums.Sex;

public class Dragon extends Oviparous implements Runner, Swimmer, Flyer, Immortal {
    public Dragon(String name, int age, Sex sex) {
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

    @Override
    public void run() {

    }

    @Override
    public void swim() {

    }
}