package jeu;

/**
 * Classe qui permet de regrouper des méthodes relatives à tous types de guerriers
 * Elle dispose, entre autres, de méthodes d'affichage des guerriers.
 */
public class GuerrierUtilitaire {
    // METHODES D'AFFICHAGE
    /**
     * Affiche le type d'un guerrier: Nain | Elfe | ChefNain | ChefElfe.
     * @param unite
     */
    public static void printUnite(Guerrier unite) {
        System.out.println(unite.getClass().getSimpleName());
    }

    /**
     * Affiche le type d'un guerrier: Nain | Elfe | ChefNain | ChefElfe avec ses points de vie.
     * @param unite
     */

    public static void printPVUnite(Guerrier unite) {
        System.out.print(" [PV: " + unite.getPointsDeVie() + "]");
        printUnite(unite);
    }

    /**
     * Affiche le type d'un guerrier avec sa couleur :
     * Nain_bleu|Nain_rouge | Elfe_bleu|Elfe_rouge | ChefNain_bleu|ChefNain_rouge | ChefElfe_bleu|ChefElfe_rouge.
     * @param unite
     */

    public static void printUniteAvecCouleur(Guerrier unite) {
        System.out.print(unite.getClass().getSimpleName() + "_" + unite.getCouleur());
    }

    /**
     * Affiche le type d'un guerrier avec sa couleur et ses points de vie :
     * Nain_bleu|Nain_rouge | Elfe_bleu|Elfe_rouge | ChefNain_bleu|ChefNain_rouge | ChefElfe_bleu|ChefElfe_rouge.
     * @param unite
     */

    public static void printPVUniteAvecCouleur(Guerrier unite) {
        printUniteAvecCouleur(unite);
        System.out.print(" [PV = " + unite.getPointsDeVie() + "]");
    }

    public static void printCombat(Guerrier g1, Guerrier g2){
        printPVUniteAvecCouleur(g1);
        System.out.print(" tape ");
        printPVUniteAvecCouleur(g2);
        System.out.print(" => ");
        g2.subirDegats(de3(g1.getForce()));
        printPVUniteAvecCouleur(g2);
        System.out.println();
    }

    /**
     * Renvoie un nombre aléatoire dans l'intervalle [1;3]
     * @return (int) (Math.random()*3)+1
     */

    public static int de3(){
        return (int) (Math.random()*3)+1;
    }

    /**
     * Renvoie la somme de nombreLance nombres renvoyés par de3().
     * @param nombreLance
     * @return somme
     */
    public static int de3(int nombreLance){
        int somme = 0;

        for(int i=0; i < nombreLance;i++){
            somme+=de3();
        }
        System.out.print("dégats de l'attaque: " + somme);
        return somme;
    }
}
