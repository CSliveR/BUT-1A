package jeu;

/**
 * Classe qui représente le type énuméré Couleur. Cette classe définit les couleurs rouge et bleu qui représentent les couleurs des
 * deux camps (deux châteaux) qui s'affrontent.
 */

public enum Couleur {
    ROUGE("rouge"),
    BLEU("bleu");

    private String nomCouleur;

    Couleur(String nomCouleur){
        this.nomCouleur = nomCouleur;
    }

    @Override
    public String toString() {
        return nomCouleur;
    }
}
