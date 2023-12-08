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

    /**
     * Obtient le nom du maitre de zoo
     * @return Le nom du maitre de zoo
     */
    public String getName() {
        return name;
    }

    /**
     * Définit le nom du maitre de zoo
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtient le genre du maitre de zoo
     * @return Le genre du maitre de zoo
     */
    public Sex getSex() {
        return this.sex;
    }

    /**
     * Définit le genre du maitre de zoo
     * @param sex
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Obtient l'âge du maitre de zoo
     * @return L'âge du maitre de zoo
     */
    public Age getAge() {
        return age;
    }

    /**
     * Définit l'âge du maitre de zoo
     * @param age
     */
    public void setAge(Age age) {
        this.age = age;
    }

    /**
     * Inspecter l'enlos
     * @return Ce qu'il y'a dans l'enclos
     */
    public String inspectEnclosure(/*Enclosure enclosure*/){
        String display = "enclosure.display()";
        return display;
    }

    /**
     * Nettoie l'enclos
     */
    public void cleanEnclosure(/*Enclosure enclosure*/){
        /*enclosure.clean();*/
        isClean = true;
    }

    /**
     * Nourrit les créatures dans l'enclos
     */
    public void feedCreaturesInEnclosure(/*Enclosure enclosure*/){
        /*enclosure.feedCreatures();*/
        areFeeded = true;
    }

    /**
     * Transfert les créatures d'un enclos à l'autre
     */
    public void transferCreatureBetweenEnclosures(/*Enclosure departureEnclosure, Creature creature, arrivalEnclosure*/){
        /*arrivalEnclosure.addCreatures(creature);
        * departureEnclosure.remove(creature);*/
    }

}
