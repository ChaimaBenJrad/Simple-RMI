import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface pour les opérations de la calculatrice
public interface CalculatriceInterface extends Remote {
	//une méthode non implémentée qui déclaree une méthode appelée addition qui prend deux doubles en tant que paramètres et renvoie un double, et elle peut lancer une RemoteException
    double addition(double a, double b) throws RemoteException;
    //une méthode non implémentée qui effectue une soustraction entre a et b et retourne le résultat en double
    double soustraction(double a, double b) throws RemoteException;
    //une méthode non implémentée qui effectue une multiplication entre a et b et retourne le résultat en double
    double multiplication(double a, double b) throws RemoteException;
    //une méthode non implémentée qui effectue une division entre a et b et retourne le résultat en double
    double division(double a, double b) throws RemoteException;
}
