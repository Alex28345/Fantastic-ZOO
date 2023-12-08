package fr.fantasticzoo.creatures.abstractClasses;

import fr.fantasticzoo.creatures.propertiesInterfaces.Immortal;
import fr.fantasticzoo.enclosures.Enclosure;
import fr.fantasticzoo.enums.Sex;

public abstract class AbstractCreature<creatureType extends AbstractCreature<creatureType>> {
    Enclosure<creatureType> enclosure;
    protected String name;
    protected Sex sex;

    protected int age;
    protected boolean isHungry;
    protected boolean isSleeping;
    protected boolean isSick;
    private double height;
    private double weight;
    private int maxAge;


    /**
     * Nourrit la créature
     */
    public void feed(){
        if(this.isHungry){
            this.isHungry = false;
            System.out.println(this.getName() + " est nourri");
        }
    }


    public Enclosure<creatureType> getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure<creatureType> enclosure) {
        this.enclosure = enclosure;
    }

    /**
     * Tue la créature
     */
    public void die(){
        if(this instanceof Immortal)
            ((Immortal) this).resurrect();
        else{
            System.out.println(this.getName() + " est mort");
            this.getEnclosure().removeCreatures((creatureType) this);
        }
    }

    /**
     * Emet un son
     */
    public void makeSound(){
        System.out.println("I'm making sound");
    }

    /**
     * Soigner la créature
     */
    public void heal(){
        if (this.isSick){
            this.isSick = false;
            System.out.println(this.getName() + " est soigné");
        }
    }
    public void age(){
        System.out.println("I'm aging");
    }

    /**
     * Obtient le nom de la créature.
     * @return Le nom de la créature.
     */
    public String getName() {
        return name;
    }

    /**
     * Définit le nom de la créature
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtient le genre de la créature
     * @return Le genre de la créature
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * Définit le genre de la créature
     * @param sex
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    /**
     * Obtient le poids de la créature
     * @return Le poids de la créature
     */
    public double getWeight() {
        return weight;
    }


    /**
     * Définit le poids de la créature
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }


    /**
     * Obtient la taille de la créature
     * @return La taille de la créature
     */
    public double getHeight() {
        return height;
    }

    /**
     * Définit la taille de la créature
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Obtient l'age de la créature
     * @return L'age de la créature
     */
    public int getAge() {
        return age;
    }

    /**
     * Définit la l'age de la créature
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Obtient le niveau de faim de la créature
     * @return Le niveau de faim de la créature
     */
    public boolean isHungry() {
        return isHungry;
    }


    /**
     * Définit si la créature a faim
     * @param hungry
     */
    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    /**
     * Obtient si la créature dort ou pas
     * @return La créature dort ou pas
     */
    public boolean isSleeping() {
        return isSleeping;
    }

    /**
     * Définit si la créature dort ou pas
     * @param sleeping
     */
    public void setSleeping(boolean sleeping) {
        isSleeping = sleeping;
    }


    /**
     * Obtient si la créature est malade ou pas
     * @return La créature est malade ou pas
     */
    public boolean isSick() {
        return isSick;
    }

    /**
     * Définit si la créature est malade ou pas
     * @param health
     */
    public void setSick(boolean health) {
        this.isSick = health;
    }

    /**
     * Obtient l'âge maximal de la créature
     * @return L'âge maximal de la créature
     */
    public int getMaxAge() {
        return this.maxAge;
    }
    /**
     * Définit l'âge maximal de la créature
     * @param maxAge
     */
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }



}
