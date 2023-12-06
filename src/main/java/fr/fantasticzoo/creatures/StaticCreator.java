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
        return new Dragon(name,0, randomSex());
    }
    public static Kraken createKraken(String name){
        return new Kraken(name,0, randomSex());
    }
    public static Lycanthrope createLycanthrope(String name){
        return new Lycanthrope(name,0, randomSex());
    }
    public static Megalodon createMegalodon(String name){
        return new Megalodon(name,0, randomSex());
    }
    public static Nymph createNymph(String name){
        return new Nymph(name,0, randomSex());
    }
    public static Phoenix createPhoenix(String name){
        return new Phoenix(name,0, randomSex());
    }
    public static Siren createSiren(String name){
        return new Siren(name,0, randomSex());
    }
    public static Unicorn createUnicorn(String name){
        return new Unicorn(name, 0, randomSex());
    }

}
