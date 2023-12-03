package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.Creature;

import java.util.ArrayList;

public class Enclosure {
    private String name; //nom de l'enclos
    private String CREATURE_TYPE; //type de créature de l'enclos (le nom des créatures de l'enclos)
    final private int surface; //surface en m²
    private int capacity; //nombre de créatures max
    private int creatureCount; //nombre de créatures
    private ArrayList<Creature> creatures; //liste des cratures présentes
    private boolean cleanliness; //propreté

    public Enclosure(String name, int surface, int capacity) {
        this.name = name;
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
        return "Noms de l'enclos : " + name + "\n" + "Surface : " + surface + "\n" + "Capacité : " + capacity + "\n" + "Nombre de créatures présentes : " + creatureCount + "\n" + "Etat : " + cleanliness;
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
                     System.out.println("\u001B[31mLa créature est déjà dans l'enclos\u001B[0m");
                 }
             }
             System.out.println("\u001B[31mL'enclos est plein\u001B[0m");
         }else
             System.out.println("\u001B[31mLa créature n'est pas du bon type\u001B[0m");
     }
     public void removeCreatures(Creature creature){
        this.creatures.remove(creature);
     }
     /*Supprimme la dernière créature*/
     public void removeCreature(){
        this.creatures.remove(creatures.size()-1);
     }
     public void feedCreatures(Creature creature){
        this.creatures.get(this.creatures.indexOf(creature)).feed();
     }
     public void clean(){
        if(getCleanliness() == false){
            this.cleanliness = true;
            System.out.println(this.getName() + " est nettoyé");
        }
         System.out.println(this.getName() + " est prore");
     }

     public boolean getCleanliness(){
        return cleanliness;
     }

     public void setCleanliness(){
         this.cleanliness = true;
     }

     public String getCleanlinessToString(){
        if(cleanliness == true) return "Propre";
        else return "Sale";
     }

    public int getCreatureCount() { return creatureCount; }

    public String getName() { return name; }

    public int getSurface(){ return surface; }

    public int getCapacity(){ return capacity; }


    public String showCreatures() {
        StringBuilder creaturesInfo = new StringBuilder();
        for (Creature creature : creatures) {
            if (creature != null) {
                creaturesInfo.append(creature.getName()).append("\n");
            }
        }
        return creaturesInfo.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }
}
