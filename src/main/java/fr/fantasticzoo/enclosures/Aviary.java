package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Flyer;

public class Aviary<T extends AbstractCreature & Flyer> extends Enclosure<T> {
    private int height;


    public Aviary(String name, int surface, int capacity, int height) {
        super(name, surface, capacity);
        this.height = height;
    }

    @Override
    public void addCreatures(T creature) {
        if (creature != null){
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
