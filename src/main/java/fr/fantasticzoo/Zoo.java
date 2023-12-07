package fr.fantasticzoo;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.enclosures.Enclosure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Zoo {
    private String name;
    private FantasticZooMaster fantasticZooMaster;

    final private int enclosureCount = 10;
    private ObservableMap<Enclosure<?>, Node> observableEnclosureMap;
    private static Zoo instance;


    public Zoo(String name, FantasticZooMaster fantasticZooMaster) {
        this.name = name;
        this.fantasticZooMaster = fantasticZooMaster;
        this.observableEnclosureMap = FXCollections.observableMap(new HashMap<Enclosure<?>, Node>());
    }

    public static synchronized Zoo getInstance(String name, FantasticZooMaster fantasticZooMaster) {
        if (instance == null) {
            instance = new Zoo(name, fantasticZooMaster);
        }
        return instance;
    }
    public static synchronized Zoo getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Zoo not initialized. Call getInstance(String name, FantasticZooMaster fantasticZooMaster) first.");
        }
        return instance;
    }

    public void addEnclosure(Enclosure<?> enclosure) {
        if(observableEnclosureMap.size() >= enclosureCount) {
            System.out.println("L'enclos n'a pas pu être ajouté, le zoo est plein");
        }else{
            observableEnclosureMap.put(enclosure, new Button(enclosure.getName()));
        }
    }

    public int getCreatureCount() {
        int creatureCount = 0;
        for (Enclosure<?> enclosure : this.getEnclosures()) {
            if (enclosure != null) {
                creatureCount += enclosure.getCreatureCount();
            }
        }
        return creatureCount;
    }
    public ArrayList<AbstractCreature> getCreatures() {
        ArrayList<AbstractCreature> abstractCreatures = new ArrayList<AbstractCreature>();
        int i = 0;
        for (Enclosure<?> enclosure : this.getEnclosures()) {
            abstractCreatures.addAll(enclosure.getCreatures());
        }
        return abstractCreatures;
    }

    public Enclosure<?> getEnclosureWithButton(Button button) {
        return observableEnclosureMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(button))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public Set<Enclosure<?>> getEnclosures() {
        return observableEnclosureMap.keySet();
    }

    public ObservableMap<Enclosure<?>, Node> getObservableEnclosureMap() {
        return observableEnclosureMap;
    }
}
