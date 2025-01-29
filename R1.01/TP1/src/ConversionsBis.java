import java.util.Scanner;

public class ConversionsBis {
    public static void main(String[] args) {

        final float EURO_TO_USD = 1.07f;
        final float EURO_TO_CHF = 0.96f;
        final float EURO_TO_GBP = 0.86f;

        Scanner lecteur = new Scanner(System.in);

        System.out.println("Entrez un montant en euro: ");
        float montant = lecteur.nextFloat();
        lecteur.nextLine();

        System.out.print("Choisir la devise dans laquelle vous voulez convertir ce montant: ");
        System.out.println("dollar, franc ou livre");

        String devise = lecteur.nextLine();

        if(devise.compareToIgnoreCase("dollar") == 0){
            montant = montant*EURO_TO_USD;
        }else if(devise.compareToIgnoreCase("franc") == 0){
            montant = montant*EURO_TO_CHF;
        }else{
            montant = montant*EURO_TO_GBP;
        }

        System.out.println("le montant converti est de " + montant + ' ' + devise);

    }
}
