package fr;
import java.util.Scanner;
public class InOut {
    Scanner input = new Scanner(System.in);
    public void start(Scanner in){
        boolean play = false;
        while(play == false){
            System.out.println(
                            "--------------------------------------------------------------------------------------------\n"+
                            "Bonjour cher maitre du Zoo Fantastic ! Êtes vous prêt à commencer cette belle journée \n"+
                            "--------------------------------------------------------------------------------------------\n"+
                            "Oui bien sûr !\n"+
                            "Non merci\n"
            );
            String answer = input.next();
            // si la réponse est Oui le jeu se lance sinon le jeu s'arrête.
            play = true;
            if (answer.equals("Oui")){
                System.out.println(
                            "--------------------------------------------------------------------------------------------\n"+
                            "Vous avez fait un excellent choix \n"+
                            "--------------------------------------------------------------------------------------------\n"
                );
            }

            if (answer.equals("Non")){
                System.out.println(
                        "--------------------------------------------------------------------------------------------\n"+
                        "Oh non c'est dommage ! Peut-être une prochaine fois ! \n"+
                        "--------------------------------------------------------------------------------------------\n"
                );
                break;
            }
        }
    }
    public void playerChoice(Scanner in/*FantasticZooMaster zooMaster, Enclosure enclosure*/){
        boolean playerChoice = false;
        while (!playerChoice){
            boolean validInput;
            do {
                System.out.println(
                        "--------------------------------------------------------------------------------------------\n"+
                                "Qu'avez-vous prévu de faire aujourd'hui ? \n"+
                                "--------------------------------------------------------------------------------------------\n"+
                                "1. Examiner votre enclos\n"+
                                "2. Nettoyer votre enclos\n"+
                                "3. Nourrir les créatures de votre enclos\n"+
                                "4. Transférer une créature d'un enclos à l'autre\n"
                );
                int choice = in.nextInt();
                validInput = true;
                switch (choice){
                    case 1 :
                        playerChoice = true;
                        /*zooMaster.inspectEnclosure();*/
                        break;
                    case 2 :
                        playerChoice = true;
                        /*zooMaster.cleanEnclosure();*/
                        break;
                    case 3 :
                        playerChoice = true;
                        /*zooMaster.feedCreaturesInEnclosure();*/
                        break;
                    case 4 :
                        playerChoice = true;
                        /*zooMaster.transferCreatureBetweenEnclosures(paramètres);*/
                        break;
                    default :
                        System.out.println("Merci de saisir une autre valeur");
                        validInput = false;
                        break;
                }
            }while (!validInput);
        }
    }
}
