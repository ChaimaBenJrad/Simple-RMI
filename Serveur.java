import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            // Cr�er un registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);
            
            // Cr�er l'objet RMI de la calculatrice et l'associer � un nom dans le registre RMI
            CalculatriceImpl calculatrice = new CalculatriceImpl();
         // Associer l'objet RMI de la calculatrice � un nom ("Calculatrice") dans le registre RMI, permettant aux clients de rechercher et d'acc�der � cet objet en utilisant ce nom
            Naming.rebind("Calculatrice", calculatrice);
            //Afficher que le serveur est pret
            System.out.println("Serveur pr�t.");
         // Capturer toute exception g�n�r�e lors de l'ex�cution des op�rations RMI
        } catch (Exception e) {
        	// Affiche un message d'erreur sp�cifiant qu'une erreur s'est produite du c�t� du serveur, suivi du d�tail de l'exception convertie en cha�ne de caract�res, afin de faciliter le d�bogage.
            System.err.println("Erreur du serveur : " + e.toString());
         // Afficher la trace de la pile pour identifier la cause de l'erreur
            e.printStackTrace();
        }
    }
}
