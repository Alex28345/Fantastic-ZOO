package fr.fantasticzoo.creatures;


import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Swimmer;
import fr.fantasticzoo.enums.Sex;

public class Megalodon extends AbstractCreature implements Swimmer, Oviparous{
    public Megalodon(String name, int age, Sex sex) {
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