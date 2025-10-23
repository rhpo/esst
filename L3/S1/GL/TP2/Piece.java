public class Piece {
    public int ref;
    public String nom;
    public int quantite;
    public double prix;

    public Piece(int ref, String nom, int quantite, double prix) {
        this.ref = ref;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    public double calculerMontant() {
        return this.prix * this.quantite;
    }

    @Override
    public String toString() {
        return "Piece [ref=" + ref + ", nom=" + nom + ", quantite=" + quantite + ", prix=" + prix + "]";
    }
}
