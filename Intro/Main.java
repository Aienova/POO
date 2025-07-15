package Intro;

public class Main {
    public static void main(String[] args) {


        // Exemple d'instanciation de la classe JeuVideo
        // Vous pouvez créer un objet JeuVideo avec les attributs définis dans le constructeur
        JeuVideo FC25 = new JeuVideo(
            "FC25",
            69.0,
            "PC",
            4,
            80,
            "Sport",
            true,
            "U17"
        );

        FC25.jouer();
        FC25.sauvegarder();
        FC25.mettreAJour();
    }
}
