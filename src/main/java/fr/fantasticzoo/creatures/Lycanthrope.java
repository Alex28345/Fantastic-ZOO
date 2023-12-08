package fr.fantasticzoo.creatures;

import fr.fantasticzoo.creatures.Lycanthropes.Pack;
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

    public Lycanthrope(String name, int age, Sex sex, int strength, int impetuosityFactor, int weight, int height) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isHungry = false;
        this.isSick = false;
        this.strength = strength;
        this.impetuosityFactor = impetuosityFactor;
        this.setMaxAge(80);
        this.setWeight(weight);
        this.setHeight(height);
    }

    /**
     * Obtient le niveau d'une lycanthrope
     * @return Le niveau d'une lycanthrope
     */
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

    /**
     * Donner naissance
     */
    public void giveBirth() {
        System.out.println("The lycanthrope gave birth to a baby lycanthrope.");
    }

    /**
     * Obtient son classement de domination
     * @return Un classement
     */
    public DominationRank getRankDomination() { return rankDomination; }

    /**
     * Définit son classement de domination
     * @param rankDomination Un classement
     */
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

    /**
     * Se séparer de la meute
     */
    public void separatePack(){ System.out.println("Je me sépare de ma meute"); }

    /**
     * Se transformer en humain
     */
    public void humanTransformation(){ System.out.println("Je me transforme en humain"); }

    /**
     * Dominer une autre lycanthrope
     * @param victim
     */
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

    /**
     * Vérifie si la lycanthrope est un oméga
     * @return C'est un oméga ou pas
     */
    //Les lycanthropes ω sont des lycanthropes adultes considérés comme ayant une force insuffisante par rapport à la moyenne du groupe.
    public boolean isOmega(){
        if(this.getSex() == Sex.male && this.getAge() > 40 && this.getStrength() < pack.getAverageStrength()){
            this.setRankDomination(DominationRank.ω);
            return true;
        }
        return false;
    }

    /**
     * Vérifie si le lycanthrope est une femelle alpha
     * @param lycanthrope Le lycanthrope à vérifier
     * @return true si le lycanthrope est une femelle alpha, sinon false
     */
    public boolean isAlphaFemale(Lycanthrope lycanthrope){
        return lycanthrope.getRankDomination() == rankDomination.α && lycanthrope.getSex() == Sex.female;
    }

    /**
     * Simule un combat entre le lycanthrope actuel et une victime
     * Si le lycanthrope actuel a un niveau supérieur à la victime, il devient l'alpha de la meute
     * @param victim La victime du combat
     */
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
