import java.util.Scanner;
import java.util.ArrayList;
public class Utilitaire {
    public static int saisirIntMinMax(int min, int max) {
        // { min <= max } => { résultat = entier compris entre min et max

        int unEnt;
        Scanner lecteur =  new Scanner(System.in);

        do{
            System.out.println("Entier compris entre " + min + " et " + max);
            unEnt = lecteur.nextInt();
            lecteur.nextLine();

            if(unEnt < min | unEnt > max){
                System.out.println("--> saisie invalide, recommencez...");
            }
        }while(unEnt < min | unEnt > max);

        return unEnt;
    }

    public static int rechPremIndSeq(ArrayList<Polar> vPolar, int an, String aut) {
        // { vPolar trié dans l'ordre (annee, auteur) } =>
        // { * s'il y a dans vPolar au moins un élément d'année an et d'auteur aut,
        // résultat = indice du premier de ces éléments
        // * sinon, résultat = -1
        // LA RECHERCHE EST SÉQUENTIELLE !!!

        int i = 0;
        Polar unPolar = new Polar(an, aut, "");

        while(i < vPolar.size() && vPolar.get(i).compareTo(unPolar) < 0){
            i++;
        }

        if((i < vPolar.size()) && (vPolar.get(i).compareTo(unPolar) == 0)){
            return i;
        }else{
            return -1;
        }
    }

    public static int rechPremIndDicho(ArrayList<Polar> vPolar, int an, String aut) {
        // { vPolar trié dans l'ordre (annee, auteur) } =>
        // { * s'il y a dans vPolar au moins un élément d'année an et d'auteur aut,
        // résultat = indice du premier de ces éléments
        // * sinon, résultat = -1
        // LA RECHERCHE EST DICHOTOMIQUE !!!

        Polar unPolar = new Polar(an, aut, "");

        if(vPolar.isEmpty() || vPolar.get(vPolar.size()-1).compareTo(unPolar) < 0){
            return -1;
        }else{
            int inf = 0;
            int sup = vPolar.size()-1;

            while(inf < sup){
                int mid = (inf + sup)/2;
                if(vPolar.get(mid).compareTo(unPolar) >= 0){
                    sup = mid;
                }else{
                    inf = mid + 1;
                }
            }

            if(vPolar.get(inf).compareTo(unPolar) == 0){
                return inf;
            }else{
                return -1;
            }

        }

    }

    //a) Existence de romans d'un auteur donné dans un intervalle d'années
    public static boolean existPolar(ArrayList<Polar> vPolar, int an1, int an2, String unAuteur) {
        // { * vPolar non vide et trié dans l'ordre (annee, auteur)
        // * an1 <= an2
        // * an1 est >= à la plus petite valeur de l'attribut annee dans vPolar
        // * an2 est <= à la plus grande valeur de l'attribut année dans vPolar }
        // => { résultat = vrai s'il existe dans vPolar, au moins un roman
        // dont l'année est comprise entre an1 et an2 et d'auteur unAuteur

        int i = 0;
        Polar unPolar = new Polar(an2, unAuteur, "");

        while(i < vPolar.size() && vPolar.get(i).compareTo(unPolar) < 0){
            i++;
        }

        return i < vPolar.size() && vPolar.get(i).compareTo(unPolar) == 0;
   }

   //(b) Affichage des titres des romans d'un auteur donné pour chaque année d'un intervalle d'années
    public static void lesPolarsDe(ArrayList<Polar> vPolar, int an1, int an2, String unAuteur) {
        // { * vPolar non vide et trié dans l'ordre (annee, auteur)
        // * an1 <= an2
        // * an1 est >= à la plus petite valeur de l'attribut annee dans vPolar
        // * an2 est <= à la plus grande valeur de l'attribut année dans vPolar }
        // * vPolar contient au moins un roman dont l'auteur est unAuteur
        // et dont l'année est dans l'intervalle [an1, an2] }
        // => { chaque année A comprise entre an1 et an2 est affichée, suivie :
        // * de l'affichage ligne à ligne des titres des romans écrits l'année A
        // par unAuteur (chaque titre précédé d'un tiret)
        // * d'un tiret, si aucun roman n'a été écrit l'année A par unAuteur

        if(existPolar(vPolar,an1,an2,unAuteur)){
            System.out.println("Romans de " + unAuteur + " entre " + an1 + " et " + an2);
            while(an1 <= an2){
                System.out.println("*année " + an1);
                for (int i=0; i < vPolar.size(); i++){
                    if(vPolar.get(i).getAnnee() == an1 && vPolar.get(i).getAuteur().compareTo(unAuteur) == 0){
                        System.out.println("-" + vPolar.get(i).getTitre());
                    }
                    if(vPolar.get(i).getAnnee() == an1 && vPolar.get(i).getAuteur().compareTo(unAuteur) != 0){
                        System.out.println("-");
                    }
                }

                an1++;
            }

        }else{
            System.out.println("Aucun roman de " + unAuteur + " entre " + an1 + " et " + an2);
        }
    }
}
