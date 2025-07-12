package jeu;

/**
 * Classe de test de l'étape 2. Tous les combats entre les différents guerriers sont testés.
 * A la fin des attaques d'un guerrier sur les autres, les points de vie de ces autres guerriers sont restaurés pour les attaques suivantes.
 */

public class TestEtape2 {
    public static void main(String[] args) {
        // A COMPLETER : Création d'un objet nain de type Nain puis afficher les caractéristiques du guerrier crée
        Nain nain = new Nain();
        System.out.println(nain.getClass().getSimpleName() + " : Force = "  + nain.getForce() +  ", PV = " + nain.getPointsDeVie() + ", Ressources pour entrainement = " + nain.getRessourcesPourEntrainement());

        // A COMPLETER : Création d'un objet elfe de type Elfe puis afficher les caractéristiques du guerrier crée
        Elfe elfe = new Elfe();
        System.out.println(elfe.getClass().getSimpleName() + " : Force = "  + elfe.getForce() +  ", PV = " + elfe.getPointsDeVie() + ", Ressources pour entrainement = " + elfe.getRessourcesPourEntrainement());

        // A COMPLETER : Création d'un objet chefNain de type ChefNain puis afficher les caractéristiques du guerrier crée
        ChefNain cNain = new ChefNain();
        System.out.println(cNain.getClass().getSimpleName() + " : Force = "  + cNain.getForce() +  ", PV = " + cNain.getPointsDeVie() + ", Ressources pour entrainement = " + cNain.getRessourcesPourEntrainement());


        // A COMPLETER : Création d'un objet chefElfe de type ChefElfe puis afficher les caractéristiques du guerrier crée
        ChefElfe cElfe = new ChefElfe();
        System.out.println(cElfe.getClass().getSimpleName() + " : Force = "  + cElfe.getForce() +  ", PV = " + cElfe.getPointsDeVie() + ", Ressources pour entrainement = " + cElfe.getRessourcesPourEntrainement());

        Nain autreNain = new Nain();
        Elfe autreElfe = new Elfe();
        ChefNain autreCnain = new ChefNain();
        ChefElfe autreCelfe = new ChefElfe();

        //Tous les affrontements possibles
        System.out.println("-----------------");
        System.out.println("Nain tape un Elfe");
        elfe.subirDegats(GuerrierUtilitaire.de3(nain.getForce()));
        GuerrierUtilitaire.printPVUnite(elfe);
        System.out.println("-----------------");
        System.out.println("Nain tape un ChefNain");
        cNain.subirDegats(GuerrierUtilitaire.de3(nain.getForce()));
        GuerrierUtilitaire.printPVUnite(cNain);
        System.out.println("-----------------");
        System.out.println("Nain tape un ChefElfe");
        cElfe.subirDegats(GuerrierUtilitaire.de3(nain.getForce()));
        GuerrierUtilitaire.printPVUnite(cElfe);
        System.out.println("-----------------");
        System.out.println("Nain tape un autreNain");
        autreNain.subirDegats(GuerrierUtilitaire.de3(nain.getForce()));
        GuerrierUtilitaire.printPVUnite(autreNain);

        elfe.setPointDeVie(100);
        cNain.setPointDeVie(100);
        cElfe.setPointDeVie(100);

        System.out.println("-----------------");
        System.out.println("PV nain = " + nain.getPointsDeVie());
        System.out.println("Elfe tape un Nain");
        nain.subirDegats(GuerrierUtilitaire.de3(elfe.getForce()));
        GuerrierUtilitaire.printPVUnite(nain);
        System.out.println("------------------");
        System.out.println("Elfe tape un ChefNain");
        cNain.subirDegats(GuerrierUtilitaire.de3(elfe.getForce()));
        GuerrierUtilitaire.printPVUnite(cNain);
        System.out.println("------------------");
        System.out.println("Elfe tape un ChefElfe");
        cElfe.subirDegats(GuerrierUtilitaire.de3(elfe.getForce()));
        GuerrierUtilitaire.printPVUnite(cElfe);
        System.out.println("-----------------");
        System.out.println("Elfe tape un autreElfe");
        autreElfe.subirDegats(GuerrierUtilitaire.de3(elfe.getForce()));
        GuerrierUtilitaire.printPVUnite(autreElfe);

        nain.setPointDeVie(100);
        cNain.setPointDeVie(100);
        cElfe.setPointDeVie(100);

        System.out.println("-----------------");
        System.out.println("ChefNain tape un Nain");
        nain.subirDegats(GuerrierUtilitaire.de3(cNain.getForce()));
        GuerrierUtilitaire.printPVUnite(nain);
        System.out.println("------------------");
        System.out.println("ChefNain tape un Elfe");
        elfe.subirDegats(GuerrierUtilitaire.de3(cNain.getForce()));
        GuerrierUtilitaire.printPVUnite(elfe);
        System.out.println("------------------");
        System.out.println("ChefNain tape un ChefElfe");
        cElfe.subirDegats(GuerrierUtilitaire.de3(cNain.getForce()));
        GuerrierUtilitaire.printPVUnite(cElfe);
        System.out.println("------------------");
        System.out.println("ChefNain tape un autreChefNain");
        autreCnain.subirDegats(GuerrierUtilitaire.de3(cNain.getForce()));
        GuerrierUtilitaire.printPVUnite(autreCnain);

        nain.setPointDeVie(100);
        elfe.setPointDeVie(100);
        cElfe.setPointDeVie(100);

        System.out.println("-----------------");
        System.out.println("ChefElfe tape un Nain");
        nain.subirDegats(GuerrierUtilitaire.de3(cElfe.getForce()));
        GuerrierUtilitaire.printPVUnite(nain);
        System.out.println("------------------");
        System.out.println("ChefElfe tape un Elfe");
        elfe.subirDegats(GuerrierUtilitaire.de3(cElfe.getForce()));
        GuerrierUtilitaire.printPVUnite(elfe);
        System.out.println("------------------");
        System.out.println("ChefElfe tape un ChefNain");
        cNain.subirDegats(GuerrierUtilitaire.de3(cElfe.getForce()));
        GuerrierUtilitaire.printPVUnite(cNain);
        System.out.println("------------------");
        System.out.println("ChefElfe tape un autreChefElfe");
        autreCelfe.subirDegats(GuerrierUtilitaire.de3(cElfe.getForce()));
        GuerrierUtilitaire.printPVUnite(autreCelfe);

        nain.setPointDeVie(100);
        cElfe.setPointDeVie(100);

        // Simuler un combat (itération attaque/dégat entre deux guerriers jusqu'à la mort de l'un d'eux)
        System.out.println("------------------");
        System.out.println("Combat à mort entre un nain et un ChefElfe");
        while(nain.estVivant() && cElfe.estVivant()){
            System.out.println("Nain tape le ChefElfe");
            cElfe.subirDegats(GuerrierUtilitaire.de3(nain.getForce()));
            GuerrierUtilitaire.printPVUnite(cElfe);
            System.out.println("ChefElfe tape le Nain");
            nain.subirDegats(GuerrierUtilitaire.de3(cElfe.getForce()));
            GuerrierUtilitaire.printPVUnite(nain);
        }
    }
}

