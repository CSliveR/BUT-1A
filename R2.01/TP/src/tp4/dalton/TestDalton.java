package tp4.dalton;

import java.util.ArrayList;
import java.util.TreeSet;

public class TestDalton {
    public static void main(String[] args) {
        // Création des Daltons
        Dalton joe = new Dalton("Joe", Taille.PETIT);
        Dalton jack = new Dalton("Jack", Taille.MOYEN);
        Dalton william = new Dalton("William", Taille.MOYEN);
        Dalton averell = new Dalton("Averell", Taille.GRAND);
        // Faire un ensemble triés des daltons sur l'ordre naturel (compareTo)
        TreeSet<Dalton> lesDaltons = new TreeSet<Dalton>();
        lesDaltons.add(averell);
        lesDaltons.add(joe);
        lesDaltons.add(william);
        lesDaltons.add(jack);
        // Affichage
        afficheCollection("Les daltons triés par ordre naturel (compareTo) :", lesDaltons);
        // Faire un ensemble triés des daltons avec le comparateur de Taille (solution 1)
        TreeSet<Dalton> lesDaltonsTaille = new TreeSet<Dalton>(new ComparateurTaille());
        lesDaltonsTaille.addAll(lesDaltons);
        // Affichage
        // ATTENTION 2 daltons avec la même taille donc vu que les doublons ne sont pas autorisés dans un Set (ensemble)
        // Un des daltons ne sera pas conservé
        afficheCollection("Les daltons triés par taille :", lesDaltonsTaille);
        // Faire un ensemble triés des daltons avec le comparateur de Nom (solution 1)
        TreeSet<Dalton> lesDaltonsNom = new TreeSet<Dalton>(new ComparateurNom());
        lesDaltonsNom.addAll(lesDaltons);

        // Affichage
        afficheCollection("Les daltons triés par nom :", lesDaltonsNom);
        // Faire un ensemble triés des daltons avec le comparateur de Nom (solution 2)
        TreeSet<Dalton> lesDaltonsNom2 = new TreeSet<Dalton>(Dalton.comparateurNomSolution2);
        lesDaltonsNom2.addAll(lesDaltons);
        // Affichage
        afficheCollection("Les daltons triés par nom :", lesDaltonsNom2);
    }

    private static void afficheCollection(String s, TreeSet<Dalton> listeDalton) {
        System.out.println(s);
        System.out.println(listeDalton + "\n");
    }
}
