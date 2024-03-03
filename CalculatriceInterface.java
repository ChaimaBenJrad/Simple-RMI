import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface pour les op�rations de la calculatrice
public interface CalculatriceInterface extends Remote {
	//une m�thode non impl�ment�e qui d�claree une m�thode appel�e addition qui prend deux doubles en tant que param�tres et renvoie un double, et elle peut lancer une RemoteException
    double addition(double a, double b) throws RemoteException;
    //une m�thode non impl�ment�e qui effectue une soustraction entre a et b et retourne le r�sultat en double
    double soustraction(double a, double b) throws RemoteException;
    //une m�thode non impl�ment�e qui effectue une multiplication entre a et b et retourne le r�sultat en double
    double multiplication(double a, double b) throws RemoteException;
    //une m�thode non impl�ment�e qui effectue une division entre a et b et retourne le r�sultat en double
    double division(double a, double b) throws RemoteException;
}
