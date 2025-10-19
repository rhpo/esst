import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static int Produit(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        try {
            System.out.println("Creation de server au port 2002");
            ServerSocket s = new ServerSocket(2002);
            Socket t9chira = new Socket("192.168.119.72", 2003);

            while (true) {
                System.out.println("Waiting");
                Socket connection = s.accept();
                System.out.println("Accepted ......");
                ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
                String chA = (String) in.readObject();
                System.out.println("ChA=" + chA);

                ObjectOutputStream out = new ObjectOutputStream(t9chira.getOutputStream());
                out.writeObject(chA);
            }

        } catch (Exception e) {
            System.out.println("Exception P2" + e.toString());
        }
    }
}
