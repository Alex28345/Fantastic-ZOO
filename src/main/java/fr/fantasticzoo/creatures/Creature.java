package fr.fantasticzoo.creatures;

public abstract class Creature {
    protected String name;
    protected String sex;
    protected double weight;
    protected double height;
    protected int age;
    protected boolean isHungry;
    protected boolean isSleeping;
    protected int health;

    public void feed(){}
    public void makeSound(){}
    public void heal(){}
    public void sleep(){}
    public void wakeUp(){}
    public void age(){}
}
