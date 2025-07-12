package tp1.forme;

public class Rectangle {
    private int largueur;
    private int longueur;
    private Point origine;

    public Rectangle(int l, int L){
        setLargueur(l);
        setLongueur(L);
    }

    public Rectangle(int l, int L, int valX, int valY){
        setLargueur(l);
        setLongueur(L);
        this.origine = new Point(valX,valY); /*l'origine est un point construit par composition*/
    }

    /**
     * Met la largeur du Rectangle à la valeur passée en paramètre
     * @param l
     */

    public void setLargueur(int l) {
        this.largueur = l;
    }

    /**
     * Met la longueur du Rectangle à la valeur passée en paramètre
     * @param L
     */

    public void setLongueur(int L) {
        this.longueur = L;
    }

    /**
     * Renvoie la lorgeur du Rectangle
     * @return largeur
     */

    public int getLargueur(){
        return largueur;
    }

    /**
     * Renvoie la longueur du Rectangle
     * @return longueur
     */

    public int getLongueur() {
        return longueur;
    }

    /**
     * Renvoie un Point qui est l'origine d'un Rectangle
     * @return new Point(origine.getX(), origine.getY())
     */

    public Point getOrigine() {
        return new Point(origine.getX(), origine.getY());
    }

    /**
     * Renvoie le périmètre du Rectangle
     * @return (longueur+largueur)/2
     */

    public double getPerimetre(){
        return (longueur+largueur)*2;
    }

    /**
     * Renvoie l'aire du Rectangle
     * @return longueur*largeur
     */

    public double getAire(){
        return longueur*largueur;
    }

    /**
     * Déplace l'origine du Rectangle de dX horizontalement et dY verticalement
     * @param dX
     * @param dY
     */

    public void deplaceOrigine(int dX, int dY){
        getOrigine().deplaceXY(dX,dY);
    }

}
