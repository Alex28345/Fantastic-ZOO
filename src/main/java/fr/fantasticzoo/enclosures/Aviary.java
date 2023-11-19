package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.Creature;

import java.util.ArrayList;

public class Aviary extends Enclosure{
    private int height;


    public Aviary(String name, int surface, int capacity, int height) {
        super(name, surface, capacity);
        this.height = height;
    }

    public void checkRoof(){
        //vide
    }
}
