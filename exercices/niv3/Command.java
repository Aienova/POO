import java.util.Scanner;

// Classe utilitaire pour les couleurs ANSI


public class Command {

    public static boolean checkCommand(String chainCommandExpected, Road road, String command, Car car, int i){
        boolean verdict = false;

        // Découper la chaîne de commande attendue en tableau
        String[] expectedCommands = chainCommandExpected.split("-");
        if(i >= expectedCommands.length) {
            System.out.println(Colors.success("Vous avez dépassé le nombre d'instructions attendues vous pouvez continuer à en tapant NX."));
            verdict = true; // Si l'index dépasse la longueur du tableau, retourner false
            return verdict;
        }
        // Cette méthode peut être utilisée pour vérifier si la commande saisie correspond à la chaîne attendue
        if (expectedCommands[i].equals(command)&& !command.equals("HELP")) {

            verdict = true;
        } 

        return verdict;
    }

    public static boolean checkIfYouCanContinue(boolean allowed) {
        if(!allowed) {
            System.out.println(Colors.warning("Vous n'avez pas fini toutes les instructions, vous ne pouvez pas passer à l'étape suivante."));
            return false;
        }else{
            System.out.println(Colors.success("Fin de l'étape, passons à l'étape suivante."));
            return true;
        }
    }

    public static int executeCommand(Car car,Road road, String expectedCommands, Scanner keyboard, int nbInstruction) {

        String cmd = "";// Lire la commande depuis le scanner
        int value = 0;
        int i = 0; // Index pour suivre la commande attendue
        boolean next = false;
        boolean allowed = true; // Variable pour vérifier si la commande est autorisée
         // Variable pour vérifier si la commande est inconnue
        // En prend la valeur de la commande attendue  A=10

        String[] values = StringtoTab(expectedCommands);

        while(i < values.length) {

            boolean unknownCommand = false;

            System.out.println(Colors.instruction("Instruction: " + road.getInstruction()));
                        System.out.println(Colors.header("Entrez votre commande (ou 'HELP' pour l'aide): "));

            System.out.println("Limitation de vitesse actuelle: " + Colors.warning(road.getSpeedLimit() + " km/h"));
            System.out.println("Aide du moniteur: " + Colors.help(MonitorHelp(values[i], true)));

            System.out.print( Colors.colorize("\nVitesse actuelle: " + car.getCurrentSpeed() + " km/h \n Points restants: " + road.getPoints() + " ", Colors.CYAN)+"\nVotre commande: ");

        cmd = keyboard.nextLine().toUpperCase();
    
        // Vérifier si la commande contient une valeur (par exemple, A=10)

        if(cmd.contains("=")) {

            System.out.println(Colors.info("Commande avec valeur détectée: " + cmd));

            String[] parts = cmd.split("=");
            if(parts.length == 2) {
                cmd = parts[0].trim();
                try {
                    value = Integer.parseInt(parts[1].trim());
                } catch (NumberFormatException e) {
                    System.out.println(Colors.error("Valeur invalide pour la commande, utilisez un nombre entier."));
                    return 0; // Retourne 0 pour indiquer une erreur
                }
            } else {
                System.out.println(Colors.error("Format de commande invalide, utilisez 'COMMAND=VALUE'."));
                return 0; // Retourne 0 pour indiquer une erreur
            }

            System.out.println(Colors.success("Commande splittée: " + cmd));

        }     

        System.out.println(Colors.colorize("*************Début Action*************\n\n\n", Colors.BOLD + Colors.GREEN));
        switch (cmd.toUpperCase()) {
            // Commandes de moteur
            case "D":
                
                car.startEngine();
                break;
            case "S":
                car.stopEngine();
                break;
            
            // Commandes de vitesse
            case "A":
                if(value <= 0) {
                    System.out.println(Colors.warning("La valeur d'accélération doit être supérieure à 0."));
                    return 0; // Continue la boucle pour demander une nouvelle commande
                }

                car.speedUp(value > 1 ? value : 1);

                break;
            case "R":
                if(value <= 0) {
                    System.out.println(Colors.warning("La valeur de décélération doit être supérieure à 0."));
                    return 0; // Continue la boucle pour demander une nouvelle commande
                }
                car.speedDown(value > 1 ? value : 1);
                break;
            case "F":
                car.brake();
                break;
            case "STOP":
                car.stop();
                break;
            
            // Commandes de boîte de vitesses
            case "V":
                car.gearbox(value);
                break;
            case "MA":
                car.reverseGear();
                break;

            // Commandes de direction
            case "TG":
                car.turnLeft();
                break;
            case "TD":
                car.turnRight();
                break;
            case "VG":
                car.changeLaneLeft();
                break;
            case "VD":
                car.changeLaneRight();
                break;

            // Commandes de contrôle visibilité
            case "VI":
                car.interiorVisibilityCheck();
                break;
            case "VE":
                car.exteriorVisibilityCheck();
                break;
            case "AM":
                car.blindSpotCheck();
                break;

            case "CV":
                
                car.checkVisibility();
                break;

            // Commandes de signalisation
            case "CG":
                car.leftIndicator();
                break;
            case "CD":
                car.rightIndicator();
                break;
            case "FC":
                car.headlights();
                break;
            case "EG":
                car.wipers();
                break;
            case "FD":
                car.hazardLights();
                break;
            case "K":
                car.horn();
                break;

            // Commande d'affichage de l'état
            case "STATUS":
                car.displayStatus();
                break;

            // Commande d'aide
            case "HELP":
                displayHelp();
                break; // Continue la boucle pour demander une nouvelle commande
            
                case "INFO" :
                road.displayRoadStatus();
                break;
            // Commande inconnue
            default:
                System.out.println(Colors.error("Commande inconnue. Tapez 'HELP' pour voir la liste des commandes."));
                unknownCommand = true; // Marquer la commande comme inconnue
                break;
            
        }


        boolean penalty = penaltyCommand(cmd, values[i], nbInstruction, road);
                if(road.getPoints() < 25) {

            System.out.println(Colors.warning("Attention, vous avez moins de 25 points restants !"));
            if(road.getPoints() < 20) {
                System.out.println(Colors.error("Vous avez en-dessous de 20 points, le test est terminé."));
                return 2; // Retourne 2 pour indiquer que le test est terminé
            }
          
        }
        System.out.println(Colors.colorize("*************Fin Action*************\n\n\n", Colors.BOLD + Colors.RED));
        // Vérifier si la commande saisie correspond à la chaîne attendue
        // (seulement si ce n'est pas NX ou HELP)
        if(!cmd.equals("HELP") && !cmd.equals("INFO") && unknownCommand == false && penalty == false) {
            allowed = checkCommand(expectedCommands, road, cmd, car, i);

            i++;
        }

        if(car.getCurrentSpeed() > road.getSpeedLimit()) {
            System.out.println(Colors.error("Vous avez dépassé la limitation de vitesse de " + road.getSpeedLimit() + " km/h."));
            System.out.println(Colors.colorize("Le moniteur prend le volant, le test est terminé.", Colors.BOLD + Colors.RED_BG + Colors.WHITE));
            return 2; // Retourne 2 pour indiquer que le test est terminé
        }

        if(allowed==false) {
            System.out.println(Colors.error("Vous n'avez pas suivi la bonne instructions, le moniteur prend le volant, le test est terminé."));
            return 2; // Retourne 2 pour indiquer que le test est terminé
        }

        }

            next = checkIfYouCanContinue(allowed);
        

        if(next==true){ return 1; }// Retourner 1 pour indiquer que la commande a été exécutée avec succès
        else{ return 0; }

    }
    

    /**
     * Affiche l'aide pour les commandes disponibles
     * Cette méthode peut être appelée lorsque l'utilisateur entre "HELP"
     */

     public static String[] StringtoTab(String command) {
        if (command.contains("-")) {
            String[] parts = command.split("-");
            return parts;
        }
        return new String[]{command}; // Retourne le command d'origine si '=' n'est pas trouvé
    }

    public static String MonitorHelp(String command,boolean enableMonitorHelp) {
        
        if (!enableMonitorHelp) {
            return "Aide du moniteur désactivée.";
        }
        switch(command) {
            case "D":
                return "Démarrer le moteur";
            case "S":
                return "Stopper le moteur";
            case "A":
                return "Accélérer (X km/h, défaut: 10)";
            case "R":
                return "Réduire vitesse (X km/h, défaut: 10)";
            case "F":
                return "Freiner";
            case "STOP":
                return "Arrêter complètement";
            case "V":
                return "Passer la vitesse X (0-5)";
            case "MA":
                return "Marche arrière";
            case "TG":
                return "Tourner à gauche";
            case "TD":
                return "Tourner à droite";
            case "VG":
                return "Changer de voie à gauche";
            case "VD":
                return "Changer de voie à droite";
            case "VI":
                return "Visibilité intérieure";
            case "VE":
                return "Visibilité extérieure";
            case "AM":
                return "Angles morts";
            case "CV":
                return "Vérification de la visibilité";
            case "CG":
                return "Clignotant gauche";
            case "CD":
                return "Clignotant droit";
            case "FC":
                return "Feux de croisement";
            case "EG":
                return "Essuie-glaces";
            case "FD":
                return "Feux de détresse";
            case "K":
                return "Klaxonner";
            case "STATUS":
                return "Afficher l'état de la voiture";
            default:
                return "Erreur : Commande inconnue"; // Commande inconnue
        }
    }




    public static boolean compareCommands(String chosenCommand, String command, String expectedCommand) {
        // Cette méthode peut être utilisée pour comparer deux chaînes de commande
        return (!command.equals(chosenCommand)) && (expectedCommand.equals(chosenCommand));
    }

    public static boolean testPenaltyCommand( String chosenCommand, String command, String expectedCommand, int penalty,String errorMessage, Road road) {
        System.out.println("seconde Vérification de la commande : " + chosenCommand);
                 boolean verdict=false;
        
                 if (compareCommands(chosenCommand, command, expectedCommand)== true) {
                    
                    road.setPoints(road.getPoints() - penalty); // Réduire les points du road
                    System.out.println(Colors.error(errorMessage));
                    System.out.println("Pénalité ajoutée: " + penalty);
                    verdict = true; // Retourne true si la commande est incorrecte
                    System.out.println("résultat verdict: " + verdict);
                    return verdict;
                }else{

                return verdict; // Retourne false si la commande est incorrecte
                }
                

    }

    public static String getErrorMessage(String command) {

        switch(command) {
            case "D":
                return "Veuillez démarrer la voiture !";
            case "S":
                return "Veuillez stopper la voiture !";
            case "A":
                return "Veuillez accélérer !";
            case "R":
                return "Veuillez réduire la vitesse !";
            case "F":
                return "Veuillez freiner !";
            case "STOP":
                return "Veuillez arrêter complètement la voiture !";
            case "V":
                return "Veuillez passer à la vitesse X !";
            case "MA":
                return "Veuillez passer en marche arrière !";
            default:
                return "Commande inconnue.";
        }   

    }

    public static int getPenalty(String command) {
        // Cette méthode peut être utilisée pour obtenir la pénalité associée à une commande
        switch(command) {
            case "D":
                return 0; // Pénalité pour démarrer le moteur
            case "S":
                return 30; // Pénalité pour stopper le moteur
            case "A":
                return 5; // Pénalité pour accélérer
            case "R":
                return 10; // Pénalité pour réduire la vitesse
            case "F":
                return 30; // Pénalité pour freiner
            case "STOP":
                return 40; // Pénalité pour arrêter complètement
            case "V":
                return 10; // Pénalité pour changer de vitesse
            case "MA":
                return 5; // Pénalité pour marche arrière
            default:
                return 0; // Aucune pénalité pour les autres commandes
        }
    }


    public static boolean penaltyCommand(String command,String expectedCommand,int indexInstruction,Road road) {

        System.out.println("Instruction n°" + indexInstruction + " Vérification penalité pour la commande : " + expectedCommand);
        boolean error = false;

        error=testPenaltyCommand( expectedCommand,command, expectedCommand, getPenalty(expectedCommand),getErrorMessage(expectedCommand),road);

  
        return error; // Aucune différence trouvée
    }

    public static void displayHelp() {
        System.out.println(Colors.header("=== GUIDE DES COMMANDES ==="));
        System.out.println(Colors.colorize("Moteur:", Colors.BOLD + Colors.YELLOW));
        System.out.println("  " + Colors.colorize("D", Colors.GREEN) + " - Démarrer le moteur");
        System.out.println("  " + Colors.colorize("S", Colors.RED) + " - Stopper le moteur");
        System.out.println();
        System.out.println(Colors.colorize("Vitesse:", Colors.BOLD + Colors.YELLOW));
        System.out.println("  " + Colors.colorize("A=X", Colors.GREEN) + " - Accélérer (X km/h, défaut: 10)");
        System.out.println("  " + Colors.colorize("R=X", Colors.YELLOW) + " - Réduire vitesse (X km/h, défaut: 10)");
        System.out.println("  " + Colors.colorize("F", Colors.RED) + " - Freiner");
        System.out.println("  " + Colors.colorize("STOP", Colors.RED) + " - Arrêter complètement");
        System.out.println();
        System.out.println(Colors.colorize("Boîte de vitesses:", Colors.BOLD + Colors.YELLOW));
        System.out.println("  " + Colors.colorize("V=X", Colors.BLUE) + " - Passer la vitesse X (0-5)");
        System.out.println("  " + Colors.colorize("MA", Colors.PURPLE) + " - Marche arrière");
        System.out.println();
        System.out.println(Colors.colorize("Direction:", Colors.BOLD + Colors.YELLOW));
        System.out.println("  " + Colors.colorize("TG", Colors.CYAN) + " - Tourner à gauche");
        System.out.println("  " + Colors.colorize("TD", Colors.CYAN) + " - Tourner à droite");
        System.out.println("  " + Colors.colorize("VG", Colors.BLUE) + " - Changer de voie à gauche");
        System.out.println("  " + Colors.colorize("VD", Colors.BLUE) + " - Changer de voie à droite");
        System.out.println();
        System.out.println(Colors.colorize("Contrôle visibilité:", Colors.BOLD + Colors.YELLOW));
        System.out.println("  " + Colors.colorize("VI", Colors.PURPLE) + " - Visibilité intérieure");
        System.out.println("  " + Colors.colorize("VE", Colors.PURPLE) + " - Visibilité extérieure");
        System.out.println("  " + Colors.colorize("AM", Colors.PURPLE) + " - Angles morts");
        System.out.println("  " + Colors.colorize("CV", Colors.PURPLE) + " - Vérification de la visibilité");
        System.out.println();
        System.out.println(Colors.colorize("Signalisation:", Colors.BOLD + Colors.YELLOW));
        System.out.println("  " + Colors.colorize("CG", Colors.GREEN) + " - Clignotant gauche");
        System.out.println("  " + Colors.colorize("CD", Colors.GREEN) + " - Clignotant droit");
        System.out.println("  " + Colors.colorize("FC", Colors.WHITE) + " - Feux de croisement");
        System.out.println("  " + Colors.colorize("EG", Colors.CYAN) + " - Essuie-glaces");
        System.out.println("  " + Colors.colorize("FD", Colors.RED) + " - Feux de détresse");
        System.out.println("  " + Colors.colorize("K", Colors.YELLOW) + " - Klaxonner");
        System.out.println();
        System.out.println(Colors.colorize("Autres:", Colors.BOLD + Colors.YELLOW));
        System.out.println("  " + Colors.colorize("STATUS", Colors.BLUE) + " - Afficher l'état de la voiture");
        System.out.println("  " + Colors.colorize("HELP", Colors.PURPLE) + " - Afficher cette aide");
        System.out.println(Colors.header("=========================="));
    }
    
    
}
