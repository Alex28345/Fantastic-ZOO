package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.propertiesInterfaces.Flyer;
import fr.fantasticzoo.creatures.propertiesInterfaces.Runner;

public class Lycanthrope extends Creature implements Flyer, Runner {
    @Override
    public void fly() {}
    @Override
    public void run() {}
}
