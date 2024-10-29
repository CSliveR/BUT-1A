import java.util.ArrayList;

public class UtilitairePaireChaineEntier {
    public static int indicePourChaine(ArrayList<PaireChaineEntier> listePaires, String chaine) {
        //{} => {retourne l’indice de chaine dans listePaires si chaine est présente et -1 sinon.}

        int i = 0;
        while (i < listePaires.size() && listePaires.get(i).getChaine().compareToIgnoreCase(chaine) != 0) {
            i++;
        }
        if (i == listePaires.size()) {
            return -1;
        } else {
            return i;
        }
    }


    public static int entierPourChaine(ArrayList<PaireChaineEntier> listePaires, String chaine) {
        // {} => {retourne l’entier associé à la chaîne de caractères chaine dans listePaires si elle est présente et 0 sinon.}
        int i = 0;

        while (i < listePaires.size() && listePaires.get(i).getChaine().compareToIgnoreCase(chaine) != 0) {
            i++;
        }

        if (i == listePaires.size()) {
            return 0;
        } else {
            return listePaires.get(i).getEntier();
        }

    }


    public static String chaineMax(ArrayList<PaireChaineEntier> listePaires) {
        //{} => {retourne la chaine associé au plus grand entier de listePaires}

        int indMax = 0;

        for (int i = 0; i < listePaires.size(); i++) {
            if (listePaires.get(i).getEntier() > listePaires.get(indMax).getEntier()) {
                indMax = i;
            }
        }
        return listePaires.get(indMax).getChaine();
    }


    public static float moyenne(ArrayList<PaireChaineEntier> listePaires) {
        //{} => {retourne la moyenne des entiers stockés dans listePaires.}

        float somme = 0.0f;

        for (int i = 0; i < listePaires.size(); i++) {
            somme = somme + listePaires.get(i).getEntier();
        }

        return somme / listePaires.size();
    }


    public static ArrayList<PaireChaineEntier> listEntierPourChaqueCat(ArrayList<Categorie> categories) {
        //{}
        ArrayList<PaireChaineEntier> listEntier = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            listEntier.add(i, new PaireChaineEntier(categories.get(i).getNom(), 0));
            //System.out.println(listEntier.get(0).getChaine());
        }
        return listEntier;

    }


    public static boolean affichageListesPaire(ArrayList<PaireChaineEntier> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getChaine() + " " + list.get(i).getEntier());
        }
        return true;
    }


    public static void triElement(ArrayList<PaireChaineEntier> lexiqueTri, String element) {
        // { lexique triée} => { élément inséré au bon indice si il n'existe pas déjà
        // en utilisant la méthode DU TRI À BULLES AMÉLIORÉ

        boolean onContinue = true;

        int compa;
        int j = 0;
        while (onContinue && j < lexiqueTri.size()) {        //On stop sans rajouter l'élément si lexiqueTri.get(j).getChaine()=élément

            onContinue = false;

            compa = element.compareTo(lexiqueTri.get(j).getChaine());
            if (compa > 0) {               //Quand element>lexiqueTri.get(j).getChaine() on continue
                onContinue = true;
            } else if (compa < 0) {
                lexiqueTri.add(j, new PaireChaineEntier(element, 0));
            }

            j++;
        }
    }

    public static PaireResultatCompteur<Integer> indicePourChaineNbComp(ArrayList<PaireChaineEntier> listePaires, String chaine) {
        //{} => {retourne l’indice de chaine dans listePaires si chaine est présente et -1 sinon.}

        int i = 0;
        int nbComparaison=0;
        while (i < listePaires.size() && listePaires.get(i).getChaine().compareToIgnoreCase(chaine) != 0) {
            nbComparaison++;            //On compte qu'une seule compa à chaque boucle while
            i++;
        }
        nbComparaison++;        //Compa lors de l'arrêt de la boucle
        nbComparaison++;        //Concerne la condition juste en dessous
        if (i == listePaires.size()) {
            return new PaireResultatCompteur<>(-1,nbComparaison);
        } else {
            return new PaireResultatCompteur<>(i,nbComparaison);
        }
    }


    /*
//Fonctions n'ayant jamais trouvé une utilité

    public static boolean verifTri(ArrayList<PaireChaineEntier> lexique){
        int i=1;

        while(i < lexique.size() && lexique.get(i-1).getChaine().compareTo(lexique.get(i).getChaine()) < 0){
            i++;
        }

        return i == lexique.size();
    }


    public static int indicePourChaineT(ArrayList<PaireChaineEntier> listePaires, String chaine) {
        // { listePaires trié selon chaine, listePaires peut être vide} => {
        int i = 0;
        if (listePaires.isEmpty() || listePaires.get(listePaires.size() - 1).getChaine().compareTo(chaine) < 0) {
            return -1;
        } else {
            int inf = 0;
            int sup = listePaires.size() - 1;

            while (inf < sup) {
                int mid = (inf + sup) / 2;

                if (listePaires.get(mid).getChaine().compareTo(chaine) > 0) {
                    inf = mid + 1;
                } else {
                    sup = mid;
                }
            }
            System.out.println(listePaires.get(inf).getChaine() + " " + chaine);
            if (listePaires.get(inf).getChaine().compareTo(chaine) == 0) {
                return inf;
            } else {
                return -1;
                //    }

            }
        }
    }
        public static boolean existePaireChaineEntier(ArrayList<PaireChaineEntier> listePaires, String chaine){
            int i=0;

            while(i < listePaires.size() && listePaires.get(i).getChaine().compareTo(chaine) < 0){
                i++;
            }

            return i != listePaires.size();

        }



        public static ArrayList<PaireChaineEntier> rajouterMot(ArrayList<PaireChaineEntier> list, String mot) {
            int ind = indicePourChaine(list, mot);
            if (ind == -1) {                   //Si le mot cat n'existe pas alors on rajoute dans la liste
                list.add(new PaireChaineEntier(mot, 0));
                return list;
            } else {                        //Sinon on rajoute 1 à son compteur
                list.get(ind).ajoutEntier(1);
                return list;
            }

        }



*/



}




