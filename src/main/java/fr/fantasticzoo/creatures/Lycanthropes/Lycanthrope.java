package fr.fantasticzoo.creatures.Lycanthropes;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Runner;
import fr.fantasticzoo.enums.DominationRank;
import fr.fantasticzoo.enums.Sex;

import static java.lang.Math.round;

public class Lycanthrope extends AbstractCreature implements Runner, Viviparous {
    //Lorsque le facteur de domination est en dessous d’un certain seuil, le lycanthrope perd naturellement un rang de domination s’il n’est pas le dernier de son sexe dans la meute à l’avoir (par exemple : le dernier mâle β d’une meute ne pourra pas devenir un mâle γ).
    private int strength;
    private int dominationFactor;
    private DominationRank rankDomination;
    private double level;
    private int impetuosityFactor;
    private Pack pack;

    public Lycanthrope(String name, int age, Sex sex, int strength, int impetuosityFactor) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
        this.strength = strength;
        this.impetuosityFactor = impetuosityFactor;
    }

    public double getLevel(){
        double level = 0;
        if (this.getAge() < 20){
            level = 0.8*this.strength*this.dominationFactor;
        }
        else if (this.getAge() < 40){
            level = 1.5*this.strength*this.dominationFactor;
        }
        else if (this.getAge() < 60){
            level = this.strength*this.dominationFactor;
        }
        else if (this.getAge() < 80){
            level = 0.5*this.strength*this.dominationFactor;
        }
        if(this.getSex() == Sex.male){
            level = level * 1.2;
        }
        return level;
    }

    public void giveBirth() {
        System.out.println("The lycanthrope gave birth to a baby lycanthrope.");
    }

    public DominationRank getRankDomination() { return rankDomination; }
    public void setRankDomination(DominationRank rankDomination) { this.rankDomination = rankDomination; }

    public int getStrength() { return strength; }

    public int getDominationFactor() { return dominationFactor; }
    public void setDominationFactor(int dominationFactor) { this.dominationFactor = dominationFactor; }
    public int getImpetuosityFactor() {
        return impetuosityFactor;
    }
    public void setImpetuosityFactor(int impetuosityFactor) {
        this.impetuosityFactor = impetuosityFactor;
    }

    public void hearScream(){ System.out.println("J'entend un cri"); }
    public Pack getPack(){
        if(this.pack == null)
            return null;
        return this.pack;
    }
    public void separatePack(){ System.out.println("Je me sépare de ma meute"); }
    public void humanTransformation(){ System.out.println("Je me transforme en humain"); }
    public void domination(Lycanthrope victim){
        if (victim.getImpetuosityFactor() <= this.getImpetuosityFactor() && !isAlphaFemale(victim) && this.getRankDomination() != DominationRank.ω){
            if (victim.getRankDomination() == DominationRank.α)
                this.fightAlpha(victim);

            else if (this.getLevel() > victim.getLevel() || victim.getRankDomination() == DominationRank.ω){

                this.setDominationFactor(this.getDominationFactor() + 1);
                victim.setDominationFactor(victim.getDominationFactor() - 1);

                DominationRank tmp = this.getRankDomination();
                this.setRankDomination(victim.getRankDomination());
                victim.setRankDomination(tmp);

                System.out.println("J'ai dominé ma victime");

            }
            else {
                this.setDominationFactor(this.getDominationFactor() -1);
                System.out.println("Je n'ai pas réussi ma domination, ma victime m'a agressé");
            }
        }
        else {
            this.setDominationFactor(this.getDominationFactor() -1);
            System.out.println("Je n'ai pas réussi ma domination, ma victime m'a agressé");
        }
    }

    //Les lycanthropes ω sont des lycanthropes adultes considérés comme ayant une force insuffisante par rapport à la moyenne du groupe.
    public boolean isOmega(){
        if(this.getSex() == Sex.male && this.getAge() > 40 && this.getStrength() < pack.getAverageStrength()){
            this.setRankDomination(DominationRank.ω);
            return true;
        }
        return false;
    }

    public boolean isAlphaFemale(Lycanthrope lycanthrope){
        return lycanthrope.getRankDomination() == rankDomination.α && lycanthrope.getSex() == Sex.female;
    }

    public void fightAlpha(Lycanthrope victim){
        if(this.getLevel() > victim.getLevel()){
            Pack pack = this.getPack();
            this.setRankDomination(DominationRank.α);
            victim.setRankDomination(this.getRankDomination());
            pack.getAlphaFemale().setRankDomination(DominationRank.β);

            pack.setAlphaMale(this);
            pack.setAlphaFemale(pack.selectAlphaFemale());

            System.out.println("J'ai dominé l'alpha de ma meute");
        }else {
            System.out.println("Je n'ai pas réussi à dominer l'alpha de ma meute");
        }
    }

    public void scream(){
        System.out.println("Je cri");
    }
}
