package tp1.universite;

import java.util.Arrays;

/**
 * Méthodes de service pour un Etudiant
 */

public class EtudiantUtilitaire {
    public static void affiche(Etudiant etu){
        System.out.println();
        System.out.println("-----------------");
        System.out.println("Login : " + etu.getLogin());
        System.out.println("Nom complet : " + etu.getNomComplet());
        System.out.println("Mail : " + etu.getMail());
        System.out.println("Adresse : " + etu.getAdresse());

        if(etu.getIndice() != 0){
            System.out.println(etu.getIndice() + " notes : " + Arrays.toString(etu.getNotes()));
            System.out.println("Moyenne : " + etu.getMoyenne());
        }else{
            System.out.println("Moyenne : aucune note");
        }
    }

    public static String capitalize(String chaine){

        chaine = chaine.toLowerCase();

        char firstLetter = chaine.charAt(0);

        char majFirstLetter = Character.toUpperCase(firstLetter);

        return chaine.replace(chaine.charAt(0), majFirstLetter);
    }
}
