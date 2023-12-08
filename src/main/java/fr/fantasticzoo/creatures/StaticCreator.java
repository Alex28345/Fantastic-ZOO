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
        return new Dragon(name,0, randomSex(), 200, 100);
    }
    public static Kraken createKraken(String name){
        return new Kraken(name,0, randomSex(), 100, 90);
    }
    public static Lycanthrope createLycanthrope(String name){
        return new Lycanthrope(name, 0, randomSex(), new Random().nextInt(100), new Random().nextInt(100), 10, 50);
    }
    public static Megalodon createMegalodon(String name){
        return new Megalodon(name,0, randomSex(), 150, 80);
    }
    public static Nymph createNymph(String name){
        return new Nymph(name,0, randomSex(), 10, 50);
    }
    public static Phoenix createPhoenix(String name){
        return new Phoenix(name,0, randomSex(), 2, 10);
    }
    public static Siren createSiren(String name){
        return new Siren(name,0, randomSex(), 5, 20);
    }
    public static Unicorn createUnicorn(String name){
        return new Unicorn(name, 0, randomSex(), 50, 100);
    }

}
