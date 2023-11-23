package fr.fantasticzoo.creatures;

import fr.fantasticzoo.enums.Sex;

import java.util.Random;

public class StaticCreator {
    Random rand = new Random();
    public static Sex randomSex(){
        Random rand = new Random();
        int aleatoire = rand.nextInt(2);
        if(aleatoire == 0)
            return Sex.male;
        else
            return Sex.female;
    }

    public static Dragon createDragon(String name){
        return new Dragon(name, this::randomSex());
    }

}
