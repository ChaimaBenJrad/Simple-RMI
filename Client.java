import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Récupérer l'objet RMI de la calculatrice depuis le registre RMI
            CalculatriceInterface calculatrice = (CalculatriceInterface) Naming.lookup("//localhost/Calculatrice");
         // Créer un objet Scanner pour permettre la saisie depuis la console
            Scanner scanner = new Scanner(System.in);
            //déclaration de la variable choix de type String
            String choix;
            //Début de la boucle do while
            do {
                // Demander à l'utilisateur de saisir le code de l'opération et les opérandes
                System.out.print("Entrez le code de l'opération (+, -, *, /) : ");
                //Lire l'opération de la console
                String operation = scanner.nextLine();
                //Demander le premier opérande
                System.out.print("Entrez le premier opérande : ");
                //Lire l'opérande de la console
                double a = scanner.nextDouble();
                //Demander le deuxième opérande
                System.out.print("Entrez le deuxième opérande : ");
                //Lire l'opérande de la console
                double b = scanner.nextDouble();
                //Déclarer la variable résulatt
                double resultat = 0;
                // Effectuer l'opération appropriée en invoquant la méthode correspondante de l'objet RMI
                switch (operation) {
                //si l'opération est l'addition
                    case "+":
                // Effectue l'opération d'addition en invoquant la méthode addition de l'objet RMI de la calculatrice,
                // avec les opérandes a et b, et stocke le résultat dans la variable resultat.

                        resultat = calculatrice.addition(a, b);
                     // Sortir de la structure de contrôle switch une fois que l'opération appropriée a été effectuée
                        break;
                //si l'opération est la soustraction
                    case "-":
                // Effectuer une soustraction en invoquant la méthode soustraction() de l'objet RMI calculatrice, avec les opérandes a et b, et stocker le résultat dans la variable 'resultat'
                        resultat = calculatrice.soustraction(a, b);
                     // Sortir de la structure de contrôle switch une fois que l'opération appropriée a été effectuée
                        break;
                //si l'opération est la multiplication
                    case "*":
                 // Effectue l'opération de multiplication en invoquant la méthode correspondante de l'objet RMI de la calculatrice
                        resultat = calculatrice.multiplication(a, b);
                     // Sortir de la structure de contrôle switch une fois que l'opération appropriée a été effectuée
                        break;
                //si l'opération est la division
                    case "/":
                // Effectuer une division en invoquant la méthode de division de l'objet RMI de la calculatrice,
                // en passant les opérandes a et b comme paramètres, et stocker le résultat dans la variable 'resultat'
                        resultat = calculatrice.division(a, b);
                     // Sortir de la structure de contrôle switch une fois que l'opération appropriée a été effectuée
                        break;
                     // Si le code de l'opération n'est pas valide, afficher un message d'erreur
                    default:
                    //Afficher que l'opération est non valide
                        System.out.println("Opération non valide.");
                     // Sortir de la structure de contrôle switch une fois que l'opération appropriée a été effectuée
                        break;
                }
                
                // Afficher le résultat
                System.out.println("Résultat : " + resultat);
                
                // Demander à l'utilisateur s'il veut arrêter l'exécution
                System.out.print("Voulez-vous continuer (oui/non) ? ");
                // Consommer la nouvelle ligne
                scanner.nextLine(); 
                //Lire de la console
                choix = scanner.nextLine();
             // Demander à l'utilisateur s'il veut continuer en vérifiant si la réponse est "oui" (ignorant la casse)
            } while (choix.equalsIgnoreCase("oui"));
            //Affichier que le programme est fini
            System.out.println("Fin du programme.");
         // Capture des exceptions générales lors de l'exécution des opérations RMI
        } catch (Exception e) {
        	// Affiche un message d'erreur indiquant qu'une exception s'est produite du côté du client, 
        	// en incluant le message d'erreur spécifique généré par l'exception e convertie en chaîne de caractères.
            System.err.println("Erreur du client : " + e.toString());
            // Afficher la trace de la pile pour identifier la cause de l'erreur
            e.printStackTrace();
        }
    }
}
