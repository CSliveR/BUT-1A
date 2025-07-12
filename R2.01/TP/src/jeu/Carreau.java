package jeu;

import java.util.ArrayList;

/**
 * Un Carreau est représenté par une liste de guerriers bleus et une liste de guerriers rouges.
 * Une liste de Carreaux compose le plateau de jeu.
 */

public class Carreau {
    private ArrayList<Guerrier> GuerriersBleus = new ArrayList<>();
    private ArrayList<Guerrier> GuerriersRouges = new ArrayList<>();

    /**
     * Constructeur d'un Carreau.
     */
    public Carreau(){}

    /**
     * Renvoie une liste de guerriers bleus située sur un Carreau.
     * @return GuerriersBleus
     */

    public ArrayList<Guerrier> getGuerriersBleus(){
        return GuerriersBleus;
    }

    /**
     * Renvoie une liste de Guerriers rouges située sur un Carreau.
     * @return GuerriersRouges
     */

    public ArrayList<Guerrier> getGuerriersRouges(){
        return GuerriersRouges;
    }

    /**
     * Ajoute la liste complète de guerriers bleus passée en paramètre à la liste de guerriers bleus située sur un Carreau.
     * @param guerriers
     */

    public void ajoutGuerriersBleus(ArrayList<Guerrier> guerriers){
        GuerriersBleus.addAll(guerriers);
    }

    /**
     * Ajoute la liste complète de guerriers rouges passée en paramètre à la liste de guerriers rouges située sur un Carreau.
     * @param guerriers
     */

    public void ajoutGuerriersRouges(ArrayList<Guerrier> guerriers){
        GuerriersRouges.addAll(guerriers);
    }

    /**
     * Retire tous les guerriers bleus présents sur un Carreau et renvoie la liste de guerriers bleus.
     * @return GuerriersBleus
     */

    public ArrayList<Guerrier> retirerGuerriersBleus(){
        GuerriersBleus.removeAll(GuerriersBleus);
        return GuerriersBleus;
    }

    /**
     * Retire tous les guerriers rouges présents sur un Carreau et renvoie la liste de guerriers rouges.
     * @return GuerriersBleus
     */

    public ArrayList<Guerrier> retirerGuerriersRouges(){
        GuerriersRouges.removeAll(GuerriersRouges);
        return GuerriersRouges;
    }

    /**
     * Supprime un guerrier bleu d'une liste de guerriers bleus ou supprime un guerrier rouge d'une liste de guerriers rouges.
     * @param guerrier
     */

    public void supprimerGuerrier(Guerrier guerrier){
        GuerriersBleus.remove(guerrier);
        GuerriersRouges.remove(guerrier);
    }

    @Override
    public String toString(){
        return getGuerriersBleus().toString() +  getGuerriersRouges().toString();
    }

}
