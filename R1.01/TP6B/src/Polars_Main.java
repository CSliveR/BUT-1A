import java.util.ArrayList;
import java.util.Scanner;

public class Polars_Main {
    public static void main(String[] args) {
        ArrayList<Polar> lesPolars = InitBibPolars.lesPolars();
        ArrayList<Polar> vPolarsVide = new ArrayList<>();
        Scanner lecteur = new Scanner(System.in);
        System.out.println(lesPolars);

        int anMin = lesPolars.get(0).getAnnee();
        int anMax = lesPolars.get(lesPolars.size()-1).getAnnee();
        int anTest = Utilitaire.saisirIntMinMax(anMin, anMax);
        int an2 = Utilitaire.saisirIntMinMax(anTest,anMax);

        System.out.println("Donnez le nom d'un auteur : ");
        String auteurTest = lecteur.nextLine();

        int rechPremIndSeq = Utilitaire.rechPremIndSeq(lesPolars,anTest,auteurTest);
        System.out.println("RECHERCHE SÉQUENTIELLE D'UN ROMAN ÉCRIT PAR " + auteurTest + " en " + anTest);
        if(rechPremIndSeq!= -1){
            System.out.println("* Roman trouvé à l'indice " + rechPremIndSeq + " dans le vecteur" + " - titre : " + lesPolars.get(rechPremIndSeq).getTitre());
        }else{
            System.out.println("* Aucun roman de " + auteurTest + " pour " + anTest);
        }

        int rechPremIndSeqVecVide = Utilitaire.rechPremIndSeq(vPolarsVide,anTest,auteurTest);
        System.out.println("RECHERCHE SÉQUENTIELLE DANS UN VECTEUR VIDE D'UN ROMAN ÉCRIT PAR " + auteurTest + " en " + anTest);
        if(rechPremIndSeqVecVide!= -1){
            System.out.println("* Roman trouvé à l'indice " + rechPremIndSeqVecVide + " dans le vecteur" + " - titre : " + lesPolars.get(rechPremIndSeqVecVide).getTitre());
        }else{
            System.out.println("* Aucun roman de " + auteurTest + " pour " + anTest + " (vecteur vide)");
        }

        int rechPremIndDicho = Utilitaire.rechPremIndDicho(lesPolars,anTest,auteurTest);
        System.out.println("RECHERCHE DICHOTOMIQUE D'UN ROMAN ÉCRIT PAR " + auteurTest + " en " + anTest);
        if(rechPremIndDicho!= -1){
            System.out.println("* Roman trouvé à l'indice " + rechPremIndDicho + " dans le vecteur" + " - titre : " + lesPolars.get(rechPremIndDicho).getTitre());
        }else{
            System.out.println("* Aucun roman de " + auteurTest + " pour " + anTest);
        }


        int rechPremIndDichoVecVide = Utilitaire.rechPremIndDicho(vPolarsVide,anTest,auteurTest);
        System.out.println("RECHERCHE DICHOTOMIQUE DANS UN VECTEUR VIDE D'UN ROMAN ÉCRIT PAR " + auteurTest + " en " + anTest);
        if(rechPremIndDichoVecVide != -1){
            System.out.println("* Roman trouvé à l'indice " + rechPremIndDichoVecVide + " dans le vecteur" + " - titre : " + lesPolars.get(rechPremIndDichoVecVide).getTitre());
        }else{
            System.out.println("* Aucun roman de " + auteurTest + " pour " + anTest + " (vecteur vide)");
        }

        //an1 = anTest
        //an2 = Utilitaire.saisirIntMinMax(anTest,anMax);  (déclaré en haut)

        Utilitaire.lesPolarsDe(lesPolars,anTest,an2,auteurTest);
    }
}
