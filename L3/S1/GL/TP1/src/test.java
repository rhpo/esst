
import java.util.Date;

public class test {

    public static void main(String[] args) {

        chef_atelier c1 = new chef_atelier(5, new Date(120, 5, 10), new Date(122, 2, 1), status.actif,
                201, specialite.informatique, "Rahim", "Arab",
                "Rahim@arab.com", "Rahim_uni", "rahim123");

        c1.afficher();

        System.out.println("\n Authentification : " + c1.sauthentifier2("Rahim_uni", "rahim123"));

    }
}
