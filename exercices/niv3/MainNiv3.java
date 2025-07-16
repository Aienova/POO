package exercices.niv3;

public class MainNiv3 {



    /*
     * Me créer en POO une classe Voiture :
     * 
     * 
     * Voiture :
     * 
     * Attribut :
     * Marque
     * Modele
     * Puissance (cv, la puissance aura une influence sur l'embrayage, plus la puissance est élevée, plus l'embrayage est sensible)
     * vitesse
     * 
     * Comportement :
     * 
     * Accelerer
     * Decelerer
     * Freiner
     * Marche arrière
     * Arreter
     * Embrayer
     * Débrayer
     * Virer à gauche
     * Virer à droite
     * Changer de voie à gauche
     * Changer de voie à droite
     * Contrôle visibilité (Intérieur, extérieur, angles morts)
     * Clignotant à gauche
     * Clignotant à droite
     * Feu de croisement
     * Essuie-glace
     * Feu warning
     * Klaxonner
     * Marche arrière (On ira du principe que le conducteur manipule le volant pendant la marche arrière)
     * 
     * 
     * A l'aide d'un menu d'action, vous allez conduire une voiture, suivre des instructions d'un moniteur pour simuler un test de conduite.
     * Vous roulez sur Paris, vous devez suivre les instructions suivantes, vous devez respecter les limitations de vitesse et le code de la route:
     * 
     * Notification : Vous êtes sur une route limité à 30 km/h
     * 1. Démarrer la voiture
     * 2. Continuer tout droit
     * 3. Ralentir puis tourner à gauche (vous êtes prioritaire)
     * 4. Continuer tout droit (Il y a une voiture sur l'intersection à droite, vous n'êtes pas prioritaire)
     * 5. Attention, il y a un dos d'âne !
     * 6. Continuer tout droit
     * 7. Il y a un feu rouge, quand il passera au vert, tourner à droite sur l'avenue des Champs-Élysées
     * Notification : Vous êtes sur une route limité à 50 km/h
     * 8. Continuer tout droit
     * 9. Au rond point tourner à gauche
     * 10. Continuer tout droit 
     * 11. Attention, des piétons traversent
     * 12. Continuer tout droit
     * 13. Il y a un feu orange, ralentir, attendre que le feu soit rouge et tourner à gauche sur la voie d'insertion du Périphérique
     * Notification : Vous êtes sur le Périphérique, limité à 70 km/h
     * 14. Continuer tout droit
     * 15. Vous êtes sur la voie de droite, une voiture devant vous est trop lente, dépasser la voiture
     * 16. Attention, il y a un bouchon, veuillez ralentir , prévenir les autres conducteurs à l'arrière, puis s'arrêter
     * 17. Insérer vous dans la voie de droite, pour prendre la sortie A6
     * 18. Continuer tout droit, vous rendrez dans un tunnel
     * Notification : Vous êtes sur une route limité à 110 km/h.
     * 19. Continuer tout droit sur 10 km
     * 20. Vous êtes sur la voie de droite, un véhicule de police cherche à vous dépasser, laisser passer le véhicule en vous débordant sur la gauche
     * 21. Continuer tout droit
     * 22. Prenez la sortie en direction de Orly
     * Notification : Vous êtes sur une route limité à 50 km/h
     * 23. Continuer tout droit 
     * 24. Tournez à droite en direction de l'aéroport d'Orly 
     * Notification : Vous êtes sur une route limité à 30 km/h
     * 25. Continuer tout droit après le rond-point
     * 26. Virer à droite pour entrer dans le parking
     * 27. Garez la voiture en marche arrière
     * 28. Couper le moteur
     * Vous êtes arrivé(e) !!!
     * 
     * Si vous ne respectez pas le code de la route & les limitations de vitesse, le test de conduite a échoué et s'arrête, 
     * le moniteur prendra la main.
     * 
     * Bonus : Rajouter un système de points pour évaluer votre conduite, certaines erreurs ne sont pas éliminatoires mais vous feront perdre des points.
     * par exemple :
     * - Faire un excès de vitesse +5 km/h : -2 points
     * - Ne pas céder le passage : -3 points
     * - Brûler un feu orange : -5 points
     * - Ne pas laisser la priorité à droite : -3 points
     * - Ne pas mettre son clignotant : -2 point
     * - Ne pas contrôler les angles morts lors d'un changement de voie : -3 points
     * - Ne pas mettre de feu de croisement dans un tunnel : -2 points
     * - Ne pas activer les essuie-glaces en cas de pluie : -5 points
     * - Ne pas ralentir avant un dos d'âne : -2 points
     * 
     * Si vous arrivez à moins de 20 points, le test est terminé et vous avez échoué.
     * 
     * la pluie doit tomber aléatoirement pendant le test de conduite, si la pluie tombe, 
     * vous devez activer les essuie-glaces, et les limitations de vitesse sont réduites de 10 km/h.
     * 
     * Le test est sur 40 points, il faut au minimum 30 points pour réussir le test de conduite.
     * 
     */
    
    public static void main(String[] args) {

        // Ici, vous pouvez créer des instances de la classe Voiture et simuler le test de conduite
        // Par exemple :
        Voiture maVoiture = new Voiture("Toyota", "Corolla", 130);

        
        // Simuler les actions du test de conduite

        if(command.containt("D")) {
            maVoiture.demarrer();
        } else {
            System.out.println("Vous devez embrayer pour démarrer la voiture.");
            return;
        }
        maVoiture.demarrer();
        maVoiture.accelerer(30);
        maVoiture.virerAGauche();
        maVoiture.continuerToutDroit();
        maVoiture.ralentir();
        maVoiture.virerADroite();
        maVoiture.arreter();

        System.out.println("1. Démarrer la voiture");
        // Il faudra taper en scanner D pour démarrer la voiture

        System.out.println("2. Ralentir puis tourner à gauche (vous êtes prioritaire)");
        // Il faudra taper en scanner R pour ralentir et TG pour tourner à gauche
        
        // Continuez avec les autres étapes du test...


    }
      
}
