package fr.fantasticzoo;

public class FantasticZooMaster {
    private String name;
    private String gender;
    private int age;

    private boolean isClean = false;
    private boolean areFeeded = false;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
