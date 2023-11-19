package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.Creature;

import java.util.ArrayList;
import java.util.Arrays;

public class Enclosure {
    final private String NAME; //nom de l'enclos
    private String CREATURE_TYPE; //type de créature de l'enclos
    final private int surface; //surface en m²
    private int capacity; //nombre de créatures max
    private int creatureCount; //nombre de créatures
    private ArrayList<Creature> creatures; //liste des cratures présentes
    private boolean cleanliness; //propreté

    public Enclosure(String name, int surface, int capacity) {
        this.NAME = name;
        this.surface = surface;
        this.capacity = capacity;
        this.creatures = new ArrayList<Creature>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.creatures.add(null);
        }
        this.creatureCount = 0;
        this.cleanliness = true;
    }

    public String display(){
        return "Noms de l'enclos : " + NAME + "\n" + "Surface : " + surface + "\n" + "Capacité : " + capacity + "\n" + "Nombre de créatures présentes : " + creatureCount + "\n" + "Etat : " + cleanliness;
    }
     public void addCreatures(Creature creature) {
         if (this.CREATURE_TYPE == null)
             this.CREATURE_TYPE = creature.getClass().toString();
         if(creature.getClass().toString().equals(CREATURE_TYPE)) {
             for (int i = 0; i < creatures.size(); i++) {
                 if(creatures.get(i) == null){
                     if (!creatures.contains(creature) ) {
                         this.creatures.add(creature);
                         creatureCount++;
                         return;
                     }
                     throw new IllegalArgumentException("\u001B[31mLa créature est déjà dans l'enclos\u001B[0m");
                 }
             }
             throw new IllegalArgumentException("\u001B[31mL'enclos est plein\u001B[0m");
         }else
             System.out.println("\u001B[31mLa créature n'est pas du bon type\u001B[0m");
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

    public int getCreatureCount() {
        return creatureCount;
    }

    public String getName() {
        return NAME;
    }

    public void showCreatures() {
        for (Creature creature : creatures) {
            if (creature != null) {
                System.out.println(creature.getName());
            }
        }
    }
}
