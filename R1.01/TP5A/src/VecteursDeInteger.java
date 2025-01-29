import java.util.Scanner;
import java.util.ArrayList;
public class VecteursDeInteger {
    //a) Saisie contrôlée d'un entier strictement positif
    public static int saisieEntPos() {
        // { } => { résultat = un entier >0, saisi par l'utilisateur
        int unEnt;
        Scanner lecteur = new Scanner(System.in);
        do{
            System.out.println("Entrez un entier strictement positif");
            unEnt = lecteur.nextInt();
            lecteur.nextLine();

            if(unEnt <= 0){
                System.out.println("--> saisie invalide, recommencez ...");
            }

        }while(unEnt <= 0);

        return unEnt;
    }

    //b) Vecteur d'entiers contenant tous les diviseurs d'un entier donné, strictement positif
    public static ArrayList<Integer> lesDiviseurs(int unEnt) {
        // { unEnt >0 } => {résultat = vecteur contenant les diviseurs de unEnt
        // y compris 1 et unEnt

        ArrayList<Integer> lesDiviseurs = new ArrayList<>();

        for(int i = 1; i <= unEnt/2; i++){
            if(unEnt%i == 0){
                lesDiviseurs.add(i);
            }
        }
        lesDiviseurs.add(unEnt);

        return lesDiviseurs;
    }

    //a) Somme des éléments d'un ArrayList de Integer, ne contenant que des entiers strictement positifs
    private static int sommeDe(ArrayList<Integer> unVectEntPos) {
        // { unVectEntPos non vide, tous ses éléments sont > 0 } =>
        // { résultat = somme des éléments de unVectEntPos

        int somme = 0;

        for(int i=0; i < unVectEntPos.size(); i++){
            somme+= unVectEntPos.get(i);
        }

        return somme;

    }

    //b) Un entier est-il premier ?
    private static boolean estPremier(int unEnt) {
        // { unEnt >0 } => { résultat = vrai si unEnt est PREMIER
        return (lesDiviseurs(unEnt).size() == 2);

    }

    //c) Un entier est-il parfait ?
    private static boolean estParfait (int unEnt) {
        // {unEnt >0 } => { résultat = vrai si unEnt est PARFAIT
        return sommeDe(lesDiviseurs(unEnt))/2 == unEnt;

    }

    //d) Un entier est-il sublime ?
    private static boolean estSublime(int unEnt) {
        //{ unEnt >0 } => { résultat = vrai si unEnt est SUBLIME
        return estParfait(sommeDe(lesDiviseurs(unEnt)));
    }

    private static String qualiteDe(int unEnt) {
        // { unEnt >0 } =>
        // { résultat = "PREMIER", "PARFAIT", "SUBLIME" ou "QUELCONQUE"
        // selon les propriétés de unEnt

        if (estPremier(unEnt)) {
            return "PREMIER";
        }else if(estParfait(unEnt)){
            return "PARFAIT";
        }else if(estSublime(unEnt)){
            return "SUBLIME";
        }else{
            return "QUELCONQUE";
        }
    }

    public static void main(String[] args) {
        int unEnt = saisieEntPos();
        ArrayList<Integer> lesDiv;
        lesDiv = lesDiviseurs(unEnt);
        System.out.println("Diviseurs de " + unEnt + ": "  + lesDiv);
        System.out.println("*Nombre de diviseurs: " + lesDiv.size());
        System.out.println("*Somme des diviseurs: " + sommeDe(lesDiv));
        System.out.println("*Qualité: " + qualiteDe(unEnt));

        if(!estPremier(unEnt)){
            System.out.println("Diviseurs de " + unEnt + " autres que 1 et " + unEnt);
        }

        for(int i=1; i < lesDiv.size()-1; i++){
            System.out.println("- " + lesDiv.get(i) + " est " + qualiteDe(lesDiv.get(i)));
        }
    }

}
