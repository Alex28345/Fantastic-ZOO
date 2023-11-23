package fr.fantasticzoo;

import fr.fantasticzoo.creatures.abstractClasses.Creature;

import java.util.Timer;
import java.util.TimerTask;
public class Game implements Runnable{
    private Zoo zoo;
    public Game(Zoo zoo) {
        this.zoo = zoo;
    }
    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            private int i = 0;

            public void run() {
                System.out.println("Game " + i);
                this.creaturesGrow();
                i++;
            }
            public void creaturesGrow(){
                for (Creature creature : zoo.getCreatures()) {
                    creature.setAge(creature.getAge() + 1);
                }
            }
        };
        timer.schedule(task, 0, 3000);
    }


}
