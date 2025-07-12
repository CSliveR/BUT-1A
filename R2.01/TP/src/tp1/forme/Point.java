package tp1.forme;

public class Point {
    private int x;
    private int y;
    public Point(){
        this(0,0);
    }

    public Point(int valX, int valY){
        setX(valX);
        setY(valY);
    }

    /**
     *Déplace la coordonnée x de dX verticalement et la coordonnnée y de dY horizontalement. Une coordonnée vaut 0 si sa valeur < 0
     * @param dX
     * @param dY
     */

    public void deplaceXY(int dX, int dY){
        if(x + dX < 0){
            this.x = 0;
        }else{
            this.x = x + dX;
        }

        if(y + dY < 0){
            this.y = 0;
        }else{
            this.y = y + dY;
        }


    }

    /**
     * Renvoie la coordonnée x du Point
     * @return x
     */

    public int getX() {
        return x;
    }

    /**
     * Renvoie la coordonnée y du Point
     * @return y
     */

    public int getY(){
        return y;
    }

    /**
     * Met la coordonnée x du Point à la valeur passée en paramètre, 0 si cette valeur est négative
     * @param valX
     */

    public void setX(int valX){
        if(valX < 0){
            this.x = 0;
        }else{
            this.x = valX;
        }
    }

    /**
     * Met la coordonnée y du Point à la valeur passée en paramètre, 0 si cette valeur est négative
     * @param valY
     */

    public void setY(int valY) {
        if(valY < 0){
            this.y = 0;
        }else{
            this.y = valY;
        }
    }
}
