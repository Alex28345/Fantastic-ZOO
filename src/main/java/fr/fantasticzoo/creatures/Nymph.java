package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Runner;
import fr.fantasticzoo.creatures.propertiesInterfaces.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Immortal;
import fr.fantasticzoo.enums.Sex;

public class Nymph extends AbstractCreature<Nymph> implements Runner, Immortal, Viviparous {
    public Nymph(String name, int age, Sex sex, int weight, int height) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
        this.setMaxAge(60);
        this.setWeight(weight);
        this.setHeight(height);
    }
    /**
     * La nymphe donne naissance
     */
    public void giveBirth() {
        System.out.println("The lycanthrope gave birth to a baby lycanthrope.");
    }

    /**
     * La nymphe renaît
     */
    public void resurrect() {
        System.out.println("The dragon resurrected.");
        this.setAge(0);
        this.setHungry(false);
        this.setSick(false);
        this.setSleeping(false);
    }
}
