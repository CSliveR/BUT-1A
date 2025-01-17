import java.util.ArrayList;
import java.util.Scanner;
public class Utilitaire {
    //a) Saisie contrôlée de la concentration en dioxyde d'azote pour un mois donné
    public static float saisieConc(String unMois) {
        //{ } => { résultat = un float>=0 saisi par l'utilisateur, représentant
        // la concentration en NO2 pour le mois unMois

        float unFloat;
        Scanner lecteur = new Scanner(System.in);

        do {
            System.out.println("*Concentration en dioxyde d'azote relevée en " + unMois + " ?");
            unFloat = lecteur.nextFloat();
            lecteur.nextLine();


        } while (unFloat < 0);

        return unFloat;
    }

    //b) Vecteur de relevés mensuels
    public static ArrayList<ReleveMensuel> bilanSem(ArrayList<String> desMois) {
        // { desMois contient des noms de mois }
        // => { résultat = un vecteur de ReleveMensuel
        // Pour chaque élément du vecteur résultat:
        // * mois est le nom du mois de même indice dans desMois
        // * concentration est la concentration en NO2, saisie pour ce mois

        ArrayList<ReleveMensuel> vReleveMensuel = new ArrayList<>();

        for (int i = 0; i < desMois.size(); i++) {
            vReleveMensuel.add(i, new ReleveMensuel(desMois.get(i), saisieConc(desMois.get(i))));
        }

        return vReleveMensuel;
    }

    //c) Moyenne des concentrations
    public static float moyConc(ArrayList<ReleveMensuel> desReleves) {
        // { } => { résultat = moyenne des concentrations des éléments
        // du vecteur desReleves

        float somme = 0.0f;

        for (int i = 0; i < desReleves.size(); i++) {
            somme += desReleves.get(i).getConcentration();
        }

        return somme/desReleves.size();
    }

    // d) Concentration maximale
    public static float maxConc(ArrayList<ReleveMensuel> desReleves) {
        // { desReleves non vide } =>
        // { résultat = concentration la plus élevée dans desReleves

        float max = desReleves.get(0).getConcentration();

        for (int i = 0; i < desReleves.size(); i++) {
            if (desReleves.get(i).getConcentration() > max) {
                max = desReleves.get(i).getConcentration();
            }
        }

        return max;
    }

    //e) Concentration minimale
    public static float minConc(ArrayList<ReleveMensuel> desReleves) {
        // { des RelevesNonVide } =>
        // { résultat = concentration la moins élevée dans desReleves

        float min = desReleves.get(0).getConcentration();

        for (int i = 0; i < desReleves.size(); i++) {
            if (desReleves.get(i).getConcentration() < min) {
                min = desReleves.get(i).getConcentration();
            }
        }

        return min;
    }

    //f) Indicateur de pollution
    public static boolean estPollue(ReleveMensuel unReleve, float seuil) {
        // { } =>
        // { résultat = vrai si la concentration de unReleve > seuil

        return unReleve.getConcentration() > seuil;
    }

    //g) Nombre de mois pollués
    public static int nbPoll(ArrayList<ReleveMensuel> desReleves, float seuil) {
        // { } => { résultat = nombre de mois pollués dans desReleves
        int nbMois = 0;

        for(int i=0; i < desReleves.size(); i++){
            if(estPollue(desReleves.get(i), seuil)){
                nbMois++;
            }
        }

        return nbMois;
    }

    //h) Nom du premier mois pollué
    public static String poll1(ArrayList<ReleveMensuel> desReleves, float seuil) {
        // { } => { résultat = nom du premier mois pollué dans desReleves,
        // une chaîne vide s'il n'y en a pas

        String mois = "";
        int i=0;

        while(i < desReleves.size() && !estPollue(desReleves.get(i), seuil)){
            i++;
        }

        return desReleves.get(i).getMois();
    }

    //i) Niveau de pollution
    public static String niveauPol(ReleveMensuel unReleve) {
        // { } =>
        // { résultat = * "bon" si concentration <= 10
        // * "moyen" si concentration dans ]10, 25]
        // * "dégradé" si concentration dans ]25, 40]
        // * "mauvais" si concentration dans ]40, 55]
        // * "très mauvais" si concentration dans ]55, 70]
        // * "extrêmement mauvais" si concentration > 70

        if(unReleve.getConcentration() <= 10){
            return "bon";
        }else if(unReleve.getConcentration() > 10 & unReleve.getConcentration() <= 25){
            return "moyen";
        }else if(unReleve.getConcentration() > 25 & unReleve.getConcentration() <= 40){
            return "dégradé";
        }else if(unReleve.getConcentration() > 40 & unReleve.getConcentration() <= 55){
            return "mauvais";
        }else if(unReleve.getConcentration() > 55 & unReleve.getConcentration() <= 70){
            return "très mauvais";
        }else{
            return "extrêmement mauvais";
        }
    }

    public static int compareReleves(ArrayList<ReleveMensuel> releves1,
                                     ArrayList<ReleveMensuel> releves2, float seuil) {
        // { releves1 et releves2 non vides et de même taille }
        // => { Résultat = * -1 si la moyenne des concentrations en NO2 de releves1
        // est inférieure à celle de releves2, ou si les moyennes
        // sont égales et le nombre de mois pollués de releves1
        // est inférieur à celui de releves2
        // * 0 si les moyennes des concentrations en NO2 sont égales
        // et si le nombre de mois pollués est identique
        // * 1 dans tous les autres cas

        int unEnt;

        if(moyConc(releves1) < moyConc(releves2) || (moyConc(releves1) == moyConc(releves2) && nbPoll(releves1,seuil) < nbPoll(releves2,seuil))){
            return -1;
        }else if(moyConc(releves1) == moyConc(releves2) && nbPoll(releves1,seuil) == nbPoll(releves2,seuil)){
            return 0;
        }else{
            return -1;
        }

    }

}
