import java.util.ArrayList;


public class Utilitaire {
    public static boolean verifTri(ArrayList<Polar> vPolar) {
        // { } =>
        // { résultat = vrai si vPolar est trié par titre strictement croissant

        int i=1;

        while(i < vPolar.size() && vPolar.get(i-1).getTitre().compareTo(vPolar.get(i).getTitre()) < 0){
            i++;
        }

        return i == vPolar.size();
    }

    public static void triSelect(ArrayList<Polar> vPolar) {
        // { } => { vPolar a été trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI PAR SÉLECTION

        int i=0;

        while(i < vPolar.size() - 1){
            int indMin = i;
            int j = i+1;
            while(j < vPolar.size()){
                if(vPolar.get(j).compareTo(vPolar.get(indMin)) < 0){
                    indMin = j;
                }
                j++;
            }

            if(indMin != i){
                Polar temporaire = vPolar.get(i);
                vPolar.set(i, vPolar.get(indMin));
                vPolar.set(indMin, temporaire);
            }

            i++;
        }

    }

    public static void triBulle(ArrayList<Polar> vPolar) {
        // { } => { vPolar est trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI À BULLES AMÉLIORÉ

        int j;
        int i = 0;
        boolean onAPermute = true;

        while(onAPermute){
            while(i < vPolar.size()){
                j = vPolar.size() - 1;
                onAPermute = false;
                while(j > i){
                    if(vPolar.get(j-1).compareTo(vPolar.get(j)) > 0){
                        Polar temporaire = vPolar.get(j);
                        vPolar.set(j,vPolar.get(j-1));
                        vPolar.set(j-1, temporaire);
                        onAPermute = true;
                    }
                    j--;
                }
                i++;
            }
        }

    }

    public static void triInsertion(ArrayList<Polar> vPolar) {
        // { } => { vPolar est trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI PAR INSERTION

        int j;
        Polar polarAPlacer;
        int i = 1;

        while(i < vPolar.size()){
            j = i;
            polarAPlacer = vPolar.get(i);
            while(j > 0 && vPolar.get(j-1).compareTo(polarAPlacer) > 0){
                vPolar.set(j, vPolar.get(j-1));
                j--;
            }
            vPolar.set(j, polarAPlacer);
            i++;
        }
    }

    public static void nbPolarAuteur(ArrayList<Polar> vPolar) {
        // { vPolar non vide, trié selon l'ORDRE(auteur, année) } =>
        // { le nombre de romans écrits par chaque auteur a été affiché
        // ligne à ligne, chaque ligne ayant la forme :
        // * Nombre de romans écrits par XXX : nbR
        // (nbR étant le nombre de romans de l'auteur de nom XXX}

        ArrayList<String> vAuteur = new ArrayList<>();
        int nbR = 0;

        for(int i=0; i < vPolar.size()-1 ; i++){
            if(vPolar.get(i).getAuteur().compareTo(vPolar.get(i+1).getAuteur()) != 0){
                vAuteur.add(vPolar.get(i).getAuteur());
            }
        }

        System.out.println(vAuteur);

        for(int i=0; i < vAuteur.size(); i++){
            int j =0;
            while(j < vPolar.size()){
                if(vAuteur.get(i).compareTo(vPolar.get(j).getAuteur()) == 0){
                    nbR++;
                }
                j++;
            }
            System.out.println("*Nombre de romans écrits par " + vAuteur.get(i) + ": " + nbR);
            nbR = 0;
        }
    }

    //Vecteur des noms des auteurs ayant écrit au moins un roman une année donnée
    public static ArrayList<String> auteursDeAn(ArrayList<Polar> vPolar, int an) {
        // { vPolar non vide, trié selon l'ORDRE(auteur, annee) } =>
        // { résultat = vecteur contenant les noms des auteurs ayant écrit au
        // moins un roman l'année an

        ArrayList<String> vAuteur = new ArrayList<>();

        for(int i=1; i < vPolar.size(); i++){
            if(vPolar.get(i).getAnnee() == an){
                vAuteur.add(vPolar.get(i).getAuteur());
            }
        }

        //Pour supprimer les doublons d'auteur
        for(int j=0; j < vAuteur.size()-1; j++){
            while(vAuteur.get(j).compareTo(vAuteur.get(j+1)) == 0){
                vAuteur.remove(vAuteur.get(j));
            }
        }
        return vAuteur;

    }


}
