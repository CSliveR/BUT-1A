package jeu;

/**
 * La classe Guerrier est une classe abstraite qui implémente les 4 types de Guerrier du jeu.
 * A savoir les classes Nain, Elfe, ChefNain et ChefElfe.
 */

public abstract class Guerrier {
    private final int FORCEBASE = 10;
    private final int PVMAXBASE = 100;
    private final int RESSOURCEBASE = 1;
    private int pointsDeVie = 100;
    private Chateau chateau;
    public Guerrier(){}

    /**
     * Renvoie la force d'un Guerrier
     * @return FORCEBASE
     */

    public int getForce() {
        return FORCEBASE;
    }

    /**
     * Renvoie les points de vie d'un Guerrier
     * @return pointsDeVie
     */

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    /**
     * Renvoie le nombre de ressources nécessaires pour entrainer un Guerrier
     * @return RESSOURCESBASE | RESSOURCESBASE*2 | RESSOURCESBASE*3 | RESSOURCESBASE*4
     */

    public int getRessourcesPourEntrainement(){
        if(this.getClass() == Elfe.class){
            return RESSOURCEBASE*2;
        }else if (this.getClass() == ChefNain.class){
            return RESSOURCEBASE*3;
        }else if(this.getClass() == ChefElfe.class){
            return RESSOURCEBASE*4;
        }else{
            return RESSOURCEBASE;
        }
    }

    public Couleur getCouleur(){
        return chateau.getCouleur();
    }

    /**
     * Met les points de vie d'un Guerrier à la valeur passée en paramètre
     * @param pointDeVie
     */

    public void setPointDeVie(int pointDeVie) {
        this.pointsDeVie = pointDeVie;
    }

    /**
     * Met un Guerrier dans le chateau passé en paramètre
     * @param chateau
     */

    public void setChateau(Chateau chateau) {
        this.chateau = chateau;
    }

    /**
     * Renvoie vrai si le Guerrier a encore des points de vie, faux sinon
     * @return this.pointsDeVie > 0
     */

    public boolean estVivant(){
        return this.pointsDeVie > 0;
    }

    public boolean estBleu(){
        return chateau.estBleu();
    }

    public boolean estRouge(){
        return chateau.estRouge();
    }

    /**
     * Cette méthode permet d'attaquer le Guerrier passé en paramètre en lui retirant des points de vie à hauteur de la somme de lancers
     * de dés aléatoires entre 1 et 3. Le nombre de dés lancés correspond à la force du Guerrier qui attaque
     * @param g
     */

    public void attaquer(Guerrier g){
        g.pointsDeVie = g.pointsDeVie - GuerrierUtilitaire.de3(getForce());
        if(g.pointsDeVie < 0){
            g.pointsDeVie = 0;
        }
    }

    /**
     * Méthode abstraite implémentée dans les classes filles de Guerrier: Elfe, Nain, ChefElfe, ChefNain
     * @param degats
     */

    protected abstract void subirDegats(int degats);
    @Override
    public String toString(){
        return this.getClass().getSimpleName();
    }

}
