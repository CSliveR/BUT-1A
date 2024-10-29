
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Algos {
    //Saisie d'un entier compris dans un intervalle, sans gestion d'exception – TEST lignes 52 à 54
    public static int saisieEntMinMax(Scanner lecteur, int min, int max) {
        // { } => { résultat = un entier de l'intervalle [min..max] saisi par l'utilisateur

        int unEnt;

        do{
            System.out.println("Entrez un entier entre " + min + " et " + max);
            unEnt = lecteur.nextInt();
            lecteur.nextLine();
        }while(unEnt < min | unEnt > max);

        return unEnt;
    }

    //Saisie d'un entier supérieur à un entier donné avec gestion de InputMismatchException – TEST lignes 58 à 60
    public static int saisieEntSup(Scanner lecteur, int val) {
        // { } => { résultat = un entier supérieur à val, saisi par l'utilisateur
        // L'exception InputMismatchException qui sera déclenchée si l'utilisateur
        // saisit autre chose qu'un entier est gérée

        try{
            int unEnt;
            do{
                System.out.println("Entrez un entier supérieur à " + val);
                unEnt = lecteur.nextInt();
                lecteur.nextLine();
            }while(unEnt <= val);
            return unEnt;
        }catch (InputMismatchException e){
            lecteur.nextLine();
            return saisieEntSup(lecteur,val);
        }
    }

    //Saisie contrôlée d'une chaîne dans un vecteur de chaînes non vide – TEST lignes 53 à 65
    public static String saisieChaineDeV(Scanner lecteur, ArrayList<String> vString) {
        // { vString non vide }
        // => { résultat = un élément de vString, saisi par l'utilisateur

        String uneChaine;

        do {
            System.out.println("Entrez une chaine parmi " + vString);
            uneChaine = lecteur.nextLine();
        } while (vString.indexOf(uneChaine) != 1);

        return uneChaine;
    }

    //Plus grand entier d'un vecteur d'entiers non vide – TEST lignes 72 à 73
    public static int maximum(ArrayList<Integer> vInt) {
        // { vInt non vide } => { résultat = plus grand entier dans vInt

        int max = vInt.get(0);

        for(int i=1;i< vInt.size();i++){
            if(vInt.get(i) > max){
                max = vInt.get(i);
            }
        }

        return max;
    }

    //Moyenne des valeurs d'un vecteur d'entiers quelconque – TEST lignes 76 à 86
    public static float moyenne(ArrayList<Integer> vInt) throws ExceptionMoyImpossible {
        // { } =>
        // { * si vInt est vide, l'exception ExceptionMoyImpossible est levée
        // avec un message expliquant le problème
        // * sinon, la moyenne des éléments de vInt est retournée

        if(vInt.isEmpty()){
            throw new ExceptionMoyImpossible("Il n'y a pas de valeurs");
        }else{
            float moy = 0;
            for(int i=0;i<vInt.size();i++){
                moy = moy + vInt.get(i);
            }
            return moy/ vInt.size();
        }
    }

    //Plus petite chaîne selon l'ordre lexicographique dans un vecteur de chaînes non vide – TEST lignes 90 à 93
    public static String minOrdreLG(ArrayList<String> vString) {
        // { vString non vide } =>
        // { résultat = plus petite chaîne de vString selon l'ordre lexicographique

        String plusPetiteChaine = vString.get(0);

        for(int i=0; i < vString.size();i++){
            if(vString.get(i).compareTo(plusPetiteChaine) < 0){
                plusPetiteChaine = vString.get(i);
            }
        }

        return plusPetiteChaine;
    }

    //Somme des éléments d'un vecteur d'entiers non vide – FORME RECURSIVE – TEST lignes 101 à 102
    //le point d'entrée
    public static int somme(ArrayList<Integer> vInt) {
        // { vInt non vide } => { résultat = somme des éléments de vInt

        return somme_wk(vInt,vInt.size()-1);

    }

    //le worker récursif
    private static int somme_wk(ArrayList<Integer> vInt, int dep) {
        if(dep == 0){
            return vInt.get(dep);
        }else{
            return vInt.get(dep) + somme_wk(vInt,dep-1);
        }
    }

    //Nombre d'entiers égaux à un entier donné dans une liste triée croissante d'entiers – FORME RECURSIVE – TEST lignes 106 à 109
   // le point d'entrée
    public static int nbEntDeVal(ListeTrieeC<Integer> lIntC, int unEnt) {
        // { } => { résultat = nombre d'entiers égaux à unEnt dans lIntC

        return nbEntDeVal_wk(lIntC.getTete(),unEnt);
    }

   // le worker récursif
    private static int nbEntDeVal_wk(Cellule<Integer> cellCour, int unEnt) {

        int nbEnt = 0;
        while(cellCour != null){
            if(cellCour.getInfo() == unEnt){
                nbEnt++;
            }
            cellCour = cellCour.getCelluleSuivante();
        }

        return nbEnt;
    }

    //Nombre de jetons de valeur supérieure à 3 dans un vecteur de Jeton non vide – TEST lignes 112 à 114
    public static int nbJetonsSup3(ArrayList<Jeton> vJetons) {
        // { vJetons non vide } =>
        // { résultat = nombre d'éléments de vJetons dont la valeur est supérieure à 3

        int nbJetonSup3 = 0;

        for(int i=0; i < vJetons.size() ;i++){
            if(vJetons.get(i).getValeur() > 3){
                nbJetonSup3++;
            }
        }

        return nbJetonSup3;

    }

    //Existence d'un entier donné dans un vecteur d'entiers quelconque (recherche séquentielle)
    //FORME ITERATIVE – TEST lignes 123 à 135
    public static boolean existValSeq_it(ArrayList<Integer> vInt, int val) {
        // { } => { résultat = vrai si val est un élément de vInt

        int i=0;

        while(i < vInt.size() && vInt.get(i) != val){
            i++;
        }

        return i < vInt.size() && vInt.get(i) == val;
    }


    //FORME RECURSIVE – TEST lignes 138 à 150
    //le point d'entrée
    public static boolean existValSeq_rec(ArrayList<Integer> vInt, int val) {
        // { } => { résultat = vrai si val est un élément de vInt

        return existValSeq_rec_wk(vInt,val,0);
    }

    //le worker récursif
    private static boolean existValSeq_rec_wk(ArrayList<Integer> vInt, int val, int indice) {
        // { 0 <= indice < vInt.size() } =>
        // { résultat = vrai si val est un élément de vInt[indice..vInt.size()-1]

        if(indice == vInt.size()-1){
            if(vInt.get(indice) == val){
                return true;
            }else{
                return false;
            }
        }else{
            if(vInt.get(indice) == val){
                return true;
            }else{
                return existValSeq_rec_wk(vInt, val, indice+1);
            }
        }
    }

    //Indice de la première occurrence d'un entier donné dans un vecteur trié d'entiers
            //(recherche dichotomique) – TEST lignes 154 à 183
    public static int rechIndDicho(ArrayList<Integer> vInt, int val) {
        // { vInt trié } =>
        // { résultat = indice de la 1ère occurrence de val dans vInt si trouvé, -1 sinon

        if (vInt.isEmpty() || vInt.get(vInt.size()-1) < val) {
            return -1;
        }else{
            int inf = 0;
            int sup = vInt.size()-1;

            while(inf < sup){
                int mid = (inf+sup)/2;

                if(vInt.get(mid) < val){
                    inf = mid +1;
                }else{
                    sup = mid;
                }
            }

            if(vInt.get(inf) == val){
                return inf;
            }else{
                return -1;
            }
        }
    }

    //Position de la première occurrence d'une chaîne donnée dans une liste de chaînes triée croissant – TEST lignes 187 à 203
    public static int rechPos(ListeTrieeC<String> lString, String uneChaine) {
        // { } =>
        // { résultat = position de la 1ère occurrence de uneChaine dans lString,
        // 0 si non trouvée

        Cellule<String> cellCour = lString.getTete();
        int indChaine = 1;

        while(cellCour != null && cellCour.getInfo().compareTo(uneChaine) < 0){
            cellCour = cellCour.getCelluleSuivante();
            indChaine++;
        }

        if(cellCour != null && cellCour.getInfo().compareTo(uneChaine) == 0){
            return indChaine;
        }else{
            return 0;
        }
    }

    //Tri à bulles amélioré d'un vecteur d'entiers – TEST lignes 210 à 219
    public static void triBulle(ArrayList<Integer> vInt) {
        // { } => { vInt a été trié par la méthode du tri à bulles amélioré

        int j;
        int i = 0;
        boolean permute = true;

        while(permute){
            j = vInt.size()-1;
            permute = false;
            while(j > i){
                if(vInt.get(j) < vInt.get(j-1)){
                    int temp = vInt.get(j);
                    vInt.set(j, vInt.get(j-1));
                    vInt.set(j-1, temp);
                    permute = true;
                }
                j--;
            }
            i++;
        }
    }

    //Vecteur d'objets de type Jeton, résultant du tri par insertion d'un vecteur d'objets de type Jeton – TEST lignes 222 à 227
    public static ArrayList<Jeton> vJetonTrie(ArrayList<Jeton> vJetons) {
        // { vJetons non vide } =>
        // { résultat = vecteur de Jeton trié dont les éléments sont ceux de vJetons
        // Méthode utilisée pour le tri : tri par insertion

        int j;
        Jeton jetonAPlacer;
        int i = 1;

        while(i < vJetons.size()){
            j = i;
            jetonAPlacer = vJetons.get(i);
            while(j > 0 && vJetons.get(j-1).compareTo(jetonAPlacer) > 0){
                vJetons.set(j, vJetons.get(j-1));
                j--;
            }
            vJetons.set(j,jetonAPlacer);
            i++;
        }

        return vJetons;
    }

    //Vérification du tri d'un vecteur non vide, d'objets de type Jeton – TEST lignes 230 à 234
    public static boolean veriftri(ArrayList<Jeton> vJeton) {
        // { vJeton non vide }=> {
        // { résultat = vrai si vJeton trié selon l'ordre naturel de la classe Jeton, faux sinon

        int i = 1;

        while(i < vJeton.size() && vJeton.get(i-1).getValeur() <= vJeton.get(i).getValeur()){
            i++;
        }

        return i == vJeton.size();
    }


}
