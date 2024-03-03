import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Serveur {
    public static void main(String[] args) {
        try {
            // Créer un registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);
            
            // Créer l'objet RMI de la calculatrice et l'associer à un nom dans le registre RMI
            CalculatriceImpl calculatrice = new CalculatriceImpl();
         // Associer l'objet RMI de la calculatrice à un nom ("Calculatrice") dans le registre RMI, permettant aux clients de rechercher et d'accéder à cet objet en utilisant ce nom
            Naming.rebind("Calculatrice", calculatrice);
            //Afficher que le serveur est pret
            System.out.println("Serveur prêt.");
         // Capturer toute exception générée lors de l'exécution des opérations RMI
        } catch (Exception e) {
        	// Affiche un message d'erreur spécifiant qu'une erreur s'est produite du côté du serveur, suivi du détail de l'exception convertie en chaîne de caractères, afin de faciliter le débogage.
            System.err.println("Erreur du serveur : " + e.toString());
         // Afficher la trace de la pile pour identifier la cause de l'erreur
            e.printStackTrace();
        }
    }
}
