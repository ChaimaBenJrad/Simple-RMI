import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Impl�mentation de l'interface de la calculatrice
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
    // M�thode pour effectuer une addition
    // Elle peut potentiellement lancer une RemoteException si une erreur se produit lors de l'appel distant
    public double addition(double a, double b) throws RemoteException {
        // Cette m�thode prend deux nombres en entr�e et retourne leur somme
        return a + b;
    }
 // M�thode pour effectuer une soustraction
    // Elle peut potentiellement lancer une RemoteException si une erreur se produit lors de l'appel distant
    public double soustraction(double a, double b) throws RemoteException {
        // Cette m�thode prend deux nombres en entr�e et retourne leur diff�rence
        return a - b;
    }

    public double multiplication(double a, double b) throws RemoteException {
        return a * b;
    }
 // M�thode pour effectuer une soustraction
    // Elle peut potentiellement lancer une RemoteException si une erreur se produit lors de l'appel distant
    public double division(double a, double b) throws RemoteException {
    	//voir si le d�nominateur est nul
        if (b == 0) {
        	// Lance une RemoteException avec un message indiquant une division par z�ro
            throw new RemoteException("Division par z�ro.");
        }
        // Cette m�thode prend deux nombres en entr�e et retourne leur quotion
        return a / b;
    }
}
