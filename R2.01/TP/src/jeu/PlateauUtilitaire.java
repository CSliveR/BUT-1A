package jeu;

/**
 * Classe qui regroupe des méthodes d'affichage relatives au plateau.
 */
public class PlateauUtilitaire {
    // AFFICHAGE
    /**
     * Affichage des Guerriers sur chaque Carreaux du plateau
     * @param plateau
     */

    public static void affichePlateau(Plateau plateau){
        System.out.println(plateau.getClass().getSimpleName() + " "  + plateau);
    }

    /**
     * Affiche le plateau avec le numéro de tour actuel du jeu.
     * @param plateau
     */

    public static void affichePlateauAvecTour(Plateau plateau){
        System.out.println(plateau.getClass().getSimpleName() + " "  + plateau + " (Tour " + plateau.getTour() + ")");
    }

    /**
     * Affichage de l'équipe gagnante
     * @param plateau
     */

    public static void afficheEquipeGagnante(Plateau plateau){
        System.out.println("Equipe gagnante: les " + plateau.estGagnant() + "s");
    }

}
