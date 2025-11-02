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

    /**
     * Replaces the current component's attributes with those of the specified component.
     */
    public void remplacer(Composant c) {
            this.nomComposant = c.nomComposant;
            this.dateFabrication = c.dateFabrication;
            this.dureeVie = c.dureeVie;
            this.prixComposant = c.prixComposant;
            this.etatComposant = c.etatComposant;
    }

    /**
     * Checks if the component is functional.
     */
    public boolean estFonctionnel() {
        return this.etatComposant == Etat.Fonctionnel;
    }

    /**
     * Returns the value of refComposant.
     */
    public int getRefComposant() {
        return refComposant;
    }

    /**
     * Returns the name of the component.
     */
    public String getNomComposant() {
        return nomComposant;
    }

    /**
     * Returns the date fabrication.
     */
    public Date getDateFabrication() {
        return dateFabrication;
    }

    public int getDureeVie() {
        return dureeVie;
    }

    /**
     * Returns the price of the component.
     */
    public double getPrixComposant() {
        return prixComposant;
    }

    /**
     * Returns the current state of the component.
     */
    public Etat getEtatComposant() {
        return etatComposant;
    }

    public void setEtatComposant(Etat etatComposant) {
        this.etatComposant = etatComposant;
    }
}
