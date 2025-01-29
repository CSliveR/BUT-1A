import java.util.Scanner;

public class Nim {
    private static int saisieEntSupEgalMin(int min) {
    // { min > 0 } => { résultat = un entier positif supérieur ou égal à min saisi par l'utilisateur }
        Scanner lecteur = new Scanner(System.in);
        int unEnt;

        do{
            unEnt = lecteur.nextInt();
            lecteur.nextLine();

            if(unEnt < min){
                System.out.println("Saisie invalide ! Veuillez entrer une valeur valide.");
            }
        }while(unEnt < min);

        return unEnt;
    }

    private static int unePrise(int reste, int max) {
        // { reste > 0, max > 0 }
        // => { résultat = entier > 0 et inférieur ou égal la plus petite valeur parmi reste et max}

        Scanner lecteur = new Scanner(System.in);
        int unEnt;
        int plusPetit = Math.min(reste, max);

        do{
            unEnt = lecteur.nextInt();
            lecteur.nextLine();

            if(unEnt > plusPetit){
                System.out.println("*** Saisie invalide recommencez...");
                System.out.println("Entrez un entier (min 1, max 3)");
            }
        }while(unEnt > plusPetit);

        return unEnt;
    }

    public static void main(String[] args) {
        final int MIN_JOUEURS = 2;
        int nbJoueurs, nbAllumettes;

        System.out.println("--------------------------------------------");
        System.out.println("Nombre de joueurs ?");
        System.out.println("Entrez un entier plus grand ou égal à " + MIN_JOUEURS + " :");
        nbJoueurs = saisieEntSupEgalMin(MIN_JOUEURS);
        System.out.println("--------------------------------------------");
        System.out.println("Nombre d'allumettes ?");
        System.out.println("Entrez un entier plus grand ou égal à " + 3*nbJoueurs + " :");
        nbAllumettes = saisieEntSupEgalMin(3*nbJoueurs);

        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("*********************************************");
        System.out.println("* Nombre de joueurs: " + nbJoueurs);
        System.out.println("* Nombre d'allumettes: " + nbAllumettes);
        System.out.println("*********************************************");

        final int MAXPRISE = 3;
        int numJoueur, nbCoups, prise, reste;
        numJoueur = 1;
        nbCoups = 0;

        while(nbAllumettes > 0){
            System.out.println("Joueur n°" + numJoueur + ", combien prenez-vous d'allumettes ?");
            System.out.println("Entrez un entier (min 1, max " + MAXPRISE + ")");
            prise = unePrise(nbAllumettes,MAXPRISE);
            nbAllumettes = nbAllumettes - prise;
            System.out.println("-> Il reste " + nbAllumettes + " allumettes");
            if(nbAllumettes != 0){
                numJoueur ++;
            }
            if(numJoueur > nbJoueurs){
                numJoueur = 1;
            }
            nbCoups ++;
        }

        System.out.println();
        System.out.println("********************************************");
        System.out.println("Victoire du joueur n°" + numJoueur + " après " + nbCoups + " coups !");
        System.out.println("********************************************");

    }
}
