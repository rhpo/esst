import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Equipement ordinateur = new Equipement(1, "PC Dell", 1200.0, Type.Micro);

        Composant cpu = new Composant(1, "Processeur Intel i7", new Date(),1825, 300.0, Etat.Fonctionnel);
        Composant ram = new Composant(2, "RAM 16GB", new Date(),1825, 100.0, Etat.Fonctionnel);
        Composant hdd = new Composant(3, "Disque Dur 1TB", new Date(),1095, 80.0, Etat.Fonctionnel);

        ordinateur.ajouterComposant(cpu);
        ordinateur.ajouterComposant(ram);
        ordinateur.ajouterComposant(hdd);

        ordinateur.afficherListeComposants();

        System.out.println("\nÉtat du CPU : " +
            (cpu.estFonctionnel() ? "Fonctionnel" : "Défaillant"));

        cpu.setEtatComposant(Etat.Defaillant);
        System.out.println("Après panne, état du CPU : " +
            (cpu.estFonctionnel() ? "Fonctionnel" : "Défaillant"));

        Composant nouveauCpu = new Composant(4, "Processeur Intel i7", new Date(),
            1825, 300.0, Etat.Fonctionnel);
        cpu.remplacer(nouveauCpu);

        System.out.println("Après remplacement, état du CPU : " +
            (cpu.estFonctionnel() ? "Fonctionnel" : "Défaillant"));
    }
}
