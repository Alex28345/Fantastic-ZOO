package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Enclosure<T extends AbstractCreature> {
    private String name; //nom de l'enclos
    private String CREATURE_TYPE; //type de créature de l'enclos (le nom des créatures de l'enclos)
    private int surface; //surface en m²
    private int capacity; //nombre de créatures max
    private int creatureCount; //nombre de créatures
    private boolean cleanliness; //propreté

    private ObservableMap<AbstractCreature, Node> observableCreatureMap;

    public Enclosure(String name, int surface, int capacity) {
        this.name = name;
        this.surface = surface;
        this.capacity = capacity;
        this.creatureCount = 0;
        this.cleanliness = true;
        this.observableCreatureMap = FXCollections.observableMap(new HashMap<AbstractCreature, Node>());
    }

    public void addCreatures(T creature) {
        if (this.CREATURE_TYPE == null)
            this.CREATURE_TYPE = creature.getClass().toString();
        if(creature.getClass().toString().equals(CREATURE_TYPE)) {
            if(this.getCreatures().size() < capacity){
                if (!this.getCreatures().contains(creature) ) {
                    observableCreatureMap.put(creature, new Button(creature.getName()));
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
        this.getCreatures().remove(creature);
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

    public void setName(String name) { this.name = name; }

    public AbstractCreature getCreatureWithButton(Button button) {
        return observableCreatureMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(button))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public Set<AbstractCreature> getCreatures() {
        return observableCreatureMap.keySet();
    }

    public ObservableMap<AbstractCreature, Node> getObservableCreatureMap() {
        return observableCreatureMap;
    }
}
