package fr.fantasticzoo.creatures.propertiesInterfaces;

public interface Runner {
    public default void run(){
        System.out.println("I'm running");
    }
}
