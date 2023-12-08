package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Swimmer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Enclosure<creatureType extends AbstractCreature> {
    private String name; //nom de l'enclos
    private creatureType type; //type de créature de l'enclos
    private int surface; //surface en m²
    private int capacity; //nombre de créatures max
    private int creatureCount; //nombre de créatures

    private boolean cleanliness; //propreté


    private ObservableMap<creatureType, Node> observableCreatureMap;

    public Enclosure(String name, int surface, int capacity) {
        this.name = name;
        this.type = null;
        this.surface = surface;
        this.capacity = capacity;
        this.creatureCount = 0;
        this.cleanliness = true;
        this.observableCreatureMap = FXCollections.observableMap(new HashMap<>());
    }


    /**
     * Ajoute une créature à l'enclos
     * @param creature
     */
    public void addCreatures(creatureType creature) {
        if (this.type == null)
            this.type = creature;
        if(creature.getClass() == this.type.getClass()) {
            if(this.getCreatures().size() < capacity){
                if (!this.getCreatures().contains(creature) ) {
                    observableCreatureMap.put(creature, new Button(creature.getName()));
                    creature.setEnclosure(this);
                    creatureCount++;
                }else {
                    System.out.println("\u001B[31mLa créature est déjà dans l'enclos\u001B[0m");
                }
            }else {
                System.out.println("\u001B[31mL'enclos est plein\u001B[0m");
            }
        }else
            System.out.println("\u001B[31mLa créature n'est pas du bon type\u001B[0m");
    }

    /**
     * Supprime une créature de l'enclos
     * @param creature
     */
    public void removeCreatures(creatureType creature){
        this.observableCreatureMap.remove(creature);
    }

    /**
     * Nettoie l'enclos
     */
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

    /**
     * Obtient la propreté sous forme de chaine de caractère
     * @return Une chaine de caractère
     */
    public String getCleanlinessToString(){
        if (cleanliness)
            return "Propre";
        else
            return "Sale";
    }

    /**
     * Obtient le nombre de créatures dans l'enclos
     * @return Le nombre de créatures
     */
    public int getCreatureCount() { return creatureCount; }

    /**
     * Obtient le nom de l'enclos
     * @return Le nom de l'enclos
     */
    public String getName() { return name; }

    /**
     * Obtient la surface de l'enclos
     * @return La surface de l'enclos
     */
    public int getSurface(){ return surface; }

    /**
     * Obtient la capacité de l'enclos
     * @return La capacité de l'enclos
     */
    public int getCapacity(){ return capacity; }

    /**
     * Définit le nom de l'enclos
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     *  Obtient la créature qui été assignée au bouton en paramètre
     * @param button
     * @return La créature assignée au bouton
     */
    public creatureType getCreatureWithButton(Button button) {
        return observableCreatureMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(button))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtient une map observable de créatures
     * @return Une map observable
     */
    public Set<creatureType> getCreatures() {
        return observableCreatureMap.keySet();
    }

    /**
     * Obtient une observable map de créatures
     * @return Une observable map de créatures
     */
    public ObservableMap<creatureType, Node> getObservableCreatureMap() {
        return observableCreatureMap;
    }
}
