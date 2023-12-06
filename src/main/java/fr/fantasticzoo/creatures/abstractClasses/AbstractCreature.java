package fr.fantasticzoo.creatures.abstractClasses;

import fr.fantasticzoo.creatures.propertiesInterfaces.Creature;
import fr.fantasticzoo.enums.Sex;

public abstract class AbstractCreature implements Creature {
    protected String name;
    protected Sex sex;
    protected double weight;
    protected double height;
    protected int age;
    protected boolean isHungry;
    protected boolean isSleeping;
    protected boolean isSick;

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
}
