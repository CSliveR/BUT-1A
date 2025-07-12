package jeu;

import java.util.ArrayList;

/**
 * Un plateau représente l'espace où a lieu une partie. Il est composé d'une liste de carreaux, ces carreaux sont eux-mêmes composés
 * d'une liste de guerriers bleus et d'une liste de guerriers rouges. Les déplacements des guerriers de chaque camp sont gérés par la
 * méthode deplaceGuerrier() et le déroulé d'un combat dans le cas où les guerriers des 2 camps sont sur le même carreau est géré par
 * la méthode lanceCombat(). Les autres méthodes permettent de conclure la partie avec estPartieTerminee() et estGagnant() qui donne
 * le camp qui a gagné la partie.
 * Sur un carreau du Plateau, les guerriers bleus se situent à gauche et les guerriers rouges se situent à droite.
 */

public class Plateau {
    private static int tour = 1;
    private ArrayList<Carreau> carreaux = new ArrayList<>();
    /**
     * Constructeur d'un plateau composé de carreaux ayant un nombre de carreaux égal à lo longueur passée en paramètre.
     * @param longueur
     */
    public Plateau(int longueur) {
        for (int i = 0; i < longueur; i++) {
            carreaux.add(new Carreau());
        }
    }

    /**
     * Renvoie le numéro du tour de jeu à un moment donné sur le Plateau
     * @return tour
     */
    public int getTour(){
        return tour;
    }

    /**
     * Ajoute une liste de guerriers du chateau bleu au début du Plateau.
     * Ajoute une liste de guerriers du chateau rouge à la fin du Plateau.git
     * @param chateau
     * @param guerriers
     */

    public void ajoutGuerriers(Chateau chateau, ArrayList<Guerrier> guerriers) {
        if (chateau.estBleu()) {
            carreaux.get(0).ajoutGuerriersBleus(guerriers);
        } else {
            carreaux.get(carreaux.size() - 1).ajoutGuerriersRouges(guerriers);
        }
    }

    /**
     * Cette méthode déplace les guerriers bleus de la gauche vers la droite et les guerriers rouges de la droite vers la gauche
     * jusqu'à leur rencontre.
     * Dans le cas où les guerriers bleus sont tous éliminés, les guerriers rouges avancent vers le camp bleu.
     * Dans le cas contraire, les guerriers bleus avancent vers le camp rouge.
     */

    public void deplaceGuerriers() {
        int i = 0;
        int j = carreaux.size() - 1;

        // Tant que les guerriers des 2 camps ne se croisent pas
        while (i < j) {
            if (!carreaux.get(i).getGuerriersBleus().isEmpty()) {
                carreaux.get(i + 1).ajoutGuerriersBleus(carreaux.get(i).getGuerriersBleus());
                carreaux.get(i).retirerGuerriersBleus();
            }
            if (!carreaux.get(j).getGuerriersRouges().isEmpty()) {
                carreaux.get(j - 1).ajoutGuerriersRouges(carreaux.get(j).getGuerriersRouges());
                carreaux.get(j).retirerGuerriersRouges();
                PlateauUtilitaire.affichePlateauAvecTour(this);
            }
            i++;
            j--;

            /*Instructions permettant de faire avancer les guerriers encore vivants après un combat jusqu'au camp adverse*/

            //Tous les guerriers bleus ont été éliminés et les guerriers rouges encore vivants se dirigent vers le camp bleu
            while(j > 0 && carreaux.get(i).getGuerriersBleus().isEmpty()){
                carreaux.get(j - 1).ajoutGuerriersRouges(carreaux.get(j).getGuerriersRouges());
                carreaux.get(j).retirerGuerriersRouges();
                j--;
                PlateauUtilitaire.affichePlateauAvecTour(this);
            }


            //Tous les guerriers rouges ont été éliminés et les guerriers bleus encore vivants se dirigent vers le camp rouge
            while(i < carreaux.size()-1 && carreaux.get(j).getGuerriersRouges().isEmpty()){
                carreaux.get(i + 1).ajoutGuerriersBleus(carreaux.get(i).getGuerriersBleus());
                carreaux.get(i).retirerGuerriersBleus();
                i++;
                PlateauUtilitaire.affichePlateauAvecTour(this);
            }

            tour++;
        }
    }

    /**
     *Cette méthode gère le déroulement d'un combat entre un guerrier bleu et un guerrier rouge:
     * Tous les guerriers bleus attaquent le premier guerrier rouge de la liste. Si le guerrier rouge meurt alors il est retiré de la
     * liste et s'il reste encore un ou plusieurs guerriers bleus, son attaque affectera le premier guerrier rouge encore vivant.
     * Quand tous les guerriers bleus ont attaqué une fois, c'est au tour des guerriers rouges d'attaquer de la même manière que les
     * guerriers bleus et ainsi de suite.
     * */

    public void lanceCombat() {
        int i=0;
        PlateauUtilitaire.affichePlateauAvecTour(this);
        tour++;

        while(i < carreaux.size() && carreaux.get(i).getGuerriersBleus().isEmpty()){
            i++;
            Carreau carreauCombat = carreaux.get(i); //Carreau où se passe le combat.

            int j = 0; //indice de parcours des guerriers bleus
            while(j < carreauCombat.getGuerriersBleus().size()){
                GuerrierUtilitaire.printCombat(carreauCombat.getGuerriersBleus().get(j),carreauCombat.getGuerriersRouges().get(0));
                if(!carreauCombat.getGuerriersRouges().get(0).estVivant()){
                    carreauCombat.supprimerGuerrier(carreauCombat.getGuerriersRouges().get(0));
                }
                j++;
            }

            int k = 0; //indice de parcours des guerriers rouges
            while(k < carreauCombat.getGuerriersRouges().size()){
                GuerrierUtilitaire.printCombat(carreauCombat.getGuerriersRouges().get(k),carreauCombat.getGuerriersBleus().get(0));
                if(!carreauCombat.getGuerriersBleus().get(0).estVivant()){
                    carreauCombat.supprimerGuerrier(carreauCombat.getGuerriersBleus().get(0));
                }
                k++;
            }
        }

        System.out.println("-----------------------------------------------------");

        while(!carreaux.get(i).getGuerriersBleus().isEmpty() && !carreaux.get(i).getGuerriersRouges().isEmpty()){
            lanceCombat();
        }
    }

    /**
     * Renvoie vrai si la partie est terminée, faux sinon
     * La partie est terminée si des guerriers rouges sont trouvés sur le premier carreau ou des guerriers bleus sont trouvés sur le
     * dernier carreau
     * @return !carreaux.get(0).getGuerriersRouges().isEmpty() || !carreaux.get(carreaux.size()-1).getGuerriersBleus().isEmpty()
     */

    public boolean estPartieTerminee() {
        return !carreaux.get(0).getGuerriersRouges().isEmpty() || !carreaux.get(carreaux.size()-1).getGuerriersBleus().isEmpty();
    }

    /**
     * Renvoie la couleur du camp qui a gagné la partie:
     * -Si des guerriers bleus atteignent le dernier carreay du Plateau alors les bleus ont gagné
     * -Si des guerriers rouges atteignent le premier carreau du Plateau alors les rouges ont gagné
     * @return couleur
     */

    public Couleur estGagnant() {
        Couleur couleur = Couleur.BLEU;
        if(!carreaux.get(0).getGuerriersRouges().isEmpty()){
            couleur = Couleur.ROUGE;
        }
        return couleur;
    }

    @Override
    public String toString() {
        return carreaux.toString();
    }
}