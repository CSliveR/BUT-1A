package tp1.forme;

public class FormeUtilitaire {
    public static void affichePoint(Point p){
        System.out.println("Point : x=" + p.getX() + ", y=" + p.getY());
    }

    public static void afficheCercle(Cercle c){
        System.out.println("Cercle : R=" + c.getRayon() + ", Centre=(" + c.getCentre().getX() + "," + c.getCentre().getY() + "), Périmètre=" + c.getPerimetre() + ", Aire=" + c.getAire());
    }

    public static void afficheRectangle(Rectangle r){
        System.out.println("Rectangle : l=" + r.getLargueur() + ", L=" + r.getLongueur() + ", Origine=(" + r.getOrigine().getX() + "," + r.getOrigine().getY() + "), Périmètre=" + r.getPerimetre() + " ,Aire=" + r.getAire());
    }



}
