import java.util.Scanner;

public class Calculs {
    private static int saisieEntPosOuNul() {
        // { } =>
        // { résultat = un entier positif ou nul saisi par l'utilisateur
        int unEnt;
        Scanner lecteur = new Scanner(System.in);

        do {
            unEnt = lecteur.nextInt();
            lecteur.nextLine();

            if (unEnt < 0) {
                System.out.println("--> Saisie invalide recommencez ...");
                System.out.println("Entrez un entier positif ou nul: ");
            }

        } while (unEnt < 0);

        return unEnt;
    }

    private static int saisieEntMinMax(int min, int max) {
        // { 0 <= min <= max } => { résultat = entier compris entre min et max saisi par l'utilisateur
        int unEnt;
        Scanner lecteur = new Scanner(System.in);

        do {
            unEnt = lecteur.nextInt();
            lecteur.nextLine();

            if (unEnt < min | unEnt > max) {
                System.out.println("--> Saisie invalide recommencez...");
                System.out.println("Entrez un entier compris entre 0 et " + max + " :");
            }

        } while (unEnt < min | unEnt > max);

        return unEnt;
    }

    private static int factorielle(int n) {
        // { n >= 0 } => { résultat = factorielle de n (n!)

        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }


    private static int combinaison(int n, int p) {
        // { 0 <= p <= n } =>
        // { résultat = nombre de sous-ensembles de p éléments que l'on peut obtenir à partir d'un ensemble de n éléments
        // formule : n!/(p!*(n-p)!)

        return factorielle(n) / (factorielle(p) * factorielle(n - p));
    }

    private static int arrangement(int n, int p) {
        // { 0 <= p <= n } =>
        // { résultat = nombre de n-uplets ordonnés de p éléments que l'on peut obtenir à partir d'un ensemble de n éléments
        // formule : n!/(n-p)!

        return factorielle(n) / (factorielle(n - p));
    }


    private static void trianglePascal(int n) {
        // { n >= 0 } =>
        // { les lignes 0 à n du triangle de Pascal ont été affichées de façon à ce que sur chaque ligne, les coefficients binomiaux
        // soient séparés par un espace

        int i;
        int j;

        for(i = 0; i <= n;i++){
            for(j = 0; j < i; j++){
                System.out.print(" " + factorielle(i)/(factorielle(j)*(factorielle(i-j))));
            }
            System.out.println(" " + factorielle(i)/(factorielle(j)*(factorielle(i-j))));
        }

    }


    public static void main(String[] args) {
        int n, p;

        System.out.println("Entrez un entier positif ou nul: ");
        n = saisieEntPosOuNul();

        System.out.println("Entrez un entier compris entre 0 et " + n + " :");
        p = saisieEntMinMax(0, n);

        System.out.println("-------------------------------------------------");
        System.out.println("Factorielle de " + n + " =" + ' ' + factorielle(n));

        System.out.println("-------------------------------------------------");
        System.out.println("Nombre de sous-ensembles de " + p + " parmi" + n + " éléments: " + combinaison(n, p));

        System.out.println("-------------------------------------------------");
        System.out.println("Nombre de n-uplets ordonnés de " + p + " éléments parmi " + n + " éléments: " + arrangement(n, p));

        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("Lignes de 0 à " + (n - 1) + " du triangle de pascal");
        System.out.println("-------------------------------------------------");
        trianglePascal(n-1);


    }


}
