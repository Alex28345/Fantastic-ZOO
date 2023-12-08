package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Runner;
import fr.fantasticzoo.enums.Sex;

public class Unicorn extends AbstractCreature<Unicorn> implements Runner, Viviparous {
    public Unicorn(String name, int age, Sex sex, int weight, int height) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
        this.setMaxAge(60);
        this.setWeight(weight);
        this.setHeight(height);
    }
    public void giveBirth() {
        System.out.println("The lycanthrope gave birth to a baby lycanthrope.");
    }
}
