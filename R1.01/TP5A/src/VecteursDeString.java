import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VecteursDeString {
    //a) Nombre de chaines identiques dans deux vecteurs de chaines
    private static int nbChEgales(ArrayList<String> v1, ArrayList<String> v2) {
        // { v1 non vide, sans doublons, de même taille que v2 } =>
        // { résultat = nombre d'éléments de v1 dont la valeur est égale
        // à celle de l'élément de même indice dans v2

        int nbChEgales = 0;

        for(int i=0; i < v1.size(); i++){
            if(v1.get(i).compareTo(v2.get(i)) == 0){
                nbChEgales ++;
            }
        }

        return nbChEgales;
    }

    //b) Valeur dans un vecteur de chaînes de l'élément de même indice qu'une chaîne donnée dans un autre vecteur de chaînes
    public static String equiv(String uneChaine, ArrayList<String> v1,
                               ArrayList<String> v2) {
        // { v1 non vide, sans doublons, de même taille que v2 } =>
        // { résultat = * chaîne du vecteur v2, ayant le même indice que
        // uneChaine dans v1 si uneChaine est un élément de v1,
        // * chaîne vide sinon

        String ch = "";

        for(int i=0; i < v2.size(); i++){
            if(v1.get(i).compareTo(uneChaine) == 0){
                ch = v2.get(i);
            }
        }

        return ch;
    }



    public static void main(String[] args) {
        ArrayList<String> couleursFR = new ArrayList<>(Arrays.asList("rouge","orange","jaune","vert","bleu","indigo","violet"));
        ArrayList<String> couleursEN = new ArrayList<>(Arrays.asList("red", "orange", "yellow", "green", "blue", "indigo", "purple"));
        ArrayList<String> couleursJP = new ArrayList<>(Arrays.asList("aka", "orenji", "kiniro", "midori", "ao", "indigo", "murasaki"));
        String couleur;
        Scanner lecteur = new Scanner(System.in);
        char restart = 'o';

        System.out.println("Couleurs de l'arc en ciel en français : "  + couleursFR);
        System.out.println("Couleurs de l'arc en ciel en anglais : " + couleursEN);
        System.out.println("Couleurs de l'arc en ciel en japonais : " + couleursJP);
        System.out.println("----------------------------");
        System.out.println("Nombre de couleurs de même nom avec l'anglais: " + nbChEgales(couleursFR, couleursEN));
        System.out.println("Nombre de couleurs de même nom avec le japonais: " + nbChEgales(couleursFR, couleursJP));
        System.out.println("----------------------------");

        while(restart == 'o'){
            do {
                System.out.println("Entrez le nom français d'une des 7 couleurs de l'arc-en-ciel: ");
                couleur = lecteur.nextLine();

                if (!equiv(couleur, couleursFR, couleursEN).isEmpty()) {
                    System.out.println("--> l'équivalent de " + couleur + " en français parmi les noms des 7 couleurs en anglais est: " + equiv(couleur, couleursFR, couleursEN));
                    System.out.println("--> l'équivalent de " + couleur + " en français parmi les noms des 7 couleurs en japonais est: " + equiv(couleur, couleursFR, couleursJP));
                } else {
                    System.out.println("--> la couleur " + couleur + " ne fait pas partie des couleurs de l'arc-en-ciel.");
                }

                System.out.println("Recommencez (o pour continuer/ n pour arrêter)");
                restart = lecteur.next().charAt(0);
                lecteur.nextLine();
                System.out.println("----------------------------");

            } while (equiv(couleur, couleursFR, couleursEN).isEmpty());
        }

    }
}
