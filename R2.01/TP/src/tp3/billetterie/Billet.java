package tp3.billetterie;

public class Billet {
    private double prixAuKm;
    private Trajet trajet;
    public Billet(Trajet trajet, double prixAuKm){
        this.trajet = trajet;
        setPrixAuKm(prixAuKm);
    }

    /**
     * Renvoie le départ du trajet d'un Billet
     * @return trajet.getDepart();
     */

    public String getDepart(){
        return trajet.getDepart();
    }

    /**
     * Renvoie l'arrivee du trajet d'un Billet
     * @return trajet.getArrivee();
     */

    public String getArrivee(){
        return trajet.getArrivee();
    }

    /**
     * Renvoie le distance du trajet d'un Billet
     * @return trajet.getDistance();
     */

    public int getDistance(){
        return trajet.getDistance();
    }

    /**
     * Renvoie le prix d'un Billet avec le prixAuKm compris entre 0.1 et 2
     * @return prixAuKm*getDistance()
     */

    public double getPrixAuKm() {
        if(prixAuKm < 0.1){
            return 0.1*getDistance();
        }else if(prixAuKm > 2){
            return 2*getDistance();
        }else{
            return prixAuKm*getDistance();
        }

    }

    /**
     * Met le prix d'un Billet au prix passé en paramètre
     * @param prixAuKm
     */

    public void setPrixAuKm(double prixAuKm) {
        this.prixAuKm = prixAuKm;
    }

    /**
     * Renvoie l'affichage d'un Billet
     * @return this.getClass().getSimpleName() + " : [" + trajet.toString() + "], prix : " +
     *                 BilletUtilitaire.arrondir(getPrixAuKm()) + " euros"
     */

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " : [" + trajet.toString() + "], prix : " +
                BilletUtilitaire.arrondir(getPrixAuKm()) + " euros";
    }


}