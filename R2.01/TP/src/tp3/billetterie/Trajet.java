package tp3.billetterie;

public class Trajet {
    private String depart;
    private String arrivee;
    private int distance;

    public Trajet(String depart, String arrivee, int distance){
        setDepart(depart);
        setArrivee(arrivee);
        setDistance(distance);
    }

    /**
     * Renvoie la ville de départ d'un Trajet en majuscule
     * @return depart.toUpperCase()
     */
    public String getDepart() {
        return depart.toUpperCase();
    }

    /**
     * Renvoie la ville d'arrivée d'un Trajet en majuscule
     * @return depart.toUpperCase()
     */

    public String getArrivee() {
        return arrivee.toUpperCase();
    }

    /**
     * Retourne la distance d'un Trajet comprise entre 5 et 2000
     * @return distance
     */

    public int getDistance() {
        if(distance < 5){
            return 5;
        }else if(distance > 2000){
            return 2000;
        }else{
            return distance;
        }
    }

    /**
     * Met le départ d'un Trajet au départ passé en paramètre
     * @param depart
     */

    public void setDepart(String depart) {
        this.depart = depart;
    }

    /**
     * Met l'arrivée d'un Trajet à l'arrivée passée en paramètre
     * @param arrivee
     */

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    /**
     * Met la distance d'un Trajet à la distance passée en paramètre
     * @param distance
     */

    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Renvoie l'affichage d'un Trajet
     * @return this.getClass().getSimpleName() + " : " + getDepart() + " -> " + arrivee + " (" + getDistance() + " km)"
     */

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + " : " + getDepart() + " -> " + arrivee + " (" + getDistance() + " km)";
    }
}
