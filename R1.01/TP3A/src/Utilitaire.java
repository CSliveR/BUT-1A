import java.sql.SQLOutput;
import java.util.Scanner;

public class Utilitaire {
    public static float saisieFloatPos() {
    // { } => { résultat = un réel (float) strictement positif
        float unReel;
        Scanner lecteur = new Scanner(System.in);

        do{
            System.out.println("*Entrez un réel strictement positif: ");
            unReel = lecteur.nextFloat();
            lecteur.nextLine();

            if(unReel <= 0){
                System.out.println("--> Saisie invalide, recommencez...");
            }

        }while(unReel <= 0);

        return unReel;
    }

    public static float saisieFloatPosMinMax(float min, float max) {
        // { 0 < min < max } =>
        // { résultat = un réel saisi par l'utilisateur, appartenant à ]min, max[
        float unReel;

        do{
            System.out.println("Entrez un nombre à virgule dans l'intervalle ]" + min + "," + max +"[");
            unReel = saisieFloatPos();

            if(unReel <= min | unReel >= max){
                System.out.println("Saisie invalide recommencez...");
            }

        }while(unReel <= min | unReel >= max);

        return unReel;
    }

    public static Rectangle saisirRectangle() {
        // { } => { résultat = un nouvel objet de type Rectangle
        // dont les côtés sont saisis par l'utilisateur
        float cote1 = saisieFloatPos();
        System.out.println();
        System.out.println("Longueur d'un de ses côtés adjacents ?");
        float cote2 = saisieFloatPos();

        return new Rectangle(cote1,cote2);
    }

    public static Cercle saisirCercle() {
        // { } => { résultat = un nouvel objet de type Cercle dont le rayon
        // est saisi par l'utilisateur
        float rayon = saisieFloatPos();


        return new Cercle(rayon);
    }

    public static float troisiemeCoteTriangle(float cote1, float cote2) {
        // { cote1 et cote2 > 0 } =>
        // { le résultat est un float strictement positif, tel qu'un triangle dont
        // les côtés seraient cote1, cote2 et le float saisi puisse être construit
        // INDICATION : INÉGALITÉ TRIANGULAIRE

        return saisieFloatPosMinMax(Math.abs(cote1 - cote2), cote1 + cote2);
    }
    public static Triangle saisirTriangle() {
        // { } => { résultat = un nouvel objet de type triangle
        // dont les côtés sont saisis par l'utilisateur

        System.out.println("Longueur d'un côté d'un triangle ?");
        float cote1 = saisieFloatPos();
        System.out.println();
        System.out.println("Longueur d'un côté de ce triangle ?");
        float cote2 = saisieFloatPos();
        System.out.println();
        System.out.println("Longueur du troisième côté de ce triangle ?");
        float cote3 = troisiemeCoteTriangle(cote1,cote2);

        return new Triangle(cote1, cote2, cote3);
    }


}
