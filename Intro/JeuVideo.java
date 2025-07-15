package Intro;


public class JeuVideo {

    // Attributs
    // Les attributs sont en private pour encapsuler les données de l'objet
    private String nom;
    private double prix;
    private String plateforme;
    private int pegi;
    private int taille;
    private String genre;
    private boolean isInstalle;
    private String version;

    // Constructeur, permet de créer un objet JeuVideo avec les attributs définis
    // Le constructeur initialise les attributs de l'objet
    public JeuVideo(String nom, double prix, String plateforme, int pegi, int taille, String genre, boolean installe, String version) {
        this.nom = nom;
        this.prix = prix;
        this.plateforme = plateforme;
        this.pegi = pegi;
        this.taille = taille;
        this.genre = genre;
        this.isInstalle = installe;
        this.version = version;
    }

    // Comportement de la classe JeuVideo
    // Ces méthodes définissent les actions que l'objet JeuVideo peut effectuer
    public void jouer() {
        System.out.println(infoDuJeu());
        System.out.println(nom + " est en cours d'exécution...");
                System.out.println(" EA SPORT It's in the game...");
    }

    public void sauvegarder() {
        System.out.println("Sauvegarde du jeu " + nom+"Veuillez ne pas éteindre votre PC");
    }

    public void installer() {
        if (!isInstalle) {
            isInstalle = true;
            System.out.println(infoDuJeu());
            System.out.println(nom + " est en cours d'exécution...");
            System.out.println(nom + " est maintenant installé.");
        } else {
            System.out.println(nom + " est déjà installé.");
        }
    }


    private String infoDuJeu(){

        String info="";

        info+="Nom du Jeu video :"+this.nom+"\n";
        info+="Prix du jeu :"+this.prix+" euros \n";
        info+="pegi : +"+this.pegi+"\n";
        info+="plateforme : "+this.plateforme+"\n";
        info+="taille : "+this.taille+"go \n";
        info+="genre : "+this.genre+" \n";
        info+="installe : "+(this.isInstalle ? "Oui" : "Non")+" \n";
        info+="version : "+this.version+" \n";

        return info;


    }

    public void mettreAJour() {
                System.out.println(infoDuJeu());
        System.out.println(nom + " est mis à jour vers la version " + version);
    }

    // Optionnel : Getters/Setters si tu veux y accéder ailleurs


    //"Get" pour types non-boolean

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    // "is" pour types boolean
    public boolean isInstalle() {
        return isInstalle;
    }
}
