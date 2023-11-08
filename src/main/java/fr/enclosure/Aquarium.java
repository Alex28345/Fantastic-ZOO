package fr.enclosure;

import java.util.ArrayList;

public class Aquarium extends Enclosure{
    private int depth;
    private boolean salinity;


    public Aquarium(String name, int surface, int capacity, int creatureCount, ArrayList<Creatures> creatures, boolean cleanliness, int depth, boolean salinity) {
        super(name, surface, capacity, creatureCount, creatures, cleanliness);
        this.depth = depth;
        this.salinity = false;
    }

    public void checkDepth(){
        //vide
    }

    public void checkSalinity(){
        //vide
    }


}
