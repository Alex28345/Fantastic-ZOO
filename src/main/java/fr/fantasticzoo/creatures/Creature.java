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
}
