package fr.fantasticzoo.creatures.abstractClasses;

import fr.fantasticzoo.enums.Sex;

public abstract class Oviparous extends Creature{
    public void layEggs(){
        if(this.getSex() == Sex.female)
            System.out.println("I lays eggs.");
        else
            System.out.println("I can't lay eggs.");
    }
}
