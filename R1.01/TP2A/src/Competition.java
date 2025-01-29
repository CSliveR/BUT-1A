import java.util.Scanner;

public class Competition {
    public static void main(String[] args) {
        float temps;
        int nbJuges;
        Scanner lecteur = new Scanner(System.in);
        final float TEMPS_MAX = 20.0f;

        System.out.println("Nombre de juges ? ");
        nbJuges = lecteur.nextInt();
        lecteur.nextLine();

        int i = 1;

        do{
            System.out.println("Temps estimé par le juge N°" + i + "(<= 20.0) ?");
            temps = lecteur.nextFloat();
            lecteur.nextLine();

            if(temps > TEMPS_MAX){
                System.out.println(">>> Saisie invalide, réessayez");
                i--;
            }

            i++;
        }while(i <= nbJuges);

    }
}
