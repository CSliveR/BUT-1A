package jeu;

import java.util.ArrayList;

/**
 *La classe Chateau représente les châteaux des camps rouge et bleu. Un château possède une liste de guerriers novices et entraine des
 * guerriers situés dans une liste de guerriers et renvoyée par la méthode entrainer().
 */

public class Chateau {
    private final int RESSOURCESINITIALES = 3;
    private final int RESSOURCEAJOUTEEPARTOUR = 1;
    private int ressources;
    private ArrayList<Guerrier> GuerriersNovices = new ArrayList<>();
    private Couleur couleur;
    private Plateau plateau = new Plateau(5);

    /**
     * Constructeur d'un chateau avec une couleur et des ressources initialisées à RESSOURCESINITIALES = 3.
     * @param couleur
     */

    public Chateau(Couleur couleur){
        this.couleur = couleur;
        this.ressources = RESSOURCESINITIALES;
        //incrementeRessources(); //essai pour incrémenter les ressources à chaque tour.
    }

    /**
     * Ajoute un guerrier dans le Chateau.
     * @param guerrier
     */

    public void ajoutGuerrierNovice(Guerrier guerrier){
        GuerriersNovices.add(guerrier);
    }

    /**
     * Renvoie une liste de guerriers dans un Chateau.
     * @return GuerriersNovices
     */

    public ArrayList<Guerrier> getGuerrierNovices(){
        return GuerriersNovices;
    }

    /**
     * Renvoie une liste de guerriers entrainés. Un guerrier est entrainé s'il y a suffisamment de ressources disponibles
     * dans le Chateau pour son entrainement. Cet entrainement consomme des ressources.
     * @return GuerriersEntraines
     */

    public ArrayList<Guerrier> entrainer(){
        ArrayList<Guerrier> GuerriersEntraines = new ArrayList<>();
        ressources = RESSOURCESINITIALES;

        for(int i=0; i < GuerriersNovices.size();i++){
            if(ressources >= GuerriersNovices.get(i).getRessourcesPourEntrainement()){
                GuerriersEntraines.add(this.GuerriersNovices.get(i));
            }

            ressources = ressources - GuerriersNovices.get(i).getRessourcesPourEntrainement();

            if(ressources < 0){
                ressources = 0;
            }
        }
        return GuerriersEntraines;
    }

    /**
     * Incrémente les ressources du Chateau à la fin de chaque tour de jeu.
     */

    private void incrementeRessources(){
        for(int i=0; i < plateau.getTour(); i++){
            ressources = ressources + RESSOURCEAJOUTEEPARTOUR;
        }
        //Je n'ai pas trouvé comment utilisé cette méthode.
    }

    /**
     * Renvoie la couleur du Chateau.
     * @return this.couleur
     */

    public Couleur getCouleur(){
        return this.couleur;
    }

    /**
     * Renvoie vrai si le Chateau est bleu, faux sinon.
     * @return getCouleur() == Couleur.BLEU;
     */

    public boolean estBleu(){
        return getCouleur() == Couleur.BLEU;
    }

    /***
     * Renvoie vrai si le Chateau est rouge, faux sinon.
     * @return getCouleur() == Couleur.ROUGE;
     */
    public boolean estRouge(){
        return getCouleur() == Couleur.ROUGE;
    }
}
