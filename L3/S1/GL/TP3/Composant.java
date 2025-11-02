import java.util.Date;

public class Composant {
    private final int refComposant;
    private String nomComposant;
    private Date dateFabrication;
    private int dureeVie;
    private double prixComposant;
    private Etat etatComposant;

    public Composant(int refComposant, String nomComposant, Date dateFabrication,
                    int dureeVie, double prixComposant, Etat etatComposant) {

                        this.refComposant = refComposant;
        this.nomComposant = nomComposant;
        this.dateFabrication = dateFabrication;
        this.dureeVie = dureeVie;
        this.prixComposant = prixComposant;
        this.etatComposant = etatComposant;
    }

    public void remplacer(Composant c) {
            this.nomComposant = c.nomComposant;
            this.dateFabrication = c.dateFabrication;
            this.dureeVie = c.dureeVie;
            this.prixComposant = c.prixComposant;
            this.etatComposant = c.etatComposant;
    }

    public boolean estFonctionnel() {
        return this.etatComposant == Etat.Fonctionnel;
    }

    public int getRefComposant() {
        return refComposant;
    }

    public String getNomComposant() {
        return nomComposant;
    }

    public Date getDateFabrication() {
        return dateFabrication;
    }

    public int getDureeVie() {
        return dureeVie;
    }

    public double getPrixComposant() {
        return prixComposant;
    }

    public Etat getEtatComposant() {
        return etatComposant;
    }

    public void setEtatComposant(Etat etatComposant) {
        this.etatComposant = etatComposant;
    }
}
