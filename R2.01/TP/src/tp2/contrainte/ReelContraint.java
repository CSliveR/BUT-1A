package tp2.contrainte;

public class ReelContraint {
    private double min;
    private double max;
    private double valeur;
    public ReelContraint(double min, double max){
        this.min = min;
        this.max = max;
    }

    /**
     * Renvoie la valeur d'un ReelContraint
     * @return valeur
     */

    public double getValeur() {
        return valeur;
    }

    /**
     * Met la valeur à celle passée en paramètre. la valeur est égale à min si la valeur n'est pas entre min et max
     * @param valeur
     */

    public void setValeur(double valeur) {
        if(valeur < min || valeur > max){
            this.valeur = min;
        }else{
            this.valeur = valeur;
        }
    }

    /**
     * Renvoie l'affichage d'un ReelContraint
     * @return "valeur: " + valeur + ", "  + "min: " + min + ", " + "max: " + max
     */

    @Override
    public String toString() {
        return "valeur: " + valeur + ", "  + "min: " + min + ", " + "max: " + max;
    }
}
