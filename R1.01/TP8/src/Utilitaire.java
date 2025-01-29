import java.util.ArrayList;

public class Utilitaire {
    //a) Pays de plus grande superficie – FORME ITÉRATIVE
    public static Pays plusGrandPaysIter(ArrayList<Pays> vPays) {
        // { vPays non vide } =>
        // { résultat = élément de vPays ayant la plus grande superficie

        Pays plusGrandPays = vPays.get(0);

        for (int i = 1; i < vPays.size(); i++) {
            if (vPays.get(i).getSuperficie() > plusGrandPays.getSuperficie()) {
                plusGrandPays = vPays.get(i);
            }
        }

        return plusGrandPays;
    }

    //b) Pays de plus grande superficie – FORME RÉCURSIVE (Diviser pour Régner) le point d'entrée
    public static Pays plusGrandPaysDPR(ArrayList<Pays> vPays) {
        // { vPays non vide } =>
        // { résultat = élément de vPays ayant la plus grande superficie
        return maxPaysDPRWorker(vPays, 0, vPays.size() - 1);

    }

    //le worker (récursif)
    public static Pays maxPaysDPRWorker(ArrayList<Pays> vPays, int inf, int sup) {
        // { vPays non vide, 0<=inf<=sup<vPays.size() } =>
        // { résultat = élément de plus grande superficie dans vPays[inf..sup]

        if (inf == sup) {
            return vPays.get(inf);
        } else {
            int mid = (inf + sup) / 2;
            Pays plusGrandPaysGauche = maxPaysDPRWorker(vPays, inf, mid);
            Pays plusGrandPaysDroite = maxPaysDPRWorker(vPays, mid + 1, sup);

            if (plusGrandPaysGauche.getSuperficie() > plusGrandPaysDroite.getSuperficie()) {
                return plusGrandPaysGauche;
            } else {
                return plusGrandPaysDroite;
            }
        }
    }

    //a) Indice du pays le moins peuplé – FORME ITÉRATIVE
    public static int indMinPopIter(ArrayList<Pays> vPays) {
        // { vPays non vide } =>
        // { résultat = indice dans vPays de l'élément de population la plus faible

        int indMinPop = 0;

        for (int i = 0; i < vPays.size(); i++) {
            if (vPays.get(i).getPopulation() < vPays.get(indMinPop).getPopulation()) {
                indMinPop = i;
            }
        }

        return indMinPop;
    }

    //b) Indice du pays le moins peuplé – FORME RÉCURSIVE (Diviser pour Régner)
    //le point d'entrée
    public static int indMinPopDPR(ArrayList<Pays> vPays) {
        // { vPays non vide } =>
        // { résultat = indice dans vPays de l'élément de population la plus faible
        return indMinPopDPRWorker(vPays, 0, vPays.size() - 1);
    }

    //  le worker (récursif)
    public static int indMinPopDPRWorker(ArrayList<Pays> vPays, int inf, int sup) {
        // { vPays non vide, 0<=inf<=sup<vPays.size() } =>
        // { résultat = indice dans vPay[inf..sup] de l'élément de population
        // la plus faible

        if (inf == sup) {
            return inf;
        } else {
            int mid = (inf + sup) / 2;

            int indMinPopGauche = indMinPopDPRWorker(vPays, inf, mid);
            int indMinPopDroite = indMinPopDPRWorker(vPays, mid + 1, sup);

            if (vPays.get(indMinPopGauche).getPopulation() < vPays.get(indMinPopDroite).getPopulation()) {
                return indMinPopGauche;
            } else {
                return indMinPopDroite;
            }
        }
    }

    //a) Vecteur trié selon l'ORDRE(continent, nom) construit à partir d'un vecteur de Pays
    public static ArrayList<Pays> triBulleContNom(ArrayList<Pays> vPays) {
        // { } => { résultat = vecteur contenant les éléments de vPays,
        // triés selon l'ORDRE(continent, nom)
        // ALGORITHME : tri à bulles amélioré

        int j;
        int i = 0;
        boolean onAPermute = true;

        while (onAPermute) {
            while (i < vPays.size()) {
                j = vPays.size() - 1;
                onAPermute = false;
                while (j > i) {
                    if (vPays.get(j - 1).compareTo(vPays.get(j)) > 0) {
                        Pays temporaire = vPays.get(j);
                        vPays.set(j, vPays.get(j - 1));
                        vPays.set(j - 1, temporaire);
                        onAPermute = true;
                    }
                    j--;
                }
                i++;
            }
        }

        return vPays;
    }

    // b) Vérification du tri selon l'ORDRE(continent, nom), d'un vecteur de Pays
    public static boolean verifTriContNom(ArrayList<Pays> vPays) {
        // { } => { résultat = vrai si vPays trié selon l'ORDRE(continent, nom)
        int i = 1;

        while (i < vPays.size() && vPays.get(i - 1).compareTo(vPays.get(i)) < 0) {
            i++;
        }

        return i == vPays.size();
    }

    //a) Recherche dichotomique de l'indice d'un pays de continent et de nom donnés – FORME ITÉRATIVE
    public static int indDichoIter(ArrayList<Pays> vPays, String contP, String nomP) {
        // { vPays trié selon l'ORDRE(continent, nom) } =>
        // { résultat = * indice dans vPays du pays de continent contP et de nom nomP,
        // si trouvé
        // * -1 si non trouvé

        Pays unPays = new Pays(nomP, contP, 0, 0);

        if (vPays.isEmpty() || vPays.get(vPays.size() - 1).compareTo(unPays) < 0) {
            return -1;
        } else {
            int inf = 0;
            int sup = vPays.size() - 1;
            while (inf < sup) {
                int mid = (inf + sup) / 2;
                if (vPays.get(mid).compareTo(unPays) >= 0) {
                    sup = mid;
                } else {
                    inf = mid + 1;
                }
            }

            if (vPays.get(inf).compareTo(unPays) == 0) {
                return inf;
            } else {
                return -1;
            }
        }

    }


    //b) Recherche dichotomique de l'indice d'un pays de continent et de nom donnés – FORME RÉCURSIVE
    //le point d'entrée
    public static int indDichoRec(ArrayList<Pays> vPays, String contP, String nomP) {
        // { vPays trié selon l'ORDRE(continent, nom) } =>
        // { résultat = * indice dans vPays du pays de continent contP et de nom nomP,
        // si trouvé
        // * -1 si non trouvé

        Pays unPays = new Pays(nomP, contP, 0, 0);

        if (vPays.get(vPays.size() - 1).compareTo(unPays) < 0) {
            return -1;
        } else {
            return indDichoWorker(vPays, contP, nomP, 0, vPays.size() - 1);
        }

    }

    //le worker (récursif)
    public static int indDichoWorker(ArrayList<Pays> vPays, String contP, String nomP, int inf, int sup) {
        // { vPays trié selon l'ORDRE(continent,nom), 0<=inf<=sup<vPays.size() } =>
        // { résultat = * indice dans vPays[inf..sup] du pays de continent contP et de
        // nom nomP, si trouvé
        // * -1 si non trouvé

        Pays unPays = new Pays(nomP, contP, 0, 0);

        if (inf == sup) {
            if (vPays.get(inf).compareTo(unPays) == 0) {
                return inf;
            } else {
                return -1;
            }
        } else {
            int mid = (inf + sup) / 2;
            if (vPays.get(mid).compareTo(unPays) >= 0) {
                return indDichoWorker(vPays, contP, nomP, inf, mid);
            } else {
                return indDichoWorker(vPays, contP, nomP, mid + 1, sup);
            }
        }
    }

    //a) Nombre de pays d'un continent donné, ayant moins de X habitants – FORME ITÉRATIVE
    public static int nbPaysDeContInfNbHabIter(ArrayList<Pays> vPays, String unCont, int popMax) {
        // { vPays trié selon l'ORDRE(continent, nom), popMax > 0 } =>
        // { résultat = nombre d'éléments de vPays de continent unCont
        // et de population < popMax

        int nbPays = 0;
        int i = 0;

        while(i < vPays.size() && vPays.get(i).getContinent().compareTo(unCont) < 0){
            i++;
        }

        while(vPays.get(i).getContinent().compareTo(unCont) == 0){
            if(vPays.get(i).getPopulation() < popMax){
                nbPays++;
            }
            i++;
        }
        return nbPays;
    }

    //b) Nombre de pays d'un continent donné, ayant moins de X habitants – FORME RÉCURSIVE
    // le point d'entrée
    public static int nbPaysDeContInfNbHabRec(ArrayList<Pays> vPays, String unCont, int popMax) {
        // { vPays trié selon l'ORDRE(continent, nom), popMax > 0 } =>
        // { résultat = nombre d'éléments de vPays de continent unCont
        // et de population < popMax

        return nbPaysDeContInfNbHabWorker(vPays,unCont,popMax,0);
    }

    //le worker (récursif)
    public static int nbPaysDeContInfNbHabWorker(ArrayList<Pays> vPays, String unCont, int popMax, int ind) {
        // { vPays[ind..vPays.size()-1] trié selon l'ORDRE(continent, nom),
        // 0<=ind<vPays.size(), popMax > 0 } =>
        // { résultat = nombre d'éléments de vPays[ind..vPays.size()-1]
        // de continent unCont et de population < popMax

        if (ind == vPays.size() - 1) {
            if (vPays.get(ind).getContinent().compareTo(unCont) == 0 && vPays.get(ind).getPopulation() < popMax) {
                return 1;
            } else {
                return 0;
            }
        } else{
            if(vPays.get(ind).getContinent().compareTo(unCont) == 0 && vPays.get(ind).getPopulation() < popMax){
                return 1 + nbPaysDeContInfNbHabWorker(vPays,unCont,popMax,ind+1);
            }else{
                return nbPaysDeContInfNbHabWorker(vPays,unCont,popMax,ind+1);
            }
        }
    }
}

