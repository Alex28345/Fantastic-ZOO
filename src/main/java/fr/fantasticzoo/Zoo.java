package fr.fantasticzoo;

import fr.fantasticzoo.enclosures.Aquarium;
import fr.fantasticzoo.enclosures.Aviary;
import fr.fantasticzoo.enclosures.Enclosure;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Zoo {
    private String name;
    private FantasticZooMaster fantasticZooMaster;

    final private int enclosureCount = 10;
    private Enclosure[] enclosures = new Enclosure[enclosureCount];
    private ObservableMap<Enclosure, Node> observableEnclosureMap;
    private static Zoo instance;


    public Zoo(String name, FantasticZooMaster fantasticZooMaster) {
        this.name = name;
        this.fantasticZooMaster = fantasticZooMaster;
        this.observableEnclosureMap = FXCollections.observableMap(new HashMap<Enclosure, Node>());
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

    public void addEnclosure(Enclosure enclosure) {
        for (int i = 0; i < enclosures.length; i++) {
            if (enclosures[i] == null && enclosures[i]!= enclosure) {
                enclosures[i] = enclosure;
                observableEnclosureMap.put(enclosure, new Button(enclosure.getName()));
                break;
            }
        }
    }

    public int getCreatureCount() {
        int creatureCount = 0;
        for (Enclosure enclosure : enclosures) {
            if (enclosure != null) {
                creatureCount += enclosure.getCreatureCount();
            }
        }
        return creatureCount;
    }

    public Enclosure getEnclosureWithButton(Button button) {
        return observableEnclosureMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(button))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public Enclosure[] getEnclosures() {
        return enclosures;
    }

    public ObservableMap<Enclosure, Node> getObservableEnclosureMap() {
        return observableEnclosureMap;
    }

    public Enclosure getEnclosureByName(String enclosureName) {
        for (Enclosure enclosure : enclosures) {
            if (enclosure != null && enclosure.getName().equals(enclosureName)) {
                return enclosure;
            }
        }
        return null;
    }
}
