package exercices.niv2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class MainNiv2 {
    
       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] questions = {
            {"Quelle est la capitale de la France ?", "Paris", "Londres", "Berlin", "1"},
            {"Quel est le plus grand océan du monde ?", "Atlantique", "Indien", "Pacifique", "3"},
            {"Quel est le symbole chimique de l'eau ?", "H2O", "CO2", "O2", "1"},
            {"Qui a écrit 'Les Misérables' ?", "Victor Hugo", "Émile Zola", "Gustave Flaubert", "1"},
            {"Quelle est la langue officielle du Brésil ?", "Espagnol", "Portugais", "Français", "2"},
            {"Quel est le plus grand désert du monde ?", "Sahara", "Gobi", "Kalahari", "1"},
            {"Qui a peint la Joconde ?", "Vincent van Gogh", "Claude Monet", "Léonard de Vinci", "3"},

        };

        ArrayList<Quizz> quizzList = new ArrayList<>();

        for (String[] questionData : questions) {
            String question = questionData[0];
            String[] answers = {questionData[1], questionData[2], questionData[3]};
            int correctAnswer = Integer.parseInt(questionData[4]) - 1;
            quizzList.add(new Quizz(question, answers, correctAnswer));
        }

        int totalScore = 0;
         int timeQuizz = quizzList.size() * 5; // 5 secondes par question

        System.out.println("\nBienvenue dans le Quizz.");
        System.out.println("Vous avez " + timeQuizz + " secondes pour répondre à toutes les questions.");
        System.out.println("--------------------------------------------------");


        // Début du chronomètre
        LocalDateTime startTime = LocalDateTime.now();
        Duration timeLimit = Duration.ofSeconds(timeQuizz);

        for (int i = 0; i < quizzList.size(); i++) {

            Duration elapsed = Duration.between(startTime, LocalDateTime.now());

            if (elapsed.compareTo(timeLimit) > 0) {
                System.out.println("\nTemps écoulé ! Le quizz est terminé.");
                break;
            }

            Quizz question = quizzList.get(i);
            question.displayQuestion();
            System.out.print("\nVotre réponse : ");
            
            try {
                int userAnswer = scanner.nextInt() - 1; // Convertir en index (0-based)
                if (userAnswer < 0 || userAnswer >= 3) {
                    System.out.println("Réponse invalide. Veuillez entrer un nombre entre 1 et 3.");
                    i--; // Refaire la question
                    continue;
                }
                question.answerQuestion(userAnswer);

                /* Si on répond correctement, on ajoute 5 secondes de plus */
                if(question.isCorrect()) {
                    System.out.println("Vous avez gagné +5 secondes de plus pour répondre aux questions restantes.");
                    timeLimit = timeLimit.plusSeconds(5); // Ajouter 5 secondes bonus
                } 
                totalScore += question.incrementScore();
                if(i==6) {
                    System.out.println("Vous avez répondu à toutes les questions !");
                    System.out.println("Temps total :  " + elapsed.toSeconds() + " secondes.");
                }else {
                    System.out.println("Vous avez répondu à la question " + (i + 1) + " sur " + quizzList.size() + ".");
                          System.out.println("Il vous reste " + (timeLimit.toMillis() - elapsed.toMillis()) / 1000 + " secondes pour répondre aux questions restantes.");
                }
          
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next(); // Nettoyer l'entrée incorrecte
                i--; // Refaire la question
            }
        }

        System.out.println("\nVotre score final est : " + totalScore + " sur " + quizzList.size());
        scanner.close();
    }

}


/*  Exercice n°2 : 
 * 
 * Me créer en POO une classe Quizz avec les attributs suivants :
 * 
 * Question
 * Reponses (3 réponses dans un tableau)
 * Bonne réponse
 * Terminée (Vrai ou Faux)
 * 
 * Son comportement :
 * 
 * Afficher La Question et les réponses ( Utiliser les index pour afficher la question et les réponses correspondantes)
 * Répondre
 * Verdict (Bonne réponse = 1 point ou mauvaise réponse = 0 point , puis terminé = true)
 * Afficher la Bonne Réponse (Après avoir répondu si on a eu faux)
 * 
 * 
 * Diagramme UML et code Java exigés
 * 
 * 
 * Dans le main le but sera de créer des objets Quizz dynamiquement en fonction du nombres de questions créer dans un tableau ou une list avec leurs 3 réponses.
 * Vous aurez besoin d'une boucle 
 * 
 * 
 * Bonus : Créer la possibilité de mettre un minuteur qui arrête le quizz après la minute de votre choix, il faudra utiliser les localDatetime 
 * Par exemple vous avez défini 10 min de temps limite, si vous commencez le quiz à 10h10 alors à 10h20 le quiz est terminée
 * 
 * 
 */