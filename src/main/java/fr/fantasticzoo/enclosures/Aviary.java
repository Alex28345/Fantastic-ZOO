package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.Creature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Flyer;
import fr.fantasticzoo.creatures.propertiesInterfaces.Swimmer;

import java.util.ArrayList;

public class Aviary extends Enclosure{
    private int height;


    public Aviary(String name, int surface, int capacity, int height) {
        super(name, surface, capacity);
        this.height = height;
    }

    @Override
    public void addCreatures(Creature creature) {
        if (creature instanceof Flyer){
            super.addCreatures(creature);
        }
        else{
            System.out.println("Vous ne pouvez pas ajouter la créature car elle ne vole pas");
        }
    }

    @Override
    public void clean(){
        System.out.println("La hauteur est de : " + this.height);
        super.clean();
    }

}
