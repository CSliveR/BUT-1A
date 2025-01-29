import java.util.ArrayList;
import java.util.Arrays;

public class CompareTris {
    public static void main(String[] args) {
        ArrayList<Integer> vIntBase;
        ArrayList<Integer> vInt;
        int nbComp;

        vIntBase = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9, 12, 14, 17, 18));
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 1: " + "Vecteur trié strictement croissant: " + vInt + ". Vecteur de taille " + vInt.size());

        System.out.println();

        nbComp = Utilitaire.triBulle_O(vInt);
        System.out.println("Vecteur après le tri à bulles " + vInt);
        System.out.println("Nombre de comparaisons du tri à bulles: " + nbComp);

        System.out.println();

        nbComp = Utilitaire.triInsert_O(vInt);
        System.out.println("Vecteur après le tri par insertion " + vInt);
        System.out.println("Nombre de comparaisons du tri par insertion: "  + nbComp);

        System.out.println();

        nbComp= Utilitaire.triSelect_O(vInt);
        System.out.println("Vecteur après le tri par sélection " + vInt);
        System.out.println("Nombre de comparaisons du tri par sélection: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = new ArrayList<>(Arrays.asList(12, 7, 9, 14, 5, 17, 6, 8, 18));
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 2: " + "Vecteur non trié: " + vInt + ". Vecteur de taille " + vInt.size());

        System.out.println();

        nbComp = Utilitaire.triBulle_O(vInt);
        System.out.println("Vecteur après le tri à bulles : " + vInt);
        System.out.println("Nombre de comparaisons du tri à bulles: " + nbComp);

        System.out.println();

        vInt = new ArrayList<>(vIntBase);
        nbComp = Utilitaire.triInsert_O(vInt);
        System.out.println("Vecteur après le tri par insertion : " + vInt);
        System.out.println("Nombre de comparaisons du tri par insertion: "  + nbComp);

        System.out.println();

        vInt = new ArrayList<>(vIntBase);
        nbComp= Utilitaire.triSelect_O(vInt);
        System.out.println("Vecteur après le tri par sélection : " + vInt);
        System.out.println("Nombre de comparaisons du tri par sélection: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = new ArrayList<>(Arrays.asList(18, 17, 14, 12, 9, 8, 7, 6, 5));
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 3: " + "Vecteur trié strictement décroissant: " + vInt + ". Vecteur de taille " + vInt.size());

        System.out.println();

        nbComp = Utilitaire.triBulle_O(vInt);
        System.out.println("Vecteur après le tri à bulles : " + vInt);
        System.out.println("Nombre de comparaisons du tri à bulles: " + nbComp);

        System.out.println();

        vInt = new ArrayList<>(vIntBase);
        nbComp = Utilitaire.triInsert_O(vInt);
        System.out.println("Vecteur après le tri par insertion : " + vInt);
        System.out.println("Nombre de comparaisons du tri par insertion: "  + nbComp);

        System.out.println();

        vInt = new ArrayList<>(vIntBase);
        nbComp = Utilitaire.triSelect_O(vInt);
        System.out.println("Vecteur après le tri par sélection : " + vInt);
        System.out.println("Nombre de comparaisons du tri par sélection: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 6, 7, 8, 9));
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 4: " + "Vecteur trié croissant avec 5 doublons au début du vecteur: " + vInt + ". Vecteur de taille " + vInt.size());

        System.out.println();

        nbComp = Utilitaire.triBulle_O(vInt);
        System.out.println("Vecteur après le tri à bulles : " + vInt);
        System.out.println("Nombre de comparaisons du tri à bulles: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 9, 9, 9, 9));
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 5: " + "Vecteur trié croissant avec 5 doublons à la fin du vecteur: " + vInt + ". Vecteur de taille " + vInt.size());

        System.out.println();

        nbComp = Utilitaire.triBulle_O(vInt);
        System.out.println("Vecteur après le tri à bulles : " + vInt);
        System.out.println("Nombre de comparaisons du tri à bulles: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = new ArrayList<>(Arrays.asList(18, 17, 16, 15, 0, 0, 0, 0, 0));
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 6: " + "Vecteur trié décroissant avec 5 doublons à la fin du vecteur " + vInt + ". Vecteur de taille " + vInt.size());

        System.out.println();

        nbComp = Utilitaire.triBulle_O(vInt);
        System.out.println("Vecteur après le tri à bulles : " + vInt);
        System.out.println("Nombre de comparaisons du tri à bulles: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = new ArrayList<>(Arrays.asList(18, 18, 18, 15, 9, 4, 3, 0, -2));
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 7: " + "Vecteur trié décroissant avec 3 doublons au début du vecteur " + vInt + ". Vecteur de taille " + vInt.size());

        System.out.println();

        nbComp = Utilitaire.triBulle_O(vInt);
        System.out.println("Vecteur après le tri à bulles : " + vInt);
        System.out.println("Nombre de comparaisons du tri à bulles: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = new ArrayList<>(Arrays.asList(18, 18, 18, 18, 18, 4, 3, 0, -2));
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 8: " + "Vecteur trié décroissant avec 5 doublons au début du vecteur " + vInt + ". Vecteur de taille " + vInt.size());

        System.out.println();

        nbComp = Utilitaire.triBulle_O(vInt);
        System.out.println("Vecteur après le tri à bulles : " + vInt);
        System.out.println("Nombre de comparaisons du tri à bulles: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = Utilitaire.genVectSansDoublons(10);
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 9: " + "Vecteur sans doublons de taille " + vInt.size() + " : " +  vInt);

        nbComp= Utilitaire.triSelect_O(vInt);
        System.out.println("Vecteur après le tri par sélection " + vInt);
        System.out.println("Nombre de comparaisons du tri par sélection: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = Utilitaire.genVectSansDoublons(40);
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 10: " + "Vecteur sans doublons de taille " + vInt.size() + " : " +  vInt);

        nbComp= Utilitaire.triSelect_O(vInt);
        System.out.println("Vecteur après le tri par sélection " + vInt);
        System.out.println("Nombre de comparaisons du tri par sélection: " + nbComp);

        System.out.println("------------------------------------------------------------");
        System.out.println("------------------------------------------------------------");

        vIntBase = Utilitaire.genVectSansDoublons(160);
        vInt = new ArrayList<>(vIntBase);
        System.out.println("*CAS 11: " + "Vecteur sans doublons de taille " + vInt.size() + " : " +  vInt);

        nbComp= Utilitaire.triSelect_O(vInt);
        System.out.println("Vecteur après le tri par sélection " + vInt);
        System.out.println("Nombre de comparaisons du tri par sélection: " + nbComp);



















    }
}
