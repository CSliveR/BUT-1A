import java.util.ArrayList;
import java.util.Scanner;

public class Comparaisons {
    public static void main(String[] args) {
        ArrayList<Polar> mesPolars = CreationBib.lesPolars();
        System.out.println("Nombre de comparaisons effectuées par le TRI PAR SÉLECTION");
        System.out.println(Utilitaire.triSelectNbComp(mesPolars));
        mesPolars = CreationBib.lesPolars();
        System.out.println("Nombre de comparaisons effectuées par le TRI PAR INSERTION");
        System.out.println(Utilitaire.triInsertionNbComp(mesPolars));

        Scanner lecteur = new Scanner(System.in);

        String auteurTest;
        int anneeTest;

        System.out.println("----------------------------------------");
        System.out.println("Entrez le nom d'un auteur (chaine en majuscules):");
        auteurTest = lecteur.nextLine();
        System.out.println("Entrez une année (un entier):");
        anneeTest = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("----------------------------------------");
        System.out.println("Recherche séquentielle du premier roman policier écrit par " + auteurTest + " en " + anneeTest);

        int indRechSeq = Utilitaire.rechSeqT(mesPolars,auteurTest,anneeTest);
        if (indRechSeq == -1) {
            System.out.println("*Aucun roman de " + auteurTest + " en " + anneeTest + " ...");
        }else{
            System.out.println("*Premier roman de " + auteurTest + " écrit en 2000: " + mesPolars.get(indRechSeq).getTitre() + " (trouvé à l'indice " + indRechSeq + ")");
        }

        System.out.println("----------------------------------------");
        System.out.println("Recherche dichotomique du premier roman policier écrit par " + auteurTest + " en " + anneeTest);
        int indRechDicho = Utilitaire.rechDicho(mesPolars,auteurTest,anneeTest);
        if(indRechDicho == -1){
            System.out.println("*Aucun roman de " + auteurTest + " en " + anneeTest + " ...");
        }else{
            System.out.println("*Premier roman de " + auteurTest + " écrit en 2000: " + mesPolars.get(indRechDicho).getTitre() + " (trouvé à l'indice " + indRechDicho + ")");
        }

        System.out.println("----------------------------------------");
        System.out.println("Recherche séquentielle du premier roman policier écrit par " + auteurTest + " en " + anneeTest + " avec le nombre de comparaisons effectuées");
        PaireResultatCompteur<Integer> indRechSeq_O = Utilitaire.rechSeqT_O(mesPolars,auteurTest,anneeTest);
        if (indRechSeq == -1) {
            System.out.println("*Aucun roman de " + auteurTest + " en " + anneeTest + " ...");
        }else{
            System.out.println("*Premier roman de " + auteurTest + " écrit en 2000: " + mesPolars.get(indRechSeq_O.getRes()).getTitre() + " (trouvé à l'indice " + indRechSeq_O.getRes() + ")");
        }
        System.out.println("*Nombre de comparaisons effectuées: " + indRechSeq_O.getCompteur());

        System.out.println("----------------------------------------");
        System.out.println("Recherche dichotomique du premier roman policier écrit par " + auteurTest + " en " + anneeTest + " avec le nombre de comparaisons effectuées");
        PaireResultatCompteur<Integer> indRechDicho_O = Utilitaire.rechDicho_O(mesPolars,auteurTest,anneeTest);
        if(indRechDicho == -1){
            System.out.println("*Aucun roman de " + auteurTest + " en " + anneeTest + " ...");
        }else{
            System.out.println("*Premier roman de " + auteurTest + " écrit en 2000: " + mesPolars.get(indRechDicho_O.getRes()).getTitre() + " (trouvé à l'indice " + indRechDicho_O.getRes() + ")");
        }
        System.out.println("*Nombre de comparaisons effectuées: " + indRechDicho_O.getCompteur());
    }
}
