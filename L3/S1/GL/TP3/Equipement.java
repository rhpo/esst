import java.util.ArrayList;
import java.util.Iterator;

public class Equipement {
    private final int numSerie;
    private final String designation;
    private final double prix;
    private final Type typeEquip;
    private final ArrayList<Composant> listeComposants;

    public Equipement(int numSerie, String designation, double prix, Type typeEquip) {
        this.numSerie = numSerie;
        this.designation = designation;
        this.prix = prix;
        this.typeEquip = typeEquip;
        this.listeComposants = new ArrayList<>();
    }

    /**
     * Adds a component to the list if it is not null and not already present.
     */
    public void ajouterComposant(Composant c) {
        if (c != null && !listeComposants.contains(c)) {
            listeComposants.add(c);
        }
    }

    /**
     * Removes the specified composant from the list of composants.
     */
    public void supprimerComposant(Composant c) {
        listeComposants.remove(c);
    }

    public void afficherListeComposants() {

        Iterator<Composant> iter=listeComposants.iterator();


        while   (iter.hasNext()) {
        System.out.println("Liste des composants pour l'équipement " + designation + " :");

            var c = iter.next();
            System.out.println("- " + c.getNomComposant());

        }
    }

    public int getNumSerie() {
        return numSerie;
    }

    /**
     * Returns the designation.
     */
    public String getDesignation() {
        return designation;
    }

    public double getPrix() {
        return prix;
    }

    /**
     * Returns the type of equipment.
     */
    public Type getTypeEquip() {
        return typeEquip;
    }
}
