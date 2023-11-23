package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.Creature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Swimmer;

import java.util.ArrayList;

public class Aquarium extends Enclosure{
    private int depth;
    private boolean salinity;


    public Aquarium(String name, int surface, int capacity, int depth) {
        super(name, surface, capacity);
        this.depth = depth;
        this.salinity = false;
    }

    @Override
    public void addCreatures(Creature creature) {
        if (creature instanceof Swimmer){
            super.addCreatures(creature);
        }
        else{
            System.out.println("Vous ne pouvez pas ajouter la créature car elle ne nage pas");
        }
    }

    @Override
    public void clean(){
        System.out.println("La profondeur est de : " + this.depth);
        if (this.salinity == true){
            super.clean();
            System.out.println("L'aquarium est nettoyé");
        }
    }
}
