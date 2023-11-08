package fr;
import java.util.Scanner;
public class InOut {
    Scanner input = new Scanner(System.in);
    public void start(Scanner in){
        boolean play = false;
        while(play == false){
            System.out.println(
                            "--------------------------------------------------------------------------------------------\n"+
                            "Bonjour cher maitre du Zoo Fantastic ! Que voulez vous faire aujourd'hui ? \n"+
                            "--------------------------------------------------------------------------------------------\n"+
                            "1. Examiner votre enclos\n"+
                            "2. Nettoyer votre enclos\n"+
                            "3. Nourrir les créatures de votre enclos\n"+
                            "4. Transférer une créature d'un enclos à l'autre\n"
            );
            String answer = input.next();
            // si la réponse est Oui le jeu se lance sinon le jeu s'arrête.
            play = true;

            public void playerChoice(Scanner in/*FantasticZooMaster zooMaster, Enclosure enclosure*/){
                boolean playerChoice = false;
            }
        }
    }
}
