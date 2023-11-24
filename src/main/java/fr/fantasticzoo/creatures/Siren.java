package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Swimmer;
import fr.fantasticzoo.enums.Sex;

public class Siren extends Viviparous implements Swimmer {
    public Siren(String name, int age, Sex sex) {
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