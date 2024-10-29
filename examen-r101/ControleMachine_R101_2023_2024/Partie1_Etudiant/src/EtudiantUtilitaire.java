import java.util.Scanner;

public class EtudiantUtilitaire {
    /**
     * À ÉCRIRE - Exercice 1
     * @return cf. postcondition
     */
    public static float saisirNote() {
        // { } =>
        // { résultat = une valeur de type float dans l'intervalle [0,0 .. 20,0]
        //                 saisie par l'utlllisateur

        float val;
        Scanner lecteur = new Scanner(System.in);

        do{
            System.out.println("Veuillez saisir une valeur dans l'intervalle [0,0 .. 20,0]");
            val = lecteur.nextFloat();
            lecteur.nextLine();
            if(val < 0.0 | val > 20.0){
                System.out.println("Saisie incorrecte, recommencez !");
            }
        }while(val < 0.0 | val > 20.0);

        return val;
    }



}


