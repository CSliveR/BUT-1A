import java.sql.SQLOutput;
import java.util.Scanner;

public class TestListInt {
    public static void main(String[] args) throws ExceptionMauvaisIndice {
        ListeChainee<Integer> listInt = new ListeChainee<>();

        for(int i=1; i <= 15; i++){
            listInt.insereAtPosit(i,(int)(Math.random()*50));
        }

        System.out.println("------------------------------------------------------------------");
        System.out.println("LISTE CHAÎNÉE D'ENTIERS");
        System.out.println("------------------------------------------------------------------");

        System.out.println("*Nombre de cellule de la liste : " + listInt.getLongueur());
        System.out.println("*Informations portées par les cellules de la liste, de la première à la dernière :");
        listInt.afficheGaucheDroiteRec();

        System.out.println("* Somme des entiers portés par les cellules de la liste");
        System.out.println("1- FORME ITERATIVE : " + Utilitaire.sumIter(listInt));
        System.out.println("2- FORME RECURSIVE : " + Utilitaire.sumRec(listInt));

        System.out.println();

        Scanner lecteur = new Scanner(System.in);
        System.out.println("* Recherche d'un entier dans la liste...");
        System.out.println("----------------------------");

        int unInt;
        unInt = Utilitaire.getInt_IME(lecteur);

        if (Utilitaire.existIntRec(listInt,unInt)){
            System.out.println(unInt + " a été trouvé dans la liste");
        }else{
            System.out.println(unInt + " n'est pas dans la liste");
        }
        System.out.println("----------------------------");
        int posPremSup = Utilitaire.posFirstSup(listInt,unInt);
        System.out.println("* Rang de la 1ère cellule portant un entier supérieur à " + unInt + " dans la liste : " + posPremSup );
        if (posPremSup != 0){
            System.out.println("Vérification avec getInfoAtPosit(): Valeur de la cellule de rang " + posPremSup + " dans la liste : " + listInt.getInfoAtPosit(posPremSup));
        }else{
            System.out.println("Aucune valeur est supérieure à " + unInt + " dans la liste");
        }

        System.out.println("* Plus grand entier parmi les entiers portés par les cellules de la liste : " + Utilitaire.bigger(listInt));

        System.out.println("------------------------------------------------------------------");
        System.out.println("SOUS-LISTE DE LA LISTE D'ENTIERS");
        System.out.println("------------------------------------------------------------------");
        System.out.println("* Saisie de la position d'une cellule de la liste : ");
        System.out.println("----------------------------");
        int ind = Utilitaire.getIntMinMax_IME(lecteur,1,listInt.getLongueur());
        System.out.println("Sous-liste à partir du rang 12 ");
        ListeChainee<Integer> subListInt = Utilitaire.subList(listInt,ind);
        subListInt.afficheGaucheDroiteRec();
        System.out.println("------------------------------------------------------------------");
        System.out.println("NOMBRE D'ENTIERS PAIRS DANS LA SOUS-LISTE");
        System.out.println("------------------------------------------------------------------");
        System.out.println("*La sous-liste contient " + Utilitaire.nbMult2(subListInt) + " entiers pairs");



    }
}
