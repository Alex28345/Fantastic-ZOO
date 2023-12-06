package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Creature;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class Enclosure<T extends AbstractCreature> {
    private String name; //nom de l'enclos
    private String CREATURE_TYPE; //type de créature de l'enclos (le nom des créatures de l'enclos)
    private int surface; //surface en m²
    private int capacity; //nombre de créatures max
    private int creatureCount; //nombre de créatures
    private ArrayList<T> creatures; //liste des cratures présentes
    private boolean cleanliness; //propreté
    private ArrayList<String> creaturesNames = new ArrayList<String>();
    private SimpleListProperty<T> creaturesProperty;

    public Enclosure(String name, int surface, int capacity) {
        this.name = name;
        this.surface = surface;
        this.capacity = capacity;
        this.creatures = new ArrayList<T>(capacity);
        this.creatureCount = 0;
        this.cleanliness = true;
        this.creaturesProperty = new SimpleListProperty<>(FXCollections.observableList(creatures));
    }

    public void addCreatures(T creature) {
        if (this.CREATURE_TYPE == null)
            this.CREATURE_TYPE = creature.getClass().toString();
        if(creature.getClass().toString().equals(CREATURE_TYPE)) {
            if(creatures.size() < capacity){
                if (!creatures.contains(creature) ) {
                    this.creatures.add(creature);
                    creatureCount++;
                    return;
                }else {
                    System.out.println("\u001B[31mLa créature est déjà dans l'enclos\u001B[0m");
                }
            }else {
                System.out.println("\u001B[31mL'enclos est plein\u001B[0m");
            }
        }else
            System.out.println("\u001B[31mLa créature n'est pas du bon type\u001B[0m");
    }

    public String display(){
        return "Noms de l'enclos : " + name + "\n" + "Surface : " + surface + "\n" + "Capacité : " + capacity + "\n" + "Nombre de créatures présentes : " + creatureCount + "\n" + "Etat : " + cleanliness;
    }

    public void removeCreatures(T creature){
        this.creatures.remove(creature);
    }
    /*Supprimme la dernière créature*/
    public void removeCreature(){
        this.creatures.remove(creatures.size()-1);
    }
    public void feedCreatures(T creature){
        if (creature != null){
            int index = creatures.indexOf(creature);
            if (index >= 0 && index < creatures.size()) {
                creatures.get(index).feed();
            }
            else{
                System.out.println("La créature n'a pas été touvée...");
            }
        }
        else{
            System.out.println("Pas de créature dans la liste");
        }
    }

    public void clean(){
        if (!getCleanliness()) {
            this.cleanliness = true;
            System.out.println(this.getName() + " est nettoyé");
        }
        System.out.println(this.getName() + " est prore");
    }

    public boolean getCleanliness(){ return cleanliness; }
    public void setCleanliness(boolean cleanliness) {
        this.cleanliness = cleanliness;
    }

    public String getCleanlinessToString(){
        if (cleanliness)
            return "Propre";
        else
            return "Sale";
    }

    public int getCreatureCount() { return creatureCount; }

    public String getName() { return name; }

    public int getSurface(){ return surface; }

    public int getCapacity(){ return capacity; }

    public String showCreatures() {
        StringBuilder creaturesInfo = new StringBuilder();
        for (T creature : creatures) {
            if (creature != null) {
                creaturesInfo.append(creature.getName()).append("\n");
            }
        }
        return creaturesInfo.toString();
    }

    public void setName(String name) { this.name = name; }

    public ArrayList<T> getCreatures() {
        return creatures;
    }

    public ObservableList<T> getCreaturesProperty() {
        return creaturesProperty.get();
    }

    public SimpleListProperty<T> creaturesProperty() {
        return creaturesProperty;
    }

    public void addCreaturesName(){
        if (creatures != null) {
            for (T creature : creatures) {
                if (creature != null) {
                    creaturesNames.add(creature.getName());
                }
            }
        } else {
            System.out.println("La liste de créatures est null.");
        }
    }

    public  ArrayList<String> getCreaturesNames(){
        this.addCreaturesName();
        return creaturesNames;
    }
}
