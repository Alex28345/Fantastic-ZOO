package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.Creature;

import java.util.ArrayList;

public class Enclosure {
    private String name; //nom de l'enclos
    private int surface; //surface en m²
    private int capacity; //nombre de créatures max
    private int creatureCount; //nombre de créatures
    private ArrayList<Creature> creatures;
    private boolean cleanliness; //propreté

    public Enclosure(String name, int surface, int capacity, int creatureCount, ArrayList<Creature> creatures, boolean cleanliness) {
        this.name = name;
        this.surface = surface;
        this.capacity = capacity;
        this.creatureCount = creatureCount;
        this.creatures = creatures;
        this.cleanliness = true;
    }

    public String display(){
        return "Noms de l'enclos : " + name + "\n" + "Surface : " + surface + "\n" + "Capacité : " + capacity + "\n" + "Nombre de créatures présentes : " + creatureCount + "\n" + "Etat : " + cleanliness;
    }
     public void addCreatures(Creature creature){
        this.creatures.add(creature);
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
