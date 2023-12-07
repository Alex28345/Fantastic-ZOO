package fr.fantasticzoo.creatures.Lycanthropes;

import fr.fantasticzoo.enums.DominationRank;
import fr.fantasticzoo.enums.Sex;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.round;

public class Pack {
    ArrayList<Lycanthrope> lycanthropeArrayList = new ArrayList<>();
    private int averageStrength;



    private Lycanthrope alphaMale;
    private Lycanthrope alphaFemale;
    public int getAverageStrength() {
        return averageStrength;
    }

    public Pack(ArrayList<Lycanthrope> lycanthropeArrayList) {
        this.lycanthropeArrayList.addAll(lycanthropeArrayList);
        this.averageStrength = setTotalStrength();
        this.alphaMale = selectAlphaMale();
        this.alphaFemale = selectAlphaFemale();
    }

    public Lycanthrope getAlphaMale() {
        return alphaMale;
    }

    public void setAlphaMale(Lycanthrope alphaMale) {
        this.alphaMale = alphaMale;
    }

    public Lycanthrope getAlphaFemale() {
        return alphaFemale;
    }

    public void setAlphaFemale(Lycanthrope alphaFemale) {
        this.alphaFemale = alphaFemale;
    }

    public int setTotalStrength() {
        int tmp = 0;
        for (Lycanthrope lycanthrope : lycanthropeArrayList) {
            tmp = tmp + lycanthrope.getStrength();
        }
        return tmp / lycanthropeArrayList.size();
    }
    public Lycanthrope selectAlphaMale(){
        if(lycanthropeArrayList.isEmpty()){
            return null;
        }
        Lycanthrope alphaMale = lycanthropeArrayList.get(0);
        for (Lycanthrope lycanthrope : lycanthropeArrayList) {
            if(lycanthrope.getLevel() > alphaMale.getLevel() && lycanthrope.getSex() == Sex.male){
                alphaMale = lycanthrope;
            }
        }
        alphaMale.setRankDomination(DominationRank.α);
        return alphaMale;
    }
    public Lycanthrope selectAlphaFemale(){
        if(lycanthropeArrayList.isEmpty()){
            return null;
        }
        Lycanthrope alphaFemale = lycanthropeArrayList.get(0);
        for (Lycanthrope lycanthrope : lycanthropeArrayList) {
            if(lycanthrope.getLevel() > alphaFemale.getLevel() && lycanthrope.getSex() == Sex.female){
                alphaFemale = lycanthrope;
            }
        }
        alphaFemale.setRankDomination(DominationRank.α);
        return alphaFemale;
    }
}
