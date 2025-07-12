package jeu;

/**
 * Classe qui contient la méthode d'affichage de l'ordre d'entrainement des guerriers dans leur château.
 */
public class ChateauUtilitaire {
    // METHODES D'AFFICHAGE

    /**
     * Affiche l'ordre d'entrainement des guerriers avec le coût de leur entrainement.
     * @param chateau
     */
    public static void OrdreEntrainement(Chateau chateau){
        for(int i=0; i < chateau.getGuerrierNovices().size(); i++){
            GuerrierUtilitaire.printPVUniteAvecCouleur(chateau.getGuerrierNovices().get(i));
            System.out.print(", cout : " + chateau.getGuerrierNovices().get(i).getRessourcesPourEntrainement());
            System.out.println();
        }
    }
}


