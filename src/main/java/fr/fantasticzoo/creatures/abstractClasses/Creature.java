package fr.fantasticzoo.creatures.abstractClasses;


import fr.fantasticzoo.creatures.enums.Sex;
import fr.fantasticzoo.creatures.enums.Age;
import javafx.scene.control.Button;

public abstract class Creature {
    protected Button button;
    protected String name;
    protected Sex sex;
    protected double weight;
    protected double height;
    protected Age age;
    protected boolean isHungry;
    protected boolean isSleeping;
    protected int health;

    public void feed(){
        System.out.println("I'm eating");
    }
    public void makeSound(){
        System.out.println("I'm making sound");
    }
    public void heal(){
        System.out.println("I'm healing");
    }
    public void sleep(){
        System.out.println("I'm sleeping");
    }
    public void wakeUp(){
        System.out.println("I'm waking up");
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

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
