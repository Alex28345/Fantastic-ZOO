package fr;

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

    public void feedCreaturesInEnclosure(/*Enclosure enclosure*/){
        /*enclosure.feedCreatures();*/
        areFeeded = true;
    }

}
