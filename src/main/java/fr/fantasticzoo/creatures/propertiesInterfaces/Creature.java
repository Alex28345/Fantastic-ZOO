package fr.fantasticzoo.creatures.propertiesInterfaces;

import fr.fantasticzoo.enums.Sex;

public interface Creature {

    public default void feed(){
        System.out.println("I'm eating");
    }
    public default void makeSound(){
        System.out.println("I'm making sound");
    }
    public default void heal(){
        System.out.println("I'm healing");
    }
    public default void age(){
        System.out.println("I'm aging");
    }

}
