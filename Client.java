import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // R�cup�rer l'objet RMI de la calculatrice depuis le registre RMI
            CalculatriceInterface calculatrice = (CalculatriceInterface) Naming.lookup("//localhost/Calculatrice");
         // Cr�er un objet Scanner pour permettre la saisie depuis la console
            Scanner scanner = new Scanner(System.in);
            //d�claration de la variable choix de type String
            String choix;
            //D�but de la boucle do while
            do {
                // Demander � l'utilisateur de saisir le code de l'op�ration et les op�randes
                System.out.print("Entrez le code de l'op�ration (+, -, *, /) : ");
                //Lire l'op�ration de la console
                String operation = scanner.nextLine();
                //Demander le premier op�rande
                System.out.print("Entrez le premier op�rande : ");
                //Lire l'op�rande de la console
                double a = scanner.nextDouble();
                //Demander le deuxi�me op�rande
                System.out.print("Entrez le deuxi�me op�rande : ");
                //Lire l'op�rande de la console
                double b = scanner.nextDouble();
                //D�clarer la variable r�sulatt
                double resultat = 0;
                // Effectuer l'op�ration appropri�e en invoquant la m�thode correspondante de l'objet RMI
                switch (operation) {
                //si l'op�ration est l'addition
                    case "+":
                // Effectue l'op�ration d'addition en invoquant la m�thode addition de l'objet RMI de la calculatrice,
                // avec les op�randes a et b, et stocke le r�sultat dans la variable resultat.

                        resultat = calculatrice.addition(a, b);
                     // Sortir de la structure de contr�le switch une fois que l'op�ration appropri�e a �t� effectu�e
                        break;
                //si l'op�ration est la soustraction
                    case "-":
                // Effectuer une soustraction en invoquant la m�thode soustraction() de l'objet RMI calculatrice, avec les op�randes a et b, et stocker le r�sultat dans la variable 'resultat'
                        resultat = calculatrice.soustraction(a, b);
                     // Sortir de la structure de contr�le switch une fois que l'op�ration appropri�e a �t� effectu�e
                        break;
                //si l'op�ration est la multiplication
                    case "*":
                 // Effectue l'op�ration de multiplication en invoquant la m�thode correspondante de l'objet RMI de la calculatrice
                        resultat = calculatrice.multiplication(a, b);
                     // Sortir de la structure de contr�le switch une fois que l'op�ration appropri�e a �t� effectu�e
                        break;
                //si l'op�ration est la division
                    case "/":
                // Effectuer une division en invoquant la m�thode de division de l'objet RMI de la calculatrice,
                // en passant les op�randes a et b comme param�tres, et stocker le r�sultat dans la variable 'resultat'
                        resultat = calculatrice.division(a, b);
                     // Sortir de la structure de contr�le switch une fois que l'op�ration appropri�e a �t� effectu�e
                        break;
                     // Si le code de l'op�ration n'est pas valide, afficher un message d'erreur
                    default:
                    //Afficher que l'op�ration est non valide
                        System.out.println("Op�ration non valide.");
                     // Sortir de la structure de contr�le switch une fois que l'op�ration appropri�e a �t� effectu�e
                        break;
                }
                
                // Afficher le r�sultat
                System.out.println("R�sultat : " + resultat);
                
                // Demander � l'utilisateur s'il veut arr�ter l'ex�cution
                System.out.print("Voulez-vous continuer (oui/non) ? ");
                // Consommer la nouvelle ligne
                scanner.nextLine(); 
                //Lire de la console
                choix = scanner.nextLine();
             // Demander � l'utilisateur s'il veut continuer en v�rifiant si la r�ponse est "oui" (ignorant la casse)
            } while (choix.equalsIgnoreCase("oui"));
            //Affichier que le programme est fini
            System.out.println("Fin du programme.");
         // Capture des exceptions g�n�rales lors de l'ex�cution des op�rations RMI
        } catch (Exception e) {
        	// Affiche un message d'erreur indiquant qu'une exception s'est produite du c�t� du client, 
        	// en incluant le message d'erreur sp�cifique g�n�r� par l'exception e convertie en cha�ne de caract�res.
            System.err.println("Erreur du client : " + e.toString());
            // Afficher la trace de la pile pour identifier la cause de l'erreur
            e.printStackTrace();
        }
    }
}
