package fr.fantasticzoo.creatures.propertiesInterfaces;

public interface Immortal {
    public default void resurrect(){
        System.out.println("I'm immortal");
    }
}
