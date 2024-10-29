import java.util.Scanner;

public class Triangle_Main2 {
    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Saisie des trois sommets ptA, ptB et ptC d'un triangle");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("(1) Coordonnées du sommet ptA");
        Point ptA = Triangle_Utilitaire.saisirPoint();
        System.out.println("(2) Coordonnées du sommet ptB");
        Point ptB = Triangle_Utilitaire.saisirPointNonConfondu(ptA);
        System.out.println("(3) Coordonnées du sommet ptC");
        Point ptC = Triangle_Utilitaire.saisirPointNonAligneP1P2(ptA, ptB);

        TriangleCompose tComp = new TriangleCompose(ptA, ptB, ptC);
        int dx,dy;

        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Coordonnées initiales des points ptA, ptB et ptC: " + "ptA" + ptA + "ptB" + ptB + "ptC" + ptC);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Coordonnées initiales des points ptA, ptB et ptC: " + "ptA" + ptA + "ptB" + ptB + "ptC" + ptC);
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println("Triangle construit avec les points ptA, ptB et ptC en composition");
        System.out.println(tComp);
        tComp = new TriangleCompose(ptA, ptB, ptC);
        System.out.println("Triangle symétrique par rapport à l'axe horizonatal");
        TriangleCompose symH;
        symH = Triangle_Utilitaire.symetriqueH(tComp);
        System.out.println(symH);
        System.out.println("Triangle symétrique par rapport à l'axe vertical");
        TriangleCompose symV;
        symV = Triangle_Utilitaire.symetriqueV(tComp);
        System.out.println(symV);
        System.out.println("--------------------------------------------------");
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("DÉPLACEMENT DU TRIANGLE (ptA,ptB,ptC)");
        System.out.println("-----------------------------------------");
        System.out.println("Déplacement horizontal des sommets ?");
        dx = lecteur.nextInt();
        lecteur.nextLine();
        System.out.println("Déplacement vertical des sommets ?");
        dy = lecteur.nextInt();
        lecteur.nextLine();
        System.out.println("====================================================================================");
        System.out.println("Après déplacement du triangle construit avec les points ptA, ptB et ptC en composition");
        System.out.println("====================================================================================");
        tComp.deplacer(dx,dy);
        System.out.println("Coordonnées des points ptA, ptB et ptC: " + "ptA" + ptA + "ptB" + ptB + "ptC" + ptC);
        System.out.println("Caractéristiques du triangle:");
        System.out.println(tComp);
        System.out.println("Caractéristiques de son symétrique par rapport à l'axe horizontal");
        System.out.println(Triangle_Utilitaire.symetriqueH(tComp));
        System.out.println("Caractéristiques de son symétrique par rapport à l'axe vertical");
        System.out.println(Triangle_Utilitaire.symetriqueV(tComp));
    }
}
