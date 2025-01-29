import java.util.ArrayList;
import java.util.Arrays;

public class Pollution {
    public static void main(String[] args) {
        ArrayList<ReleveMensuel> testReleve = new ArrayList<>();

        testReleve.add(new ReleveMensuel("janvier", 20.6f));
        testReleve.add(new ReleveMensuel("mars", 40));
        testReleve.add(1, new ReleveMensuel("février", 45));

        System.out.println(testReleve);
        ArrayList<String> semestre1 = new ArrayList<>(Arrays.asList("janvier", "février", "mars", "avril", "mai", "juin"));
        final float SEUIL_ALERTE = 40.0f;


        System.out.println("-------------------------------------");
        System.out.println("Bilan 1er semestre");
        System.out.println("-------------------------------------");
        ArrayList<ReleveMensuel> bilanSem1 = Utilitaire.bilanSem(semestre1);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Concentration en dioxyde d'azote sur le 1er semestre");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("*Taux moyen: " + Utilitaire.moyConc(bilanSem1));
        System.out.println("*Nombre de mois pollués: " + Utilitaire.nbPoll(bilanSem1, SEUIL_ALERTE));
        System.out.println("*Nom du premier mois pollué: " + Utilitaire.poll1(bilanSem1, SEUIL_ALERTE));
        System.out.println("*Taux maximum relevé: " + Utilitaire.maxConc(bilanSem1));
        System.out.println("*Taux minimum: " + Utilitaire.minConc(bilanSem1));
        System.out.println("*Analyse mois par mois...");

        for (int i = 0; i < bilanSem1.size(); i++) {
            System.out.println("- " + bilanSem1.get(i).getMois() + ": " + bilanSem1.get(i).getConcentration() + " --> " + Utilitaire.niveauPol(bilanSem1.get(i)));
        }

        ArrayList<String> semestre2 = new ArrayList<>(Arrays.asList("juillet", "août", "septembre", "octobre", "novembre", "décembre"));

        System.out.println("-------------------------------------");
        System.out.println("Bilan 2ème semestre");
        System.out.println("-------------------------------------");
        ArrayList<ReleveMensuel> bilanSem2 = Utilitaire.bilanSem(semestre2);

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Concentration en dioxyde d'azote sur le 2ème semestre");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("*Taux moyen: " + Utilitaire.moyConc(bilanSem2));
        System.out.println("*Nombre de mois pollués: " + Utilitaire.nbPoll(bilanSem2, SEUIL_ALERTE));
        System.out.println("*Nom du premier mois pollué: " + Utilitaire.poll1(bilanSem2, SEUIL_ALERTE));
        System.out.println("*Taux maximum relevé: " + Utilitaire.maxConc(bilanSem2));
        System.out.println("*Taux minimum: " + Utilitaire.minConc(bilanSem2));
        System.out.println("*Analyse mois par mois...");
        for (int i = 0; i < bilanSem2.size(); i++) {
            System.out.println("- " + bilanSem2.get(i).getMois() + ": " + bilanSem2.get(i).getConcentration() + " --> " + Utilitaire.niveauPol(bilanSem2.get(i)));
        }

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Comparaison entre les 2 semestres");
        System.out.println("-----------------------------------------------------------------------");
        if (Utilitaire.compareReleves(bilanSem1, bilanSem2, SEUIL_ALERTE) == -1) {
            System.out.println("Amélioration de l'émission de NO2 sur le second semestre");
        }else{
            System.out.println("Aggravation de l'émission de NO2 sur le second semestre");
        }



    }
}
