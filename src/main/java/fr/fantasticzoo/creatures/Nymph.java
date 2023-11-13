package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.propertiesInterfaces.Immortal;
import fr.fantasticzoo.creatures.propertiesInterfaces.Viviparous;

public class Nymph extends Creature implements Viviparous, Immortal {
    @Override
    public void giveBirth() {}
    @Override
    public void resurrect() {}
}
