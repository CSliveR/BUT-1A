import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {
    // Fonctions ou procédures concernant un lancer de dés – Partie 2

    // Saisie du chiffre indiqué sur la face supérieure d'un dé - Q2.1
    public static int saisieFace(int min, int max) {
        //{ min <= max }
        // => { résultat = entier compris entre min et max, saisi par l'utilisateur }
        Scanner lecteur = new Scanner(System.in);
        int unEnt;

        do{
            System.out.println("Entrez un entier compris entre " + min + " et " + max);
            unEnt = lecteur.nextInt();
            lecteur.nextLine();

            if(unEnt < min | unEnt > max){
                System.out.println("Saisie invalide, recommencez...");
            }
        }while(unEnt < min | unEnt > max);

        return unEnt;
    }

    // lancer d'un joueur - Q2.2
    public static ArrayList<Integer> saisieLancerDeJoueur() {
        //{ } => { résultat = vecteur de 5 entiers compris entre 1 et 6
        //                          saisis par l'utilisateur }

        ArrayList<Integer> vInt = new ArrayList<>();

        for(int i=0; i<5 ;i++){
            System.out.println("Lancer" + " " + (i + 1));
            vInt.add(i,saisieFace(1,6));
        }

        return vInt;
    }

    // Somme des valeurs d'un lancer - Q2.3
    public static int sommeFaces(ArrayList<Integer> unLancer) {
        //{ unLancer non vide } => { résultat = somme des éléments de unLancer }

        int somme = 0;

        for(int i=0; i < unLancer.size(); i++){
            somme = somme + unLancer.get(i);
        }

        return somme;
    }

    // Un lancer est-il un YAM ? - Q2.4
    public static boolean estUnYam(ArrayList<Integer> unLancer) {
        //{ unLancer non vide } => { résultat = vrai si unLancer représente un YAM }

        int val = unLancer.get(0);
        boolean unYam = false;

        for(int i=0; i < unLancer.size(); i++){
            unYam = (val == unLancer.get(i));
        }

        return unYam;
    }

    // Un lancer est-il un SMALL ? - Q2.5
    public static boolean estUnSmall(ArrayList<Integer> unLancer) {
        //{ unLancer non vide } => { résultat = vrai si unLancer représente un SMALL }
        return !estUnYam(unLancer) && sommeFaces(unLancer) <= 7;
    }

    // Un lancer est-il un BIG ? - - Non demandé, mais à développer...
    public static boolean estUnBig(ArrayList<Integer> unLancer) {
        //{unLancer non vide} => {résultat = vrai si unLancer représente un BIG}

        return !estUnYam(unLancer) && sommeFaces(unLancer) >= 28;
    }

    // Valeur maximum dans un lancer - Q2.6
    public static int maxVal(ArrayList<Integer> unLancerl) {
        // { unLancer non vide } => { résultat = maximum des éléments de unLancer }
        int max = unLancerl.get(0);

        for(int i=0; i < unLancerl.size(); i++){
            if(unLancerl.get(i) > max){
                max = unLancerl.get(i);
            }
        }

        return max;
    }

    // Valeur minimum dans un lancer - Non demandé, mais à développer... (
    public static int minVal(ArrayList<Integer> unLancerl) {
        // { unLancer non vide } => { résultat = maximum des éléments de unLancer }
        int min = unLancerl.get(0);

        for(int i=0; i < unLancerl.size(); i++){
            if(unLancerl.get(i) < min){
                min = unLancerl.get(i);
            }
        }
        return min;
    }

    // Un lancer est-il un FULL ? - - Q2.7
    public static boolean estUnFull(ArrayList<Integer> unLancer) {
        //{ unLancer.size() == 5 } => {résultat = vrai si unLancer représente un FULL }

        return !estUnYam(unLancer) && !estUnBig(unLancer) && !estUnSmall(unLancer);

    }

    // Un lancer est-il une SUITE ? - À ne pas développer
    public static boolean estUneSuite(ArrayList<Integer> unLancer) {
        //{ unLancer.size() == 5 } =>  { résultat = vrai si unLancer représente une SUITE }
        // 1 - tri par ordre croissant de unLancer
        ArrayList<Integer> unLancerT = new ArrayList<>();
        unLancerT = unLancer;
        int sauv, i = 0;
        boolean permute = true;
        while (permute) {
            permute = false;
            for (int j = unLancerT.size() - 1; j > i; j--) {
                if (unLancerT.get(j) < unLancerT.get(j - 1)) {
                    sauv = unLancer.get(j);
                    unLancerT.remove(j);
                    unLancerT.add(j - 1, sauv);
                    permute = true;
                }
            }
            i++;
        }
        // 2 - constitution du résultat
        i = 1;
        while (i < unLancerT.size() && unLancerT.get(i - 1) == unLancerT.get(i) - 1) {
            i++;
        }
        return i == unLancerT.size();
    }

    // Nombre de points rapportés par un lancer - Q2.8
    public static int nbPoints(ArrayList<Integer> unLancer) {
        //{ unLancer.size() == 5 } =>  { résultat =  nombre de points rapportés par unLancer }

        if(estUnYam(unLancer)){
            return 60 + sommeFaces(unLancer);
        }else if(estUneSuite(unLancer)){
            return 20 + sommeFaces(unLancer);
        }else if(estUnBig(unLancer) | estUnSmall(unLancer)){
            return 60;
        }else if(estUnFull(unLancer)){
            return 30 + sommeFaces(unLancer);
        }else{
            return 0;
        }
    }

    // Fonctions ou procédures pour un vecteur de joueurs – Partie 3
    // Indice dans un vecteur de joueurs trié, du premier élément strictement
    // supérieur à un joueur donné - Q3.2
    public static int indPremSup(ArrayList<Joueur> vJoueur, Joueur unJoueur) {
        // { * vJoueur trié selon l'ordre (nbPoints, nbYams)
        //   * unJoueur n'appartient pas à vJoueur}
        //  => { résultat = indice du premier élément de vJoueur strictement supérieur
        //                  à unJoueur selon l'ordre (nbPoints, nbYams) }

        int i = 0;

        while(i < vJoueur.size() && vJoueur.get(i).compareTo(unJoueur) <= 0){
            i++;
        }

        return i;
    }


    // Création d'un vecteur de joueurs trié dans l'ordre (nbPoints, nbYams)- Q3.3
    public static ArrayList<Joueur> creeVectJoueurTrie(ArrayList<Joueur> vJoueur) {
        // { vJoueurs non vide }
        //  => { résultat = vecteur contenant les mêmes éléments que vJoueur
        //                        mais trié selon l'ordre (nbPoints, nbYams) }

        ArrayList<Joueur> vJoueurTrie = new ArrayList<>();

        for (int i=0; i < vJoueur.size(); i++){
            vJoueurTrie.add(indPremSup(vJoueur,vJoueur.get(i)), vJoueur.get(i));
        }

        return vJoueurTrie;
    }

    // Nombre de gagnants - Q3.4
    public static int nbGagnants(ArrayList<Joueur> vJoueur) {
        //{ vJoueur non vide, trié selon l'ordre (nbPoints, nbYams) }
        // => { résultat = nombre de gagnants dans vJoueur }

        int i=0;
        int nbGagnants = 1;

        while(i < vJoueur.size() && vJoueur.get(i).compareTo(vJoueur.get(0)) == 0){
            nbGagnants ++;
            i++;
        }

        return nbGagnants;
    }

    // Initialisation d'un vecteur de joueurs - - Non demandé, mais à développer...
    public static ArrayList<Joueur> initJoueurs() {
        // { } => { résultat = un vecteur de 4 joueurs }
        ArrayList<Joueur> lesJoueurs = new ArrayList<>();

        for (int i=0; i < 4; i++){
            lesJoueurs.add(new Joueur("Joueur " + (i+1),0,0));
            System.out.println(lesJoueurs.get(i).getSurnom());
            saisieLancerDeJoueur();
        }

        return lesJoueurs;
    }
}
