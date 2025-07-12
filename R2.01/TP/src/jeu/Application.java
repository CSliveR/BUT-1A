package jeu;

/**
 *Cette classe instancie et exécute le jeu.
 */

public class Application {
    private static final Chateau chateauBleu = new Chateau(Couleur.BLEU);
    private static final Chateau chateauRouge  = new Chateau(Couleur.ROUGE);
    public static void init(){
        Nain nain = new Nain();
        Nain nain2 = new Nain();
        Elfe elfe = new Elfe();
        Elfe elfe2 = new Elfe();
        ChefNain cNain = new ChefNain();
        ChefElfe cElfe = new ChefElfe();

        chateauBleu.ajoutGuerrierNovice(nain);
        nain.setChateau(chateauBleu);
        chateauBleu.ajoutGuerrierNovice(elfe);
        elfe.setChateau(chateauBleu);
        chateauBleu.ajoutGuerrierNovice(cElfe);
        cElfe.setChateau(chateauBleu);

        chateauRouge.ajoutGuerrierNovice(nain2);
        nain2.setChateau(chateauRouge);
        chateauRouge.ajoutGuerrierNovice(elfe2);
        elfe2.setChateau(chateauRouge);
        chateauRouge.ajoutGuerrierNovice(cNain);
        cNain.setChateau(chateauRouge);

        System.out.println("------------------------------");
        System.out.println("ORDRE D'ENTRAINEMENT DES GUERRIERS : " + chateauBleu.getClass().getSimpleName() + " " + chateauBleu.getCouleur());
        ChateauUtilitaire.OrdreEntrainement(chateauBleu);
        System.out.println("------------------------------");
        System.out.println("ORDRE D'ENTRAINEMENT DES GUERRIERS : " + chateauRouge.getClass().getSimpleName() + " " + chateauRouge.getCouleur());
        ChateauUtilitaire.OrdreEntrainement(chateauRouge);
        System.out.println("------------------------------");
    }

    public static void jeu(){
        Plateau plateau = new Plateau(5);
        plateau.ajoutGuerriers(chateauBleu,chateauBleu.entrainer());
        plateau.ajoutGuerriers(chateauRouge,chateauRouge.entrainer());
        PlateauUtilitaire.affichePlateau(plateau);


        plateau.deplaceGuerriers();
        plateau.lanceCombat();
        plateau.deplaceGuerriers();
        PlateauUtilitaire.afficheEquipeGagnante(plateau);

        //J'ai essayé d'augmenter les ressources des châteaux à chaque tour mais je n'y suis pas arrivé.

    }

    public static void main(String[] args) {
        init();
        jeu();
    }
}
