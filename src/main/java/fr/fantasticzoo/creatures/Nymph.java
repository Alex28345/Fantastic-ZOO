package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Immortal;

public class Nymph extends Viviparous implements Immortal {
    public Nymph(String name) {
        this.name = name;
    }
    @Override
    public void resurrect() {}
}
