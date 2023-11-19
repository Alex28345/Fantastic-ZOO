package fr.fantasticzoo;

import fr.fantasticzoo.creatures.Dragon;
import fr.fantasticzoo.creatures.Nymph;
import fr.fantasticzoo.enclosures.Aviary;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enums.Sex;

import java.time.LocalDateTime;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("zoodeouf", new FantasticZooMaster("Jean", Sex.male));
        Enclosure enclosure = new Enclosure("premier enclos", 100, 100);
        enclosure.addCreatures(new Dragon("paul"));
        enclosure.addCreatures(new Dragon("paul2"));

        enclosure.showCreatures();

        zoo.addEnclosure(enclosure);



    }
}