import java.util.InputMismatchException;
import java.util.Scanner;
public class Utilitaire {
    //a) Saisie d'une variable de type int contrôlée par gestion de InputMismatchException
    public static int getInt_IME(Scanner lecteur) {
        // { } => {résultat = un entier saisi par l'utilisateur
        // L'EXCEPTION InputMismatchException EST GÉRÉE

        int unEnt;

        try {
            System.out.println("Entrez un entier");
            unEnt = lecteur.nextInt();
            lecteur.nextLine();
            return unEnt;
        } catch (InputMismatchException e) {
            lecteur.nextLine();
            System.out.println("-->Un nombre entier est attendu");
            return getInt_IME(lecteur);
        }
    }

    //b) Saisie d'une variable de type int comprise entre deux entiers donnés et gérant InputMismatchException
    public static int getIntMinMax_IME(Scanner lecteur, int min, int max) {
        // { min <= max } =>
        // { résultat = un entier compris entre min et max, saisi par l'utilisateur
        // L'EXCEPTION inputMismatchException EST GÉRÉE

        int unEnt;

        try {
            do {
                System.out.println("Entrez un entier compris entre " + min + " et " + max);
                unEnt = lecteur.nextInt();
                lecteur.nextLine();

                if (unEnt < min | unEnt > max) {
                    System.out.println("-->Saisie invalide");
                }
            } while (unEnt < min | unEnt > max);

            return unEnt;
        } catch (InputMismatchException e) {
            lecteur.nextLine();
            System.out.println("-->Un nombre entier est attendu");
            return getIntMinMax_IME(lecteur, min, max);
        }
    }

    //a) Saisie d'une variable de type int contrôlée par gestion de NumberFormatException
    public static int getInt_NFE(Scanner lecteur) {
        // { } => {résultat = un entier saisi par l'utilisateur
        // L'EXCEPTION NumberFormatException EST GÉRÉE

        String s;

        try {
            System.out.println("Entrez un entier");
            s = lecteur.nextLine();
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            System.out.println("-->Un nombre entier est attendu");
            return getInt_NFE(lecteur);
        }
    }

    //b) Saisie d'une variable de type float contrôlée par gestion de NumberFormatException
    public static float getFloat_NFE(Scanner lecteur) {
        // { } => { résultat = un réel saisi par l'utilisateur
        // L'EXCEPTION NumberFormatException EST GÉRÉE

        String s;

        try {
            System.out.println("Entrez un nombre à virgule");
            s = lecteur.nextLine();
            return Float.parseFloat(s);
        } catch (NumberFormatException nfe) {
            System.out.println("-->Un nombre à virgule est attendu");
            return getInt_NFE(lecteur);
        }
    }


    //a) Somme des entiers portés par les cellules d'une liste d'entiers non vide - FORME ITÉRATIVE
    public static int sumIter(ListeChainee<Integer> listInt) throws ExceptionMauvaisIndice {
        // { listInt non vide } =>
        // { résultat = somme des entiers portés par les cellules de listInt

        int somme = 0;

        for (int i = 1; i < listInt.getLongueur() + 1; i++) {
            somme += listInt.getInfoAtPosit(i);
        }

        return somme;
    }


    //b) Somme des entiers portés par les cellules d'une liste d'entiers non vide - FORME RÉCURSIVE
    // le point d'entrée
    public static int sumRec(ListeChainee<Integer> listInt) {
        // { listInt non vide } =>
        // { résultat = somme des entiers portés par les cellules de listInt


        return sumRec_wk(listInt.getTete());

    }

    //le worker (récursif)
    private static int sumRec_wk(Cellule<Integer> cellCour) {
        // { } =>
        // { résultat = somme des entiers portés par les cellules d'une sous-liste
        // de tête cellCour


        if (cellCour == null) {
            return 0;
        } else {
            return cellCour.getInfo() + sumRec_wk(cellCour.getCelluleSuivante());
        }
    }

    //a) Existence d'un entier donné dans une liste d'entiers - FORME RÉCURSIVE
    //le point d'entrée
    public static boolean existIntRec(ListeChainee<Integer> listInt, int unInt) {
        // { } =>
        // { résultat = vrai si au moins une cellule de listInt porte l'info unInt

        return existIntRec_wk(listInt.getTete(), unInt);
    }

    //le worker (récursif)
    private static boolean existIntRec_wk(Cellule<Integer> cellCour, int unInt) {
        // { } => { résultat = vrai si au moins une cellule d'une sous-liste de tête
        // cellCour porte l'info unInt

        if (cellCour == null){
            return false;
        } else if(cellCour.getInfo() == unInt) {
            return true;
        } else {
            return existIntRec_wk(cellCour.getCelluleSuivante(), unInt);
        }
    }


    //b) Rang de la première cellule portant un entier supérieur à un entier donné - FORME ITÉRATIVE
    public static int posFirstSup(ListeChainee<Integer> listInt, int unInt) throws ExceptionMauvaisIndice {
        // { } => {résultat = rang de la première cellule de listInt portant
        // un entier supérieur à unInt, 0 si non trouvée

        int i=1;

        while (i < listInt.getLongueur() + 1 && listInt.getInfoAtPosit(i) <= unInt) {
            i++;
        }

        if(listInt.getInfoAtPosit(i) > unInt){
            return i;
        }else{
            return 0;
        }

    }

    //a) Valeur maximum portée par une cellule d'une liste d'entiers - FORME ITÉRATIVE
    public static int bigger(ListeChainee<Integer> listInt) throws ExceptionMauvaisIndice {
        // { listInt non vide } =>
        // { résultat = plus grand entier porté par une cellule de listInt

        int plusGrand = listInt.getTete().getInfo();

        for(int i=1; i < listInt.getLongueur()+1; i++){
            if(listInt.getInfoAtPosit(i) > plusGrand){
                plusGrand = listInt.getInfoAtPosit(i);
            }
        }
        return plusGrand;
    }

    //b) Sous-liste d'une liste d'entiers, à partir d'une position donnée
    public static ListeChainee<Integer> subList(ListeChainee<Integer> listInt, int position) throws ExceptionMauvaisIndice {
        // { * listInt non vide,
        // * position compris entre 1 et le nombre de cellules de listInt } =>
        // { résultat = une liste d'entiers contenant les cellules de listInt
        // à partir de position

        ListeChainee<Integer> subListInt = new ListeChainee<>();

        for(int i = listInt.getLongueur(); i >= position; i--){
            subListInt.insereTete(listInt.getInfoAtPosit(i));
        }

        return subListInt;
    }

    // c) Nombre d'entiers pairs portés par les cellules d'une liste d'entiers – FORME RÉCURSIVE
    //le point d'entrée
    public static int nbMult2(ListeChainee<Integer> listeInt) {
        // { } =>
        // { résultat = nombre d'entiers pairs portés par les cellules de listeInt

        return nbMult2_wk(listeInt.getTete());
    }

    //le worker (récursif)
    private static int nbMult2_wk(Cellule<Integer> cellCour) {
        // { } =>
        // { résultat = nombre d'entiers pairs portés par les cellules d'une sous-liste
        // de tête cellCour

        if(cellCour.getCelluleSuivante() == null){
            if(cellCour.getInfo()%2 == 0){
                return 1;
            }else{
                return 0;
            }
        }else{
            if (cellCour.getInfo()%2 == 0){
                return 1 + nbMult2_wk(cellCour.getCelluleSuivante());
            }else{
                return nbMult2_wk(cellCour.getCelluleSuivante());
            }
        }
    }

}




