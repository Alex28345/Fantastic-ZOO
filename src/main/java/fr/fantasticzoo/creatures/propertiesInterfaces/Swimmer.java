package fr.fantasticzoo.creatures.propertiesInterfaces;

public interface Swimmer {
    public default void swim(){
        System.out.println("I'm swimming");
    }
}
