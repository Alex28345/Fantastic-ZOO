package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Flyer;

public class Aviary<creatureType extends AbstractCreature & Flyer> extends Enclosure<creatureType> {
    private int height;


    public Aviary(String name, int surface, int capacity, int height) {
        super(name, surface, capacity);
        this.height = height;
    }

    /**
     * Ajoute une créature à la volière
     * @param creature
     */
    @Override
    public void addCreatures(creatureType creature) {
        if (creature != null){
            super.addCreatures(creature);
        }
        else{
            System.out.println("Vous ne pouvez pas ajouter la créature car elle ne vole pas");
        }
    }


    /**
     * Nettoie la volière
     */
    @Override
    public void clean(){
        System.out.println("La hauteur est de : " + this.height);
        super.clean();
    }

}
