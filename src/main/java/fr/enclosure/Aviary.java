package fr.enclosure;

import java.util.ArrayList;

public class Aviary extends Enclosure{
    private int height;


    public Aviary(String name, int surface, int capacity, int creatureCount, ArrayList<Creatures> creatures, boolean cleanliness, int height) {
        super(name, surface, capacity, creatureCount, creatures, cleanliness);
        this.height = height;
    }

    public void checkRoof(){
        //vide
    }
}
