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

    /**
     * Obtient une instance unique de la classe Zoo. Si aucune instance n'existe, en crée une avec les
     * paramètres spécifiés
     * @param name Le nom du zoo.
     * @param fantasticZooMaster Le maître fantastique du zoo.
     * @return L'instance unique de la classe Zoo.
     */
    public static synchronized Zoo getInstance(String name, FantasticZooMaster fantasticZooMaster) {
        if (instance == null) {
            instance = new Zoo(name, fantasticZooMaster);
        }
        return instance;
    }
    /**
     * Obtient l'instance unique de la classe Zoo.
     * Si l'instance n'a pas été initialisée, une IllegalStateException est levée.
     * @return L'instance unique de la classe Zoo.
     * @throws IllegalStateException si l'instance n'a pas été initialisée.
     */
    public static synchronized Zoo getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Zoo not initialized. Call getInstance(String name, FantasticZooMaster fantasticZooMaster) first.");
        }
        return instance;
    }

    /**
     * Ajoute un nouvel enclos
     * @param enclosure
     */
    public void addEnclosure(Enclosure<?> enclosure) {
        if(observableEnclosureMap.size() >= enclosureCount) {
            System.out.println("L'enclos n'a pas pu être ajouté, le zoo est plein");
        }else{
            observableEnclosureMap.put(enclosure, new Button(enclosure.getName()));
        }
    }

    /**
     * Récupère le nombre de créatures dans l'enclos
     * @return Le nombre de créatures
     */
    public int getCreatureCount() {
        int creatureCount = 0;
        for (Enclosure<?> enclosure : this.getEnclosures()) {
            if (enclosure != null) {
                creatureCount += enclosure.getCreatureCount();
            }
        }
        return creatureCount;
    }

    /**
     * Obtient une ArrayList de créatures
     * @return Une liste de créatures
     */
    public ArrayList<AbstractCreature> getCreatures() {
        ArrayList<AbstractCreature> abstractCreatures = new ArrayList<AbstractCreature>();
        int i = 0;
        for (Enclosure<?> enclosure : this.getEnclosures()) {
            abstractCreatures.addAll(enclosure.getCreatures());
        }
        return abstractCreatures;
    }

    /**
     * Obtient l'enclos possèdant un bouton
     * @param button
     * @return Un enclos
     */
    public Enclosure<?> getEnclosureWithButton(Button button) {
        return observableEnclosureMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(button))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtient une liste d'enclos
     * @return Une lsite d'enclos
     */
    public Set<Enclosure<?>> getEnclosures() {
        return observableEnclosureMap.keySet();
    }


    /**
     * Obtient une liste observable d'enclos
     * @return Une liste observable d'enclos
     */
    public ObservableMap<Enclosure<?>, Node> getObservableEnclosureMap() {
        return observableEnclosureMap;
    }
}
