import java.util.Scanner;

public class MoyenneNotes {
    public static void main(String[] args){
        int nbNotes;
        float moyenne = 0.0f;
        float note = 0.0f;
        Scanner lecteur = new Scanner(System.in);

        System.out.println("Entrez le nombre de notes que vous avez: ");
        nbNotes = lecteur.nextInt();
        lecteur.nextLine();

        int i = 0;
        while (i < nbNotes){
            do{
                System.out.println("Entrez une note: ");
                note = lecteur.nextFloat();
                lecteur.nextLine();

                if(note < 0.0f | note > 20.0f){
                    System.out.println("Une note doit être comprise entre 0 et 20");
                }

            } while (note < 0.0f | note > 20.0f);


            moyenne+=note;
            i++;
        }

        System.out.println("La moyenne de vos notes est: " + moyenne/nbNotes);
    }
}
