import javax.xml.stream.events.EntityReference;
import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        int a, b, c, d, e, sauv;

        System.out.println("Entrez un premier nombre entier: ");
        a = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Entrez un second nombre entier: ");
        b = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Entrez un troisième nombre entier: ");
        c = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Entrez un quatrième nombre entier: ");
        d = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Entrez un cinquième nombre entier: ");
        e = lecteur.nextInt();
        lecteur.nextLine();

        /*Permutation circulaire des valeurs de a, b, c, d et e
        * a prend la valeur de e
        * b prend la valeur de a
        * c prend la valeur de b
        * d prend la valeur de c
        * e prend la valeur de d
        * */

        sauv = a;
        a = e;
        e = d;
        d = c;
        c = b;
        b = sauv;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);




    }
}
