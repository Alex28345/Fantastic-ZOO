package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.Creature;

import java.util.ArrayList;

public abstract class Enclosure {
    final private String NAME; //nom de l'enclos
    final private String CREATURE_TYPE; //type de créature de l'enclos
    final private int surface; //surface en m²
    private int capacity; //nombre de créatures max
    private int creatureCount; //nombre de créatures
    private ArrayList<Creature> creatures; //liste des cratures présentes
    private boolean cleanliness; //propreté

    public Enclosure(String name, String CREATURE_TYPE, int surface, int capacity, boolean cleanliness) {
        this.NAME = name;
        this.CREATURE_TYPE = CREATURE_TYPE;
        this.surface = surface;
        this.capacity = capacity;
        this.creatureCount = creatures.size();
        this.creatures = new ArrayList<Creature>();
        this.cleanliness = cleanliness;
    }

    public String display(){
        return "Noms de l'enclos : " + NAME + "\n" + "Surface : " + surface + "\n" + "Capacité : " + capacity + "\n" + "Nombre de créatures présentes : " + creatureCount + "\n" + "Etat : " + cleanliness;
    }
     public void addCreatures(Creature creature) {
         if (creature.getClass().equals(CREATURE_TYPE) == true) {
             for (int i = 0; i < creatures.size(); i++) {
                 if (creature.getName().equals(creatures.get(i).getName()) == false) {
                     this.creatures.add(creature);
                 }
             }
         }
     }
     public void removeCreatures(Creature creature){
        this.creatures.remove(creature);
     }
     public void feedCreatures(Creature creature){
        this.creatures.get(this.creatures.indexOf(creature)).feed();
     }
     public void clean(){
        this.cleanliness = true;
     }
}
