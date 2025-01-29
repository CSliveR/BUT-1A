import java.sql.SQLOutput;
import java.util.Scanner;

public class Triangle_Utilitaire {
    public static Point saisirPoint() {
        // { } => {résultat = un Point dont les coordonnées
        // sont saisies par l'utilisateur

        Scanner lecteur = new Scanner(System.in);
        int x, y;

        System.out.println("* Abscisse ?");
        x = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("* Ordonnée ?");
        y = lecteur.nextInt();
        lecteur.nextLine();

        return new Point(x,y);
    }

    public static Point saisirPointNonConfondu(Point lePoint) {
        // { } => {résultat = un Point non confondu avec lePoint,
        // dont les coordonnées sont saisies par l'utilisateur

        Point p;

        do{
            System.out.println("Saisie d'un point non confondu avec le point " + lePoint);
            p = saisirPoint();

            if(p.getX() == lePoint.getX() & p.getY() == lePoint.getY()){
                System.out.println("--> Point confondu avec" + lePoint + ", recommencez...");
            }

        }while(p.getX() == lePoint.getX() & p.getY() == lePoint.getY());

        return p;
    }

    public static Point saisirPointNonAligneP1P2(Point P1, Point P2) {
        // { } => { résultat = un Point saisi par l'utilisateur, différent de P1 et
        // et de P2 et non aligné avec P1 et P2

        Point p;
        boolean confonduP1, confonduP2, aligVert, aligHoriz, aligOblique, OK;

        do{
            OK=true;
            System.out.println("Saisie d'un point non aligné avec les points" + P1 + " et " + P2);
            p = saisirPoint();
            confonduP1 = P1.getX()==p.getX() & P1.getY()==p.getY();
            confonduP2 = P2.getX()==p.getX() & P2.getY()==p.getY();
            aligVert = P1.getY()==P2.getY() & P1.getY()==p.getY() & P2.getY()==p.getY();
            aligHoriz = P1.getX()==P2.getX() & P1.getX()==p.getX() & P2.getX()==p.getX();
            aligOblique = ((P2.getY() - P1.getY()) / P2.getX() - P1.getX() == (p.getY() - P1.getY()) / p.getX() - P1.getX());
            OK = (confonduP1 | confonduP2 | aligVert | aligHoriz | aligOblique);

            if(OK){
                System.out.println("--> Point aligné avec les points" + P1 + " et " + P2 + ", recommencez...");
            }

        }while(OK);

        return p;
    }

    public static TriangleCompose symetriqueH(TriangleCompose tComp) {
        // { } =>
        // { résultat = nouveau TriangleCompose dont les sommets sont obtenus par
        // symétrie des sommets de tComp par rapport à l'axe horizontal

        return new TriangleCompose(new Point(tComp.getSomA().getX(),-tComp.getSomA().getY()), new Point(tComp.getSomB().getX(),-tComp.getSomB().getY()),new Point(tComp.getSomC().getX(),-tComp.getSomC().getY())   );
    }

    public static TriangleCompose symetriqueV(TriangleCompose tComp) {
        // { } =>
        // { résultat = nouveau TriangleCompose dont les sommets sont obtenus par
        // symétrie des sommets de tComp par rapport à l'axe vertical

        return new TriangleCompose(new Point(-tComp.getSomA().getX(),tComp.getSomA().getY()), new Point(-tComp.getSomB().getX(),tComp.getSomB().getY()),new Point(-tComp.getSomC().getX(),tComp.getSomC().getY()));
    }
}
