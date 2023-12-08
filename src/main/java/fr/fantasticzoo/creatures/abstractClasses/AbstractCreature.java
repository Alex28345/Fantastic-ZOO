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
    public void die(){
        if(this instanceof Immortal)
            ((Immortal) this).resurrect();
        else{
            System.out.println(this.getName() + " est mort");
            this.getEnclosure().removeCreatures((creatureType) this);
        }
    }
    public void makeSound(){
        System.out.println("I'm making sound");
    }
    public void heal(){
        if (this.isSick){
            this.isSick = false;
            System.out.println(this.getName() + " est soigné");
        }
    }
    public void age(){
        System.out.println("I'm aging");
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean sleeping) {
        isSleeping = sleeping;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean health) {
        this.isSick = health;
    }

    public int getMaxAge() {
        return this.maxAge;
    }
    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }



}
