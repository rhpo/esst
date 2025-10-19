import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create a new repair
        Reparation rep = new Reparation(new Date(), 120, "Réparation moteur");

        // Add some pieces
        rep.ajouterPièce(1, "Bougie", 4, 15.50);
        rep.ajouterPièce(2, "Filtre à huile", 1, 25.00);
        rep.ajouterPièce(3, "Huile moteur", 5, 12.75);

        // Display initial list
        System.out.println("Liste initiale des pièces:");
        rep.afficherListePièces();

        // Test isDispo
        System.out.println("\nBougie disponible? " + rep.isDispo("Bougie"));
        System.out.println("Pneu disponible? " + rep.isDispo("Pneu"));

        // Modify a piece
        rep.modifierPièce(1, "Bougie NGK", 6, 18.50);

        // Display after modification
        System.out.println("\nListe après modification:");
        rep.afficherListePièces();

        // Calculate total cost
        System.out.println("\nMontant total: " + rep.calculerMontantRéparation() + " DINAR ALGERIEN");
        System.out.println("Réformable? " + rep.estRéformable());

        // Remove a piece
        rep.supprimerPièce(2);

        // Final display
        System.out.println("\nListe après suppression:");
        rep.afficherListePièces();
    }
}
