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

    public static int triSelectNbComp(ArrayList<Polar> vPolar) {
        // { } => { vPolar a été trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI PAR SÉLECTION

        int i=0;
        int nbComparaisons = 0;

        while(i < vPolar.size() - 1){
            int indMin = i;
            int j = i+1;
            while(j < vPolar.size()){
                if(vPolar.get(j).compareTo(vPolar.get(indMin)) < 0){
                    indMin = j;
                }
                j++;
                nbComparaisons = nbComparaisons + 1;
            }

            if(indMin != i){
                Polar temporaire = vPolar.get(i);
                vPolar.set(i, vPolar.get(indMin));
                vPolar.set(indMin, temporaire);
            }

            i++;
        }

        return nbComparaisons;
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

    public static int triInsertionNbComp(ArrayList<Polar> vPolar) {
        // { } => { vPolar est trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI PAR INSERTION

        int j;
        Polar polarAPlacer;
        int i = 1;
        int nbComparaisons = 0;

        while(i < vPolar.size()){
            j = i;
            polarAPlacer = vPolar.get(i);
            while(j > 0 && vPolar.get(j-1).compareTo(polarAPlacer) > 0){
                vPolar.set(j, vPolar.get(j-1));
                j--;
                //compte des comparaisons si la condition vPolar.get(j-1).compareTo(polarAPlacer) > 0 est vraie
                nbComparaisons = nbComparaisons + 1;
            }

            //compte des comparaisons si la condition vPolar.get(j-1).compareTo(polarAPlacer) > 0 est fausse
            if(j > 0){
                nbComparaisons = nbComparaisons + 1;
            }

            vPolar.set(j, polarAPlacer);
            i++;
        }


        return nbComparaisons;
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

    public static int rechSeqT(ArrayList<Polar> vPolar, String aut, int an) {
        // { vPolar trié selon l'ORDRE(auteur, annee) }
        // => { * résultat = indice du premier élément de vPolar
        // écrit par aut, l'année an, si trouvé
        // * résultat = -1, si aucun roman écrit par aut, l'année an
        // LA RECHERCHE EST SÉQUENTIELLE

        int i=0;
        Polar unPolar = new Polar(an,aut,"");

        while(i < vPolar.size() && vPolar.get(i).compareTo(unPolar) < 0){
            i++;
        }

        if(i < vPolar.size() && vPolar.get(i).compareTo(unPolar) == 0){
            return i;
        }else{
            return -1;
        }
    }

    public static int rechDicho(ArrayList<Polar> vPolar, String aut, int an) {
        // { vPolar trié selon l'ORDRE(auteur, annee) }
        // => { * résultat = indice du premier élément de vPolar
        // écrit par aut, l'année an, si trouvé
        // * résultat = -1, si aucun roman écrit par aut, l'année an
        // LA RECHERCHE EST DICHOTOMIQUE

        Polar unPolar = new Polar(an,aut, "");

        if(vPolar.get(vPolar.size()-1).compareTo(unPolar) <  0){
            return -1;
        }else{
            int inf = 0;
            int sup = vPolar.size() - 1;

            while(inf < sup){
                int mid = (inf + sup)/2;

                if(vPolar.get(mid).compareTo(unPolar) < 0){
                    inf = inf + 1;
                }else{
                    sup = sup - 1;
                }
            }
            if(vPolar.get(inf).compareTo(unPolar) == 0){
                return inf;
            }else{
                return -1;
            }
        }
    }

    public static PaireResultatCompteur<Integer> rechSeqT_O(ArrayList<Polar> vPolar,
                                                            String aut, int an) {
        // { vPolar trié selon l'ORDRE(auteur, annee) } =>
        // { * le premier élément de vPolar écrit par aut, l'année an a été cherché
        // à l'aide d'un algorithme de RECHERCHE SÉQUENTIELLE
        // * résultat = un objet de type PaireResCompteur où :
        // - l'attribut res est égal à l'indice dans vPolar du 1er élément d'auteur aut
        // et d'année an, si trouvé / -1 si pas trouvé
        // - l'attribut compteur est égal au nombre de comparaisons effectuées entre
        // un élément du vecteur et ce qui est cherché, pour produire res

        int i=0;
        Polar unPolar = new Polar(an,aut,"");
        int nbComparaisons = 0;

        while(i < vPolar.size() && vPolar.get(i).compareTo(unPolar) < 0){
            i++;
            nbComparaisons = nbComparaisons + 1;
        }


        if(i < vPolar.size() && vPolar.get(i).compareTo(unPolar) == 0){
            nbComparaisons = nbComparaisons + 1;
            return new PaireResultatCompteur<>(i,nbComparaisons);
        }else{
            nbComparaisons = nbComparaisons + 1;
            return new PaireResultatCompteur<>(-1,nbComparaisons);
        }
    }

    public static PaireResultatCompteur<Integer> rechDicho_O(ArrayList<Polar> vPolar,
                                                             String aut, int an) {
        // { vPolar trié selon l'ORDRE(auteur, annee) } =>
        // { * le premier élément de vPolar écrit par aut, l'année an a été cherché
        // à l'aide d'un algorithme de RECHERCHE DICHOTOMIQUE
        // * résultat = un objet de type PaireResCompteur dont :
        // - l'attribut res est égal à l'indice dans vPolar du 1er élément d'auteur aut
        // et d'année an, si trouvé / -1 si pas trouvé
        // - l'attribut compteur est égal au nombre de comparaisons effectuées entre
        // un élément du vecteur et ce qui est cherché, pour produire res

        Polar unPolar = new Polar(an,aut, "");
        int nbComparaisons = 0;

        if(vPolar.get(vPolar.size()-1).compareTo(unPolar) <  0){
            nbComparaisons = nbComparaisons + 1;
            return new PaireResultatCompteur<>(-1, nbComparaisons);
        }else{
            nbComparaisons = nbComparaisons +1;
            int inf = 0;
            int sup = vPolar.size() - 1;

            while(inf < sup){
                int mid = (inf + sup)/2;

                if(vPolar.get(mid).compareTo(unPolar) < 0){
                    inf = mid + 1;
                }else{
                    sup = mid;
                }
                nbComparaisons = nbComparaisons + 1;
            }

            if(vPolar.get(inf).compareTo(unPolar) == 0){
                nbComparaisons = nbComparaisons + 1;
                return new PaireResultatCompteur<>(inf, nbComparaisons);
            }else{
                nbComparaisons = nbComparaisons + 1;
                return new PaireResultatCompteur<>(-1, nbComparaisons);
            }
        }

    }
}
