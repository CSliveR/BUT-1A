import javax.swing.text.Position;
import java.util.Scanner;

public class Localisation {
    public static void main(String[] args) {
        int x, y;
        Scanner lecteur = new Scanner(System.in);
        char jeu  = 'o';

        do {
            System.out.println("Nous allons déterminer votre position géographique par rapport à un point de référence ...");
            System.out.println("Abscisse de votre position ? ");

            x = lecteur.nextInt();
            lecteur.nextLine();

            System.out.println("Ordonnée de votre position ? ");
            y = lecteur.nextInt();
            lecteur.nextLine();

            if (x > 0 && y > 0) {
                System.out.println("Position: Nord-Est");
            } else if (x > 0 && y < 0) {
                System.out.println("Position: Sud-Est");
            } else if (x < 0 && y > 0) {
                System.out.println("Position: Nord-Ouest");
            } else if (x < 0 && y < 0) {
                System.out.println("Position: Sud-Ouest");
            } else if (x > 0) {
                System.out.println("Position: Est");
            } else if (x < 0) {
                System.out.println("Position: Ouest");
            } else if (y > 0) {
                System.out.println("Position: Nord");
            } else if (y < 0) {
                System.out.println("Position: Sud");
            } else {
                System.out.println("Position: Centre");
            }

            System.out.println("RECOMMENCER ? (Tapez o pour rejouer, n pour arrêter)");
            jeu = lecteur.next().charAt(0);

        } while (jeu == 'o');
    }
}
