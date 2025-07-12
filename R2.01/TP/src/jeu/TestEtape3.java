package jeu;

/**
 * Classe de test des méthodes relatives à l'étape 3 jusqu'à l'étape 5.
 * Cette classe peut être vue comme une ébauche de la classe Application.
 */

public class TestEtape3 {
    public static void main(String[] args) {
        Chateau chateauBleu = new Chateau(Couleur.BLEU);
        Chateau chateauRouge = new Chateau(Couleur.ROUGE);

        Nain nain = new Nain();
        Nain nain2 = new Nain();

        Elfe elfe = new Elfe();
        Elfe elfe2 = new Elfe();

        ChefNain cNain = new ChefNain();
        ChefElfe cElfe = new ChefElfe();

        // étape 3 : tester les méthodes de bases

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

        System.out.println("Chateau bleu : " + chateauBleu.getGuerrierNovices());
        System.out.println("Chateau rouge : " + chateauRouge.getGuerrierNovices());

        System.out.println("Guerriers bleus entrainés : " + chateauBleu.entrainer());
        System.out.println("Guerriers rouges entrainés : " + chateauRouge.entrainer());
        System.out.println("-----------------------------------");

//        System.out.println(nain.getRessourcesPourEntrainement());
//        System.out.println(elfe.getRessourcesPourEntrainement());
//        System.out.println(cNain.getRessourcesPourEntrainement());


        // étape 5 : tester les déplacements

        ///// TEST BLEU
        //Création d'un plateau de jeu de taille 5
        Plateau plateauS = new Plateau(5);

        // Ajouter un guerrier bleu
        plateauS.ajoutGuerriers(chateauBleu,chateauBleu.entrainer());
        PlateauUtilitaire.affichePlateau(plateauS);


      //Réaliser une itération pour simuler plusieurs déplacements jusqu'au camp opposé
        System.out.println("Déplacement des guerriers bleus");
        plateauS.deplaceGuerriers();
        PlateauUtilitaire.affichePlateau(plateauS);
        System.out.println("-----------------------------------");

        ///// TEST ROUGE
       //Création d'un plateau de jeu de taille 10
        Plateau plateauM = new Plateau(10);

        // Ajouter un guerrier rouge
        plateauM.ajoutGuerriers(chateauRouge,chateauRouge.entrainer());
        PlateauUtilitaire.affichePlateau(plateauM);

        // Réaliser une itération pour simuler plusieurs déplacements jusqu'au camp opposé
        System.out.println("Déplacement des guerriers rouges");
        plateauM.deplaceGuerriers();
        PlateauUtilitaire.affichePlateau(plateauM);
        System.out.println("-------------------------------------------------------");

        // Création d'un plateau de jeu de taille 5
        Plateau plateauS2 = new Plateau(5);

        // Ajouter un guerrier bleu et un guerrier rouge.
        plateauS2.ajoutGuerriers(chateauBleu,chateauBleu.entrainer());
        plateauS2.ajoutGuerriers(chateauRouge,chateauRouge.entrainer());
        PlateauUtilitaire.affichePlateau(plateauS2);

        // Simulation de plusieurs déplacements jusqu'à la rencontre des deux guerriers.
        plateauS2.deplaceGuerriers();
        //Le combat se déroule
        plateauS2.lanceCombat();
        //Le combat est terminé et on rappelle deplaceGuerriers() pour déplacer les guerriers gagnants jusqu'au camp adverse.
        plateauS2.deplaceGuerriers();

        //Quand la partie est terminée, on affiche l'équipe gagnante.
        if(plateauS2.estPartieTerminee()){
            PlateauUtilitaire.afficheEquipeGagnante(plateauS2);
        }
    }
}
