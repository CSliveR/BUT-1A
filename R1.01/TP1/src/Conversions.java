import java.util.Scanner;

public class Conversions {
    public static void main(String[] args) {
        float dollars, euros;
        final float taux = 0.89f;
        Scanner lecteur = new Scanner(System.in);

        System.out.println("Entrez un montant en dollar(s) : ");
        dollars = lecteur.nextFloat();
        lecteur.nextLine();

        euros = dollars*taux; /*Conversion dollars -> euros*/

        System.out.println(dollars + " dollar(s) = " + euros + " euro(s)");

        System.out.println("Entrez un montant en euro(s) : ");
        euros = lecteur.nextFloat();
        lecteur.nextLine();

        dollars = euros/taux; /*Conversion euros -> dollars*/

        System.out.println(euros + " euro(s) = " + dollars + " dollar(s)");

    }
}
