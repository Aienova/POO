package exercices.niv2;

public class Quizz {
    private String question;
    private String[] options;
    private int correctAnswerIndex;
    private boolean isCorrect;

    // Constructeur
    public Quizz(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.isCorrect = false;
    }

    // Méthode pour afficher la question et les options
    public void displayQuestion() {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Méthode pour vérifier la réponse de l'utilisateur
    public boolean answerQuestion(int answerIndex) {
        if (answerIndex == correctAnswerIndex) {
            isCorrect = true;
            System.out.println("Bonne réponse !");
        } else {
            isCorrect = false;
            System.out.println("Mauvaise réponse. La bonne réponse est : " + options[correctAnswerIndex]);
        }
        return isCorrect;
    }

    // Méthode pour incrémenter le score
    public int incrementScore() {
        return isCorrect ? 1 : 0;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}