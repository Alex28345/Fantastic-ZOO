package fr.fantasticzoo.creatures.Lycanthropes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Pack {
    ArrayList<Lycanthrope> lycanthropeArrayList = new ArrayList<>();
    int averageStrength;

    public void setTotalStrength(int totalStrength) {
        int tmp = 0;
        for (Lycanthrope lycanthrope : lycanthropeArrayList) {
            tmp = tmp + lycanthrope.getStrength();
        }
        this.averageStrength = tmp / lycanthropeArrayList.size();
    }
}
