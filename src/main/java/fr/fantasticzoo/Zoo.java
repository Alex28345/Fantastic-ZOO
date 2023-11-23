package fr.fantasticzoo;

import fr.fantasticzoo.enclosures.Enclosure;

import java.util.ArrayList;

public class Zoo {
    private String name;
    private FantasticZooMaster fantasticZooMaster;

    final private int enclosureCount = 10;
    private Enclosure[] enclosures = new Enclosure[enclosureCount];

    private ArrayList<Enclosure> LycanthropesEnclosures = new ArrayList<Enclosure>();
    private ArrayList<Enclosure> LicornesEnclosures = new ArrayList<Enclosure>();
    private ArrayList<Enclosure> NymphesEnclosures = new ArrayList<Enclosure>();
    private ArrayList<Enclosure> KrakensEnclosures = new ArrayList<Enclosure>();
    private ArrayList<Enclosure> SirènesEnclosures = new ArrayList<Enclosure>();
    private ArrayList<Enclosure> MégalodonsEnclosures = new ArrayList<Enclosure>();
    private ArrayList<Enclosure> PhénixEnclosures = new ArrayList<Enclosure>();
    private ArrayList<Enclosure> DragonsEnclosures = new ArrayList<Enclosure>();


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
}