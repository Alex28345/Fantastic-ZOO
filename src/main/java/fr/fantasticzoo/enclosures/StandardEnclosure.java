package fr.fantasticzoo.enclosures;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Runner;

public class StandardEnclosure<T extends AbstractCreature & Runner> extends Enclosure<T>{

    public StandardEnclosure(String name, int surface, int capacity) {
        super(name, surface, capacity);
    }
}
