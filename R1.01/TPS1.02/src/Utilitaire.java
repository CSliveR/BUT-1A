import java.util.ArrayList;

public class Utilitaire {
    //a) Tri à bulles amélioré OUTILLE :
    public static int triBulle_O(ArrayList<Integer> vInt) {
        // { vInt quelconque } =>
        // { * vInt a été trié par la méthode du TRI A BULLES AMELIORE
        // * résultat = nombre de comparaisons entre deux éléments de vInt

        int j;
        int i = 0;
        boolean permute = true;
        int nbComparaisons = 0;

        while (permute) {
            permute = false;
            j = vInt.size() - 1;
            while (j > i) {
                if (vInt.get(j) < vInt.get(j - 1)) {
                    int temporaire = vInt.get(j);
                    vInt.set(j, vInt.get(j - 1));
                    vInt.set(j - 1, temporaire);
                    permute = true;
                }
                nbComparaisons++;
                j--;
            }
            i++;
        }
        return nbComparaisons;
    }

    //  b) Tri par insertion OUTILLE :
    public static int triInsert_O(ArrayList<Integer> vInt) {
        // { vInt quelconque } =>
        // { * vInt a été trié par la méthode du TRI PAR INSERTION
        // * résultat = nombre de comparaisons entre deux éléments de vInt
        int j;
        int valeurAPlacer;
        int i = 1;
        int nbComparaisons = 0;

        while (i < vInt.size()) {
            j = i;
            valeurAPlacer = vInt.get(i);
            while (j > 0 && vInt.get(j - 1) > valeurAPlacer) {
                vInt.set(j, vInt.get(j - 1));
                nbComparaisons++;
                j--;
            }
            if (j > 0) {
                nbComparaisons++;
            }
            vInt.set(j, valeurAPlacer);
            i++;
        }

        return nbComparaisons;
    }

    //c) Tri par sélection OUTILLE :
    public static int triSelect_O(ArrayList<Integer> vInt) {
        // { vInt quelconque } =>
        // { * vInt a été trié par la méthode du TRI PAR SELECTION
        // * résultat = nombre de comparaisons entre deux éléments de vInt

        int i = 0;
        int nbComparaisons = 0;
        while (i < vInt.size() - 1) {
            int indMin = i;
            int j = i + 1;
            while (j < vInt.size()) {
                if (vInt.get(j) < vInt.get(indMin)) {
                    indMin = j;
                }
                nbComparaisons++;
                j++;
            }

            if (indMin != i) {
                int temporaire = vInt.get(i);
                vInt.set(i, vInt.get(indMin));
                vInt.set(indMin, temporaire);
            }
            i++;
        }

        return nbComparaisons;
    }

    public static ArrayList<Integer> genVectSansDoublons(int n) {
        // { } =>
        // { résultat = vecteur de n entiers, sans doublons, dont les valeurs
        // sont choisies aléatoirement dans [0..2*n]

        ArrayList<Integer> vInt = new ArrayList<>();
        int val;
        while (vInt.size() < n) {
            val = (int) (Math.random() * (2 * n + 1));
            if (vInt.indexOf(val) == -1) {
                vInt.add(val);
            }
        }
        return vInt;
    }

    //a) Recherche séquentielle outillée de l'indice de la 1ère occurrence d'un entier donné – FORME ITÉRATIVE
    public static PaireResCompteur<Integer> rechSeqIt_O(ArrayList<Integer> vInt, int unInt) {
        // { vInt non vide, trié } =>
        // { résultat = variable de type PaireResCompteur avec :
        // res = * indice de la 1ère occurrence de unInt dans vInt
        // * -1 si non trouvé
        // compteur = nombre de comparaisons entre unInt
        // et un élément de vInt

        int i = 0;
        int nbComparaisons = 0;

        while (i < vInt.size() && vInt.get(i) < unInt) {
            nbComparaisons = nbComparaisons + 1;
            i++;
        }

        if(vInt.get(vInt.size()-1) < unInt){
            nbComparaisons--;
        }

        if (i < vInt.size() && vInt.get(i) == unInt) {
            nbComparaisons = nbComparaisons + 1;
            return new PaireResCompteur<>(i, nbComparaisons);
        } else {
            nbComparaisons = nbComparaisons + 1;
            return new PaireResCompteur<>(-1, nbComparaisons);
        }



    }

    //b) Recherche dichotomique outillée de la 1ère occurrence d'un entier donné – FORME ITÉRATIVE
    public static PaireResCompteur<Integer> rechDichoIt_O(ArrayList<Integer> vInt, int unInt) {
        // { vInt non vide, trié } =>
        // { résultat = variable de type PaireResCompteur avec :
        // res = * indice de la 1ère occurrence de unInt dans vInt
        // * -1 si non trouvé
        // compteur = nombre de comparaisons effectuées entre unInt
        // et un élément de vInt

        int nbComparaisons = 0;

        if (vInt.get(vInt.size() - 1) < unInt) {
            nbComparaisons = nbComparaisons + 1;
            return new PaireResCompteur<>(-1, nbComparaisons);
        } else {
            nbComparaisons = nbComparaisons + 1;
            int inf = 0;
            int sup = vInt.size();
            while (inf < sup) {
                int mid = (inf + sup) / 2;
                if (vInt.get(mid) >= unInt) {
                    sup = mid;
                } else {
                    inf = mid + 1;
                }
                nbComparaisons = nbComparaisons + 1;
            }

            if (vInt.get(inf) == unInt) {
                nbComparaisons = nbComparaisons + 1;
                return new PaireResCompteur<>(inf, nbComparaisons);
            } else {
                return new PaireResCompteur<>(-1, nbComparaisons);
            }

        }

    }

    //le point d'entrée
    public static PaireResCompteur<Integer> rechDichoRec_O(ArrayList<Integer> vInt, int unInt) {
        // { vInt non vide, trié } =>
        // { résultat = variable de type PaireResCompteur avec :
        // res = * indice de la 1ère occurrence de unInt dans vInt
        // * -1 si non trouvé
        // compteur = nombre de comparaisons effectuées entre unInt
        // et un élément de vInt

        return rechDichoRec_O_wk(vInt,unInt,0,vInt.size()-1);
    }

    //le worker (récursif)
    public static PaireResCompteur<Integer> rechDichoRec_O_wk(ArrayList<Integer> vInt, int unInt, int inf, int sup) {
        // { 0<=inf<=sup<=vInt.size()-1, vInt[inf..sup] non vide et trié } =>
        // { résultat = variable de type PaireResCompteur avec :
        // res = * inf (ou sup) si inf=sup et unInt trouvé à l'indice inf
        // * -1 si non trouvé
        // compteur = nombre de comparaisons effectuées...

        int nbComparaisons = 0;

        if(inf == sup){
            nbComparaisons++;
            if(vInt.get(inf) == unInt){
                nbComparaisons++;
                return new PaireResCompteur<>(inf,nbComparaisons);
            }else{
                nbComparaisons++;
                return new PaireResCompteur<>(-1,nbComparaisons);
            }
        }else {
            int mid = (inf+sup)/2;

            if(vInt.get(mid) >= unInt){
                return new PaireResCompteur<>(rechDichoRec_O_wk(vInt,unInt,inf,mid).getRes(),rechDichoRec_O_wk(vInt,unInt,mid+1,sup).getCompteur()+1);
            }else{
                return new PaireResCompteur<>(rechDichoRec_O_wk(vInt,unInt,mid+1,sup).getRes(),rechDichoRec_O_wk(vInt,unInt,mid+1,sup).getCompteur()+1);
            }
        }
    }
}
