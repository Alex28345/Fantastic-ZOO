package fr.fantasticzoo.creatures.Lycanthropes;

import fr.fantasticzoo.creatures.Lycanthrope;
import fr.fantasticzoo.enums.DominationRank;
import fr.fantasticzoo.enums.Sex;

import java.util.ArrayList;
import java.util.Comparator;

import static java.lang.Math.round;

public class Pack {
    ArrayList<Lycanthrope> lycanthropeArrayList = new ArrayList<>();
    private Lycanthrope alphaMale;
    private Lycanthrope alphaFemale;

    public Pack(ArrayList<Lycanthrope> lycanthropeArrayList) {
        this.lycanthropeArrayList.addAll(lycanthropeArrayList);
        this.alphaMale = selectAlphaMale();
        this.alphaFemale = selectAlphaFemale();
        this.setAllDominationRank();
    }

    public void addLycanthrope(Lycanthrope lycanthrope){
        this.lycanthropeArrayList.add(lycanthrope);
        this.setAllDominationRank();
    }

    public void removeLycanthrope(Lycanthrope lycanthrope){
        this.lycanthropeArrayList.remove(lycanthrope);
        this.setAllDominationRank();
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

    public int getAverageStrength() {
        int tmp = 0;
        for (Lycanthrope lycanthrope : lycanthropeArrayList) {
            tmp = tmp + lycanthrope.getStrength();
        }
        return tmp / lycanthropeArrayList.size();
    }

    public void sortLycanthropesListByStrenght(){
        this.lycanthropeArrayList.sort(new Comparator<Lycanthrope>() {
            @Override
            public int compare(Lycanthrope l1, Lycanthrope l2) {
                return Integer.compare(l1.getStrength(), l2.getStrength());
            }
        });
    }

    public void setAllDominationRank(){
        if(this.lycanthropeArrayList.isEmpty()){
            return;
        }
        this.sortLycanthropesListByStrenght();
        int i = 0;
        DominationRank rank = DominationRank.β;
        for(Lycanthrope lycanthrope : this.lycanthropeArrayList){
            if(lycanthrope.getRankDomination() == DominationRank.α ){
                continue;
            }
            if(lycanthrope.getStrength() < this.getAverageStrength()){
                lycanthrope.setRankDomination(DominationRank.ω);
                continue;
            }
            lycanthrope.setRankDomination(rank);
            i++;
            if(i == 2) {
                rank = DominationRank.values()[rank.ordinal() + 1];
                i = 0;
            }
        }
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
