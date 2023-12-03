package fr.fantasticzoo.creatures.Lycanthropes;

import fr.fantasticzoo.creatures.abstractClasses.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Flyer;
import fr.fantasticzoo.creatures.propertiesInterfaces.Runner;

public class Lycanthrope extends Viviparous implements Runner {
    private int strength;
    private int dominationFactor;
    private int rankDomination;
    private int level;
    private int impetuosityFactor;
    private Pack pack;

    @Override
    public String toString() {
        return "Lycanthrope{" +
                "strength=" + strength +
                ", dominationFactor=" + dominationFactor +
                ", rankDomination=" + rankDomination +
                ", level=" + level +
                ", impetuosityFactor=" + impetuosityFactor +
                ", pack=" + pack +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", isHungry=" + isHungry +
                ", isSleeping=" + isSleeping +
                ", health=" + health +
                '}';
    }

    @Override
    public void run() {}

    public void scream(){}

    public void hearScream(){}

    public void separatePack(){}

    public void humanTransformation(){}
}
