import java.util.Scanner;

public class Calendrier {
    public static void main(String[] args) {
        int uneAnnee, nbJours;
        Scanner lecteur = new Scanner(System.in);

        System.out.println("Entrez une année entière: ");
        uneAnnee = lecteur.nextInt();
        lecteur.nextLine();

        if(uneAnnee % 100 == 0){
            System.out.println("Cette année marque la fin du " + uneAnnee/100 + "ème siècle");
        }else {
            System.out.println("Cette année n'est pas une fin de siècle");
        }

        if((uneAnnee % 100 != 0 && uneAnnee % 4 == 0) || (uneAnnee % 100 == 0 && (uneAnnee/100) % 4 == 0)){
            nbJours = 366;
            System.out.println("Elle est bissextile et comporte " + nbJours + " jours");
        }else{
            nbJours = 365;
            System.out.println("Elle n'est pas bissextile et comporte " + nbJours + " jours");
        }


    }
}
