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
     * Nourrit les créature dans l'enclos
     * @param enclosure l'enclos actuel
     */
    public void feedCreatures(Enclosure<?> enclosure) {
        for (AbstractCreature<?> abstractCreature : enclosure.getCreatures()) {
            abstractCreature.feed();
        }
    }

    /**
     * Nettoie l'enclos
     * @param enclosure l'enclos actuel
     */
    public void cleanEnclosure(Enclosure<?> enclosure) {
        enclosure.clean();
    }

}
