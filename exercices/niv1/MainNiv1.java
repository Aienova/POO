package exercices.niv1;

import java.util.Scanner;

public class MainNiv1 {

    public static void main(String[] args) {
        // Ici, vous pouvez instancier la classe Bouteille et implémenter le menu d'action
        // pour ouvrir, boire et fermer la bouteille.
        
        // Exemple d'instanciation :
        Bouteille cocaCola = new Bouteille("Coca-Cola", 100, false, false);
        Scanner scanner = new Scanner(System.in);


        // Implémentez un menu d'action pour interagir avec la bouteille
        boolean continuer = true;
        int risk= 0;
        while (continuer) {
            
            cocaCola.infoBouteille();
            // Vérification aléatoire pour vider la bouteille
            if (cocaCola.isOpen() && (!cocaCola.isEmpty()) && Math.random() < 0.1*risk) { // 10% de chance
                System.out.println("Oups! la bouteille s'est vidée accidentellement");
                cocaCola.vider();
            }

            System.out.println("\nMenu :");
            System.out.println("1. Ouvrir la bouteille");
            System.out.println("2. Boire de la bouteille");
            System.out.println("3. Fermer la bouteille");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    cocaCola.ouvrir();
                    break;
                case 2:

                    if(!cocaCola.isOpen()) {
                        System.out.println("La bouteille n'est pas ouverte, vous devez l'ouvrir d'abord.");
                        break;
                    }

                    if(cocaCola.isEmpty()) {
                        System.out.println("La bouteille est vide, vous ne pouvez pas boire.");
                        break;
                    }



                    System.out.print("Quelle quantité voulez-vous boire ? ");
                    int quantite = scanner.nextInt();
                    cocaCola.boire(quantite);

                    

                    break;
                case 3:
                    cocaCola.fermer();
                    risk=0; // Réinitialiser le risque lorsque la bouteille est fermée
                    break;
                case 4:
                    continuer = false;
                    break;
                default:
                    System.out.println("Option invalide.");
            }

            if (cocaCola.isOpen()) {

                   risk++; // Incrémenter le risque pour augmenter la probabilité de vider la bouteille par accident
            }
         
        }

        scanner.close();
    }

}


/*  Exercice n°1 :
 *
 * Me créer en POO une classe Bouteille avec les attributs suivants :

        // Implémentez votre logique de menu ici...
    }
    
}


/*  Exercice n°1 : 
 * 
 * Me créer en POO une classe Bouteille avec les attributs suivants :
 * 
 * Liquide (Eau,Coca, Jus d'orange)
 * quantité (en cl)
 * Est ouvert ( Oui ou non)
 * Est vide ( Oui ou non)
 * 
 * Son comportement :
 * 
 * Ouvrir
 * Boire
 * Fermer
 * 
 * 
 * Dans le main, à l'aide d'une boucle créer un menu d'action où l'on peut ouvrir,Boire et fermer la bouteille. 
 * 
 * Bonus : Ajouter si vous oubliez de fermer la bouteille, il faudrait lancer aléatoirement une méthode Vider, qui vide le contenu de votre bouteille (Afficher un message "Oups! la bouteille s'est vidé accidentellement"),
 * c'est ce qui arrive souvent quand on oublie de fermer sa bouteille. Pour créer une fonction aléatoire utiliser la classe Random
 * 
 * Random random = new Random()
 * 
 * 
 * if (random.nextBoolean){
 * 
 *  ...........
 * 
 * }
 * 
 * 
 * 
 * Diagramme UML et code Java exigés
 * 
 * 
 * 
 */

