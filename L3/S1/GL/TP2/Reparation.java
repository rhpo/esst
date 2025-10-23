import java.util.Date;
import java.util.Vector;

public class Reparation {
    public Date date;
    public int duration;
    public String travaux;
    public Vector<Piece> pièces;

    public Reparation(Date date, int duration, String travaux) {
        this.date = date;
        this.duration = duration;
        this.travaux = travaux;
        this.pièces = new Vector<>();
    }

    public double calculerMontantRéparation() {
        double total = 0;
        for (Piece piece : this.pièces) {
            total += piece.calculerMontant();
        }
        return total;
    }

    public void ajouterPièce(int ref, String nom, int quantite, double prix) {
        this.pièces.add(new Piece(ref, nom, quantite, prix));
    }

    public void ajouterPièce(Piece p) {
        if (p != null) {
            this.pièces.add(p);
        }
    }

    public void modifierPièce(int ref, String nom, int quantite, double prix) {
        for (int i = 0; i < this.pièces.size(); i++) {
            if (this.pièces.get(i).ref == ref) {
                this.pièces.set(i, new Piece(ref, nom, quantite, prix));
                return;
            }
        }
    }

    public void modifierPièce(Piece p) {
        if (p != null) {
            for (int i = 0; i < this.pièces.size(); i++) {
                if (this.pièces.get(i).ref == p.ref) {
                    this.pièces.set(i, p);
                    return;
                }
            }
        }
    }

    public void supprimerPièce(int ref) {
        this.pièces.removeIf(p -> p.ref == ref);
    }

    public boolean isDispo(String nom) {
        if (nom == null)
            return false;
        for (Piece p : this.pièces) {
            if (nom.equals(p.nom) && p.quantite > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean estRéformable() {
        return calculerMontantRéparation() > 1000;
    }

    public void afficherListePièces() {
        if (this.pièces.isEmpty()) {
            System.out.println("Aucune pièce.");
            return;
        }
        for (Piece p : this.pièces) {
            System.out.println(p);
        }
    }
}
