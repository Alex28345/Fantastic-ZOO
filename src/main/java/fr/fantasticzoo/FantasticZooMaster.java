package fr.fantasticzoo;

import fr.fantasticzoo.creatures.abstractClasses.AbstractCreature;
import fr.fantasticzoo.enclosures.Enclosure;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }


    public void feedCreatures(Enclosure<?> enclosure) {
        for (AbstractCreature<?> abstractCreature : enclosure.getCreatures()) {
            abstractCreature.feed();
        }
    }

    public void cleanEnclosure(Enclosure<?> enclosure) {
        enclosure.clean();
    }
}
