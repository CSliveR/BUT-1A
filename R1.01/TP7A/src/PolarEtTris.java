import jdk.jshell.execution.Util;

import java.util.ArrayList;

public class PolarEtTris {
    public static void main(String[] args) {
        ArrayList<Polar> lesPolars = CreationBib.lesPolars();

       /* System.out.println(Utilitaire.verifTri(lesPolars));
        for(int i=0; i < lesPolars.size();i++){
            System.out.println(lesPolars.get(i).getTitre());
        }*/
        // Intermède : vérification du code de compareTo et de toString
        Polar pol1 = new Polar(2000, "AUTEUR1", "Une oeuvre");
        Polar pol2 = new Polar(2000, "AUTEUR2", "Mon oeuvre");
        Polar pol3 = new Polar(1998, "AUTEUR1", "Oeuvre sans nom");
        System.out.print("pol1 : "); System.out.println(pol1);
        System.out.print("pol2 : "); System.out.println(pol2);
        System.out.print("pol3 : "); System.out.println(pol3);
        System.out.println("* pol1 comparé à pol2 : " + pol1.compareTo(pol2));
        System.out.println("* pol1 comparé à pol1 : " + pol1.compareTo(pol1));
        System.out.println("* pol1 comparé à pol3 : " + pol1.compareTo(pol3));

        System.out.println("Tri du vecteur selon l'ordre (auteur, annee) par la méthode du tri par séléction");
        Utilitaire.triSelect(lesPolars);
        System.out.println(lesPolars);

        System.out.println("Tri du vecteur selon l'ordre (auteur, annee) par la méthode du tri à bulle amélioré");
        Utilitaire.triBulle(lesPolars);
        System.out.println(lesPolars);


        System.out.println("Tri du vecteur selon l'ordre (auteur, annee) par la méthode du tri par insertion");
        Utilitaire.triInsertion(lesPolars);
        System.out.println(lesPolars);

        Utilitaire.nbPolarAuteur(lesPolars);

        System.out.println("* Auteurs ayant écrit en 2016 ");
        System.out.println(Utilitaire.auteursDeAn(lesPolars,2016));
        System.out.println("* Auteurs ayant écrit en 2008 ");
        System.out.println(Utilitaire.auteursDeAn(lesPolars,2008));
        System.out.println("* Auteurs ayant écrit en 1975");
        System.out.println(Utilitaire.auteursDeAn(lesPolars,1975));
        System.out.println("* Auteurs ayant écrit en 2001");
        System.out.println(Utilitaire.auteursDeAn(lesPolars,2001));





    }
}
