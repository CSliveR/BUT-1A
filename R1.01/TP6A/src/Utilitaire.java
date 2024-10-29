import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {
    public static int indContinent(ArrayList<String> vCont, String cont) {
        // { vCont trié } =>
        // { résultat = * -1 si cont est déjà dans vCont
        // * indice où il faudrait insérer cont dans VCont
        // pour conserver le tri de ce vecteur, sinon

        int i=0;

        while(i < vCont.size() && vCont.get(i).compareTo(cont) < 0){
            i++;
        }

        if(i == vCont.size() || vCont.get(i).compareTo(cont) > 0){
            return i;
        }else{
            return -1;
        }

    }


    //a) Vérification de l'appartenance d'une chaîne à un vecteur de chaînes trié
    public static boolean existString(ArrayList<String> vString, String uneString) {
        // { vString trié } =>
        // { résultat = vrai si uneString appartient à vString

        int i = 0;

        while(i < vString.size() && vString.get(i).compareTo(uneString) < 0){
            i++;
        }

        return i < vString.size() && vString.get(i).compareTo(uneString) == 0;

    }

    //b) Saisie contrôlée d'un continent (cette fonction doit utiliser la précédente)
    public static String saisieCont(ArrayList<String> vCont) {
        // { vCont trié, non vide } =>
        // { résultat = valeur d'un élément de vCont saisie par l'utilisateur
        // LA SAISIE DOIT ÊTRE CONTRÔLÉE

        Scanner lecteur = new Scanner(System.in);
        String unCont;

        do{
            System.out.println("Choissisez le nom d'un continent dans " + vCont);
            unCont = lecteur.nextLine();

            if(!existString(vCont,unCont)){
                System.out.println("-->Saisie invalide, recommencez...");
            }
        }while(!existString(vCont,unCont));

        return unCont;
    }

    public static ArrayList<Pays> paysDeCont(ArrayList<Pays> vPays, String cont) {
        // { cont est le continent d'au moins un pays de vPays } =>
        // { résultat = vecteur contenant les pays de vPays
        // dont le continent est cont

        ArrayList<Pays> vPaysDansCont = new ArrayList<>();

        for(int i=0; i < vPays.size(); i++){
            if(vPays.get(i).getContinent().compareTo(cont) == 0){
                vPaysDansCont.add(vPays.get(i));
            }
        }

        return vPaysDansCont;
    }

    public static int rechPaysT(ArrayList<Pays> vPays, String nomP) {
        // { vPays trié sur le nom } =>
        // { résultat = indice dans vPays du pays de nom nomP s'il existe,
        // vPays.size() si pas de pays de nom nomP dans vPays

        int i=0;

        while(i < vPays.size() && vPays.get(i).getNom().compareTo(nomP) < 0){
            i++;
        }

        if(i < vPays.size() && vPays.get(i).getNom().compareTo(nomP) == 0){
            return i;
        }else{
            return vPays.size();
        }

    }

    //a) Pays le(s) moins peuplé(s) du monde
    public static void paysMoinsPeuples(ArrayList<Pays> vMonde) {
        // { vMonde non vide } =>
        // { les caractéristiques du ou des pays le(s) moins peuplé(s)
        // dans vMonde ont été affichées

        Pays paysMinPop = vMonde.get(0);

        for (int i=0; i < vMonde.size(); i++){
            if(vMonde.get(i).getPopulation() < paysMinPop.getPopulation()){
                paysMinPop = vMonde.get(i);
            }
        }

       System.out.println(paysMinPop);
    }

    //b) Continent(s) comptant le plus grand, respectivement le plus petit nombre de pays
    public static void contExtremes(ArrayList<Pays> vMonde, ArrayList<String> vCont) {
        // { vMonde non vide } =>
        // { * Affichage du nom et du nombre de pays du (ou des) continent(s)
        // comptant le plus de pays
        // * Affichage du nom et du nombre de pays du (ou des) continent(s)
        // comptant le moins de pays


        String contPlusDePays = vCont.get(0);
        String contMoinsDePays = vCont.get(0);

        for(int i=0; i < vMonde.size(); i++){
            for (int j=0; j < vCont.size(); j++){
                if(paysDeCont(vMonde, vCont.get(j)).size() > (paysDeCont(vMonde,contPlusDePays)).size()){
                    contPlusDePays = vCont.get(j);
                }

                if(paysDeCont(vMonde, vCont.get(j)).size() < (paysDeCont(vMonde,contMoinsDePays)).size()){
                    contMoinsDePays = vCont.get(j);
                }
            }
        }

        System.out.println("Continent(s) comptant le plus de pays (" + paysDeCont(vMonde,contPlusDePays).size() + " pays): ");
        System.out.println("- " + contPlusDePays);
        System.out.println("---------------------------------------------------------");
        System.out.println("Continent(s) comptant le moins de pays (" + paysDeCont(vMonde,contMoinsDePays).size() + " pays): ");
        System.out.println("- " + contMoinsDePays);

    }

}
