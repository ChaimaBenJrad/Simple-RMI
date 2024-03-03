import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implémentation de l'interface de la calculatrice
public class CalculatriceImpl extends UnicastRemoteObject implements CalculatriceInterface {
    /**
     * Constructeur de la classe CalculatriceImpl.
     * Il initialise la classe parente UnicastRemoteObject pour la communication RMI.
     *
     * @throws RemoteException si une erreur de communication RMI survient.
     */
    protected CalculatriceImpl() throws RemoteException {
    	// Appel du constructeur de la classe parente (UnicastRemoteObject) pour initialiser l'objet RMI.
        super();
    }
    // Méthode pour effectuer une addition
    // Elle peut potentiellement lancer une RemoteException si une erreur se produit lors de l'appel distant
    public double addition(double a, double b) throws RemoteException {
        // Cette méthode prend deux nombres en entrée et retourne leur somme
        return a + b;
    }
 // Méthode pour effectuer une soustraction
    // Elle peut potentiellement lancer une RemoteException si une erreur se produit lors de l'appel distant
    public double soustraction(double a, double b) throws RemoteException {
        // Cette méthode prend deux nombres en entrée et retourne leur différence
        return a - b;
    }

    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }
 // Méthode pour effectuer une soustraction
    // Elle peut potentiellement lancer une RemoteException si une erreur se produit lors de l'appel distant
    public double division(double a, double b) throws RemoteException {
    	//voir si le dénominateur est nul
        if (b == 0) {
        	// Lance une RemoteException avec un message indiquant une division par zéro
            throw new RemoteException("Division par zéro.");
        }
        // Cette méthode prend deux nombres en entrée et retourne leur quotion
        return a / b;
    }
}
