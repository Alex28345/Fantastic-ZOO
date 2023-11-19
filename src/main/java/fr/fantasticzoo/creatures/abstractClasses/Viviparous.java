package fr.fantasticzoo.creatures.abstractClasses;

import fr.fantasticzoo.enums.Sex;

public abstract class Viviparous extends Creature{
    public void giveBirth(){
        if(this.getSex() == Sex.female)
            System.out.println("I lays eggs.");
        else
            System.out.println("I can't lay eggs.");
    }
}
