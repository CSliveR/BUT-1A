import javax.script.ScriptEngineManager;

public class ListePolarsUtilitaire {

    /**
     * FOURNIE
     *
     * @param lesPolarsProduits
     * @return true si lesPolarsProduits sont bien lesPolarsAttendus
     */
    public static boolean estTriee(ListeChaineeTriee<Polar> lesPolarsProduits) {
        // on vérifie que l'on obtient bien la liste attendue
        ListeChaineeTriee<Polar> lesPolarsAttendus = CreationListePolars.chargementFichierTie();
        Cellule<Polar> celluleProduite = lesPolarsProduits.getTete();
        Cellule<Polar> celluleReference = lesPolarsAttendus.getTete();
        while (celluleProduite != null && celluleReference != null && celluleReference.getInfo().compareTo(celluleProduite.getInfo()) == 0) {
            celluleProduite = celluleProduite.getCelluleSuivante();
            celluleReference = celluleReference.getCelluleSuivante();
        }
        return celluleProduite == null && celluleReference == null;
    }

    /**
     * A ECRIRE : WORKER RÉCURSIF - Exercice 12
     *
     * @param unPolar Polar courant
     * @param annee   année de référence
     * @return nombre de livres de annee dans la liste de Cellules dont la tête est unPolar
     */
    public static int nbLivresAnneeRecWorker(Cellule<Polar> unPolar, int annee) {
        int nbPolRef = 0;

        while(unPolar != null){
            if(unPolar.getInfo().getAnnee() == annee){
                nbPolRef++;
            }
            unPolar = unPolar.getCelluleSuivante();
        }

        return nbPolRef;
    }

    /**
     * FOURNIE
     *
     * @param lesPolars liste chaînée utilisée
     * @param annee     année de référence
     * @return nombre de livres référencés pour annee
     */
    public static int nbLivresAnneeRec(ListeChaineeTriee<Polar> lesPolars, int annee) {
        // { } => { résultat = nombre de livres référencés pour annee }

        return nbLivresAnneeRecWorker(lesPolars.getTete(), annee);
    }

    /**
     * A ECRIRE - Exercice 13
     *
     * @param lesPolars liste chaînée utilisée
     * @param auteur    auteur de référence
     * @return nombre de livres référencés pour auteur
     */
    public static int nbLivresAuteurIter(ListeChaineeTriee<Polar> lesPolars, String auteur) {
        // { lesPolars non vide, triée selon l'ORDRE(auteur, annee) } =>
        // { résultat = nombre de livres référencés pour auteur}
        // NOTE : veiller à minimiser le nombre de comparaisons

        Cellule<Polar> cellCour = lesPolars.getTete();
        int nbPolRef = 0;

        while(cellCour != null){
            if(cellCour.getInfo().getAuteur().compareTo(auteur) == 0){
                nbPolRef++;
            }
            cellCour = cellCour.getCelluleSuivante();
        }

        return nbPolRef;
    }

    /**
     * A ECRIRE - Exercice 14
     *
     * @param lesPolars liste chaîneée de référence
     */
    public static void afficheNbLivresAuteurs(ListeChaineeTriee<Polar> lesPolars) {
        // { lesPolars non vide, triée selon l'ORDRE(auteur, annee) } =>
        // { le nombre de livres référencés pour chaque auteur a été affiché }
        // NOTE : il ne faut pas utiliser la fonction nbLivresAuteurIter()

        Cellule<Polar> cellCour = lesPolars.getTete();
        int nbPolRef = 0;

        while(cellCour != null){
            if(cellCour.getInfo().getAuteur().compareTo(cellCour.getCelluleSuivante().getInfo().getAuteur()) == 0){
                nbPolRef++;
            }

            cellCour = cellCour.getCelluleSuivante();
            System.out.println(cellCour.getInfo().getAuteur() + nbPolRef);
        }



    }

}
