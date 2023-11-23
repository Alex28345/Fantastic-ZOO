package fr.fantasticzoo;

import fr.fantasticzoo.enclosures.Aquarium;
import fr.fantasticzoo.enclosures.Aviary;
import fr.fantasticzoo.enclosures.Enclosure;

import java.util.ArrayList;

public class Zoo {
    private String name;
    private FantasticZooMaster fantasticZooMaster;

    final private int enclosureCount = 10;
    private Enclosure[] enclosures = new Enclosure[enclosureCount];


    private ArrayList<Enclosure> VivariumsEnclosures = new ArrayList<Enclosure>();
    private ArrayList<Aviary> AviariesEnclosures = new ArrayList<Aviary>();
    private ArrayList<Aquarium> AquariumsEnclosures = new ArrayList<Aquarium>();



    public Zoo(String name, FantasticZooMaster fantasticZooMaster) {
        this.name = name;
        this.fantasticZooMaster = fantasticZooMaster;
    }

    public void addEnclosure(Enclosure enclosure) {
        for (int i = 0; i < enclosures.length; i++) {
            if (enclosures[i] == null && enclosures[i]!= enclosure) {
                enclosures[i] = enclosure;
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

    public Enclosure[] getEnclosures() {
        return enclosures;
    }

    public ArrayList<Enclosure> getVivariumsEnclosures() {
        return VivariumsEnclosures;
    }

    public ArrayList<Aviary> getAviariesEnclosures() {
        return AviariesEnclosures;
    }

    public ArrayList<Aquarium> getAquariumsEnclosures() {
        return AquariumsEnclosures;
    }
}
