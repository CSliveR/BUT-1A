import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompareRech {
    public static void main(String[] args) {
        ArrayList<Integer> vInt = new ArrayList<>(Arrays.asList(-45, -45, -10, 9, 10, 20, 30, 75, 90));
        System.out.println("Vecteur d'entier de taille " + vInt.size() + " : " + vInt);

        Scanner lecteur = new Scanner(System.in);
        int unEnt;
        System.out.println("Entrez un nombre entier: ");
        unEnt = lecteur.nextInt();
        lecteur.nextLine();

        PaireResCompteur<Integer> rechSeqIt_O = Utilitaire.rechSeqIt_O(vInt,unEnt);
        PaireResCompteur<Integer> rechDichoIt_O = Utilitaire.rechDichoIt_O(vInt,unEnt);

        System.out.println("RECHERCHE SEQUENTIELLE ITERATIVE: ");
        if (rechSeqIt_O.getRes() == -1){
            System.out.println(unEnt + " n'a pas été trouvé");
            System.out.println("Nombre de comparaisons: " + rechSeqIt_O.getCompteur());
        }else{
            System.out.println(unEnt + " a été trouvé à l'indice " + rechSeqIt_O.getRes());
            System.out.println("Nombre de comparaisons: " + rechSeqIt_O.getCompteur());
        }


        System.out.println("RECHERCHE DICHOTOMIQUE ITERATIVE: ");
        if (rechDichoIt_O.getRes() == -1){
            System.out.println(unEnt + " n'a pas été trouvé");
            System.out.println("Nombre de comparaisons: " + rechDichoIt_O.getCompteur());
        }else{
            System.out.println(unEnt + " a été trouvé à l'indice " + rechDichoIt_O.getRes());
            System.out.println("Nombre de comparaisons: " + rechDichoIt_O.getCompteur());
        }

        ArrayList<Integer> v160 = Utilitaire.genVectSansDoublons(160);
        Utilitaire.triBulle_O(v160);
        System.out.println("Vecteur trié de " + v160.size() + " éléments");
        System.out.println(v160);

        char carac = 'y';
        int val;

        while(carac == 'y'){
            do{
                System.out.println("Entrez un entier <= " + v160.get(v160.size()-1));
                val = lecteur.nextInt();
                lecteur.nextLine();

            }while(val > v160.get(v160.size()-1));

            System.out.println("RECHERCHE DICHOTOMIQUE ITERATIVE DE LA VALEUR " + val + " SUR UN VECTEUR DE " + v160.size() + " ELEMENTS");
            if (Utilitaire.rechDichoIt_O(v160,val).getRes() == -1){
                System.out.println(val + " n'a pas été trouvé");
                System.out.println("Nombre de comparaisons: " + Utilitaire.rechDichoIt_O(v160,val).getCompteur());
            }else{
                System.out.println(val + " a été trouvé à l'indice " + Utilitaire.rechDichoIt_O(v160,val).getRes());
                System.out.println("Nombre de comparaisons: " + Utilitaire.rechDichoIt_O(v160,val).getCompteur());
            }

            System.out.println("RECHERCHE DICHOTOMIQUE RECURSIVE DE LA VALEUR " + val + " SUR UN VECTEUR DE " + v160.size() + " ELEMENTS");
            if (Utilitaire.rechDichoRec_O(v160,val).getRes() == -1){
                System.out.println(val + " n'a pas été trouvé");
                System.out.println("Nombre de comparaisons: " + Utilitaire.rechDichoRec_O(v160,val).getCompteur());
            }else{
                System.out.println(val + " a été trouvé à l'indice " + Utilitaire.rechDichoRec_O(v160,val).getRes());
                System.out.println("Nombre de comparaisons: " + Utilitaire.rechDichoRec_O(v160,val).getCompteur());
            }

            System.out.println("Voulez-vous continuer(y pour continuer/n pour arreter)");
            carac = lecteur.next().charAt(0);
            lecteur.nextLine();
        }
    }
}
