package tp3.billetterie;

public class BilletReduit extends Billet{
    private double tauxDeReduction;

    public BilletReduit(Trajet trajet, double prixAuKm, double tauxDeReduction){
        super(trajet, prixAuKm);
        setTauxDeReduction(tauxDeReduction);
    }

    /**
     * Renvoie le taux de réduction d'un BilletReduit
     * @return tauxDeReduction
     */

    public double getTauxDeReduction() {
        return tauxDeReduction;
    }

    /**
     * Renvoie le prix d'un BilletReduit arrondi à 2 décimales
     * @return BilletUtilitaire.arrondir(super.getPrixAuKm());
     */

    public double getPrix(){
        return BilletUtilitaire.arrondir(super.getPrixAuKm());
    }

    /**
     * Met le tauxDeReduction d'un BilletReduit à la valeur passée en paramètre
     * @param tauxDeReduction
     */

    public void setTauxDeReduction(double tauxDeReduction) {
        this.tauxDeReduction = tauxDeReduction;
    }

    /**
     * Renvoie l'affichage d'un BilletReduit
     * @return super.toString() + " prix : " + BilletUtilitaire.arrondir(getPrix()*(1-getTauxDeReduction())) +
     *                 " euros, avec une réduction de " + getTauxDeReduction()*100 + "% "
     */

    @Override
    public String toString(){
        return super.toString() + " prix : " + BilletUtilitaire.arrondir(getPrix()*(1-getTauxDeReduction())) +
                " euros, avec une réduction de " + getTauxDeReduction()*100 + "% ";

    }
}
