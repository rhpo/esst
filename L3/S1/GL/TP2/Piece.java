public class Piece {
    public int ref;
    public String nom;
    public int quantité;
    public int quantitéStock;
    public double prix;

    public void entrerStock(int quantité) {
        this.quantitéStock += quantité;
    }

    public double calculerMontant() {
        return this.quantité * this.prix;
    }
}
