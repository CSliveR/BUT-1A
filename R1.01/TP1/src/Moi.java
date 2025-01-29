
import java.util.Locale;
import java.util.Scanner;
public class Moi {
    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        String nom, prenom, sousGroupe;
        char groupe;
        int age;

        System.out.println("Entrez votre nom: ");
        nom = lecteur.nextLine();

        System.out.println("Entrez votre prénom: ");
        prenom = lecteur.nextLine();

        System.out.println("Entrez votre âge: ");
        age = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Entrez le grouoe dans lequel vous êtes: ");
        groupe = lecteur.next().charAt(0);
        lecteur.nextLine();

        System.out.println("Entrez votre sous-groupe: ");
        sousGroupe = lecteur.nextLine();

        System.out.println("---------------------------------");
        System.out.println("RENSEIGNEMENTS VOUS CONCERNANT");
        System.out.println("---------------------------------");
        System.out.println("Identité " + prenom + ' ' + nom.toUpperCase(Locale.ROOT));
        System.out.println("Âge: " + age + ' ' + "ans");
        System.out.println("Groupe: " + groupe);
        System.out.println("Sous-groupe: " + sousGroupe.toUpperCase(Locale.ROOT));
        System.out.println("---------------------------------");
    }

}
