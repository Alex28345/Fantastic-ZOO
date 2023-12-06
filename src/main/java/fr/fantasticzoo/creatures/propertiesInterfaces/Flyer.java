package fr.fantasticzoo.creatures.propertiesInterfaces;

public interface Flyer {
    public default void fly() {
        System.out.println("I'm flying");
    }
}
