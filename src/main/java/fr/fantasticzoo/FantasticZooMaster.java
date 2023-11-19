package fr.fantasticzoo;

import fr.fantasticzoo.enums.Age;
import fr.fantasticzoo.enums.Sex;

public class FantasticZooMaster {
    private String name;
    private Sex sex;
    private Age age;

    private boolean isClean = false;
    private boolean areFeeded = false;

    public FantasticZooMaster(String name, Sex sex){
        this.name = name;
        this.sex = sex;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public String inspectEnclosure(/*Enclosure enclosure*/){
        String display = "enclosure.display()";
        return display;
    }

    public void cleanEnclosure(/*Enclosure enclosure*/){
        /*enclosure.clean();*/
        isClean = true;
    }

    public void feedCreaturesInEnclosure(/*Enclosure enclosure*/){
        /*enclosure.feedCreatures();*/
        areFeeded = true;
    }

    public void transferCreatureBetweenEnclosures(/*Enclosure departureEnclosure, Creature creature, arrivalEnclosure*/){
        /*arrivalEnclosure.addCreatures(creature);
        * departureEnclosure.remove(creature);*/
    }

}
