import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Reparation rep = new Reparation(new Date(), 120, "Réparation moteur");

        rep.ajouterPièce(1, "Bougie", 4, 15.50);
        rep.ajouterPièce(2, "Filtre à huile", 1, 25.00);
        rep.ajouterPièce(3, "Huile moteur", 5, 12.75);

        System.out.println("Liste initiale des pièces:");
        rep.afficherListePièces();

        System.out.println("\nBougie disponible? " + rep.isDispo("Bougie"));
        System.out.println("Pneu disponible? " + rep.isDispo("Pneu"));

        rep.modifierPièce(1, "Bougie NGK", 6, 18.50);

        System.out.println("\nListe après modification:");
        rep.afficherListePièces();

        System.out.println("\nMontant total: " + rep.calculerMontantRéparation() + " DINAR ALGERIEN");
        System.out.println("Réformable? " + rep.estRéformable());

        rep.supprimerPièce(2);

        System.out.println("\nListe après suppression:");
        rep.afficherListePièces();
    }
}
