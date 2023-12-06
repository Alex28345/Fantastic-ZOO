package fr.fantasticzoo.creatures.Lycanthropes;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.creatures.propertiesInterfaces.Viviparous;
import fr.fantasticzoo.creatures.propertiesInterfaces.Runner;
import fr.fantasticzoo.enums.DominationRank;
import fr.fantasticzoo.enums.Sex;

public class Lycanthrope extends AbstractCreature implements Runner, Viviparous {
    //Lorsque le facteur de domination est en dessous d’un certain seuil, le lycanthrope perd naturellement un rang de domination s’il n’est pas le dernier de son sexe dans la meute à l’avoir (par exemple : le dernier mâle β d’une meute ne pourra pas devenir un mâle γ).
    private int strength;
    private int dominationFactor;
    private DominationRank rankDomination;
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
                ", health=" + isSick +
                '}';
    }
    public void giveBirth() {
        System.out.println("The lycanthrope gave birth to a baby lycanthrope.");
    }

    public DominationRank getRankDomination() { return rankDomination; }
    public void setRankDomination(DominationRank rankDomination) { this.rankDomination = rankDomination; }

    public int getStrength() { return strength; }

    public int getLevel() { return level; }

    public int getDominationFactor() { return dominationFactor; }
    public void setDominationFactor(int dominationFactor) { this.dominationFactor = dominationFactor; }

    public void hearScream(){ System.out.println("J'entend un cri"); }
    public void separatePack(){ System.out.println("Je me sépare de ma meute"); }
    public void humanTransformation(){ System.out.println("Je me transforme en humain"); }
    public void domination(Lycanthrope victim){
        if (victim.getStrength() <= this.getStrength() && victim.getRankDomination() != DominationRank.α){
            if (this.getLevel() > victim.getLevel() || victim.getRankDomination() == DominationRank.ω){

                this.setDominationFactor(this.getDominationFactor() +1);
                victim.setDominationFactor(victim.getDominationFactor() -1);

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
        if(this.getSex() == Sex.male && this.getAge() > 40 && this.getStrength() < pack.averageStrength){
            this.setRankDomination(DominationRank.ω);
            return true;
        }
        return false;
    }

    public void scream(){
        System.out.println("Je cri");
    }
}
