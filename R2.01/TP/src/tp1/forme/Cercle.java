package tp1.forme;

public class Cercle {
    private int rayon;
    private Point centre;

    public Cercle(int monRayon){
        setRayon(monRayon);
    }

    public Cercle(int monRayon, Point centre){
        setRayon(monRayon);
        this.centre = centre;
    }

    /**
     * Met le rayon d'un cercle à la valeur du rayon passée en paramètre
     * @param nouveauRayon
     */

    public void setRayon(int nouveauRayon) {
        this.rayon = nouveauRayon;
    }

    /**
     * Renvoie le rayon d'un Cercle
     * @return rayon
     */

    public int getRayon(){
        return rayon;
    }

    /**
     * Renvoie le centre d'un Cercle
     * @return centre
     */

    public Point getCentre(){
        return centre;
    }

    /**
     * Renvoie le périmétre d'un Cercle
     * @return 2*Math.PI*rayon
     */

    public double getPerimetre(){
        return 2*Math.PI*rayon;
    }

    /**
     * Renvoie l'aire d'un Cercle
     * @return Math.PI*rayon*rayon
     */

    public double getAire(){
        return Math.PI*rayon*rayon;
    }

    /**
     * Déplace le centre du Cercle de dX horizontalement et dY verticalement
     * @param dX
     * @param dY
     */

    public void deplaceCentre(int dX, int dY){
        getCentre().deplaceXY(dX,dY);
    }

}
