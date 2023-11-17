package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.abstractClasses.Oviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.*;
import javafx.scene.control.Button;

public class Dragon extends Oviparous implements Runner, Swimmer, Flyer, Immortal {
    public Dragon(String name) {
        this.name = name;
        System.out.printf("I'm a dragon, my name is %s%n", name);
    }

    @Override
    public void fly() {

    }

    @Override
    public void resurrect() {

    }

    @Override
    public void run() {

    }

    @Override
    public void swim() {

    }
}