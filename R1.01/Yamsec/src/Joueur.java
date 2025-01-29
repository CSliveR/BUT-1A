public class Joueur implements Comparable<Joueur>{
    // attributs
    private String surnom; // surnom du joueur
    private int nbPoints; // nombre de points réalisés par le joueur
    private int nbYams; // nombre de YAMs réalisés par le joueur

    // constructeur - À COMPLÉTER ...

    public Joueur(String surnom, int nbPoints, int nbYams){
        this.surnom = surnom;
        this.nbPoints = nbPoints;
        this.nbYams = nbYams;
    }

    // getters - À COMPLÉTER ...

    String getSurnom(){return surnom;}

    int getNbPoints(){return nbPoints;}

    int getNbYams(){return nbYams;}

    // méthodes de mise à jour des attributs nbPoints et nbYams
    // mise  à jour de nbPoints - À COMPLÉTER ...
    public void ajoutPoints(int desPoints) {
        // { } => { desPoints a été ajouté à nbPoints }
       nbPoints = nbPoints + desPoints;
    }
    // mise à jour de nbYams - À COMPLÉTER ...
    public void ajoutYam() {
        // { } => { nbYams a été incrémenté }
        nbYams++;
    }
    @Override
    // ordre naturel (nbPoints, nbYams) - À COMPLÉTER ...
    public int compareTo(Joueur o) {
        if(this.nbPoints < o.nbPoints){
            return -1;
        }else if((this.nbPoints == o.nbPoints) && (this.nbYams > o.nbYams)){
            return 0;
        }else{
            return 1;
        }
    }
    // chaîne représentant ce joueur
    public String toString() {
        return surnom + " : " + nbPoints + " point(s) / " + nbYams + " yam(s)";
    }
}
