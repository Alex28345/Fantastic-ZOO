package fr.fantasticzoo.creatures.propertiesInterfaces;

import fr.fantasticzoo.creatures.propertiesInterfaces.Creature;
public interface Swimmer {
    public default void swim(){
        System.out.println("I'm swimming");
    }
}
