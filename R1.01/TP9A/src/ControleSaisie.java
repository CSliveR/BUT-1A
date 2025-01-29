import java.util.Scanner;

public class ControleSaisie {
    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);
        //Utilitaire.getInt_IME(lecteur);
        //Utilitaire.getIntMinMax_IME(lecteur,0,100);
        Utilitaire.getInt_NFE(lecteur);
        Utilitaire.getFloat_NFE(lecteur);
    }
}
