import java.util.ArrayList;

public class Utilitaire {
    public static ListeChainee<PaysDeCont> countries(ArrayList<Pays> mondeT, String cont) {
        // { mondeT non vide, trié selon l'ORDRE (continent, nom) } =>
        // { résultat = liste chainée des pays du continent cont, TRIÉE par nom
        ListeChainee<PaysDeCont> Pdc = new ListeChainee<>();
        int i = 0;

        while(i < mondeT.size()){
            if(mondeT.get(i).getContinent().compareTo(cont) == 0){
                Pdc.insereAtPosit((i+1)-i,new PaysDeCont(mondeT.get(i).getNom(),mondeT.get(i).getPopulation(),mondeT.get(i).getSuperficie()));
            }
            i++;
        }

        return Pdc;
    }

    //(a) Affichage des éléments de la liste des pays d'un continent donné – ALGORITHME RÉCURSIF
    //le point d'entrée
    public static void affichePaysDeCont(ListeChainee<PaysDeCont> listePdeC) {
        // { listePdeC non vide } =>
        // { l'information portée par chaque celle de listePdeC a été affichée
        // ligne à ligne, précédée par sa position dans listePdeC

        affichePaysDeCont_wk(listePdeC.getLongueur(), listePdeC.getTete());
    }

    //le worker (récursif)
    private static void affichePaysDeCont_wk(int pos, Cellule<PaysDeCont> cellCour) {
        //INDICATION : Pour coder cette procédure, vous pouvez vous inspirer de la méthode AfficheGaucheDroiteRec de la classe ListeChainee

        if (cellCour != null) {
            affichePaysDeCont_wk(pos-1,cellCour.getCelluleSuivante());
            System.out.print(pos + " -" + cellCour.getInfo() + "\n");
        }
    }

    //Nom et nombre de pays des continents comptant le plus, respectivement le moins, de pays (il n'y a pas d'ex aequo)
    public static void contExtremes(ArrayList<String> vCont, ArrayList<ListeChainee<PaysDeCont>>vListesPdeC) {
        // { * vCont, trié et non vide : vecteur des continents du monde
        // * vListesPdeC, non vide : vecteur des listes de pays de ces continents
        // dans l'ordre des continents de vCont } =>
        // { le nom et le nombre de pays du continent qui a le plus de pays est affiché,
        // ainsi que le nom et le nombre de pays du continent qui a le moins de pays

        int nbPaysDeContMax = vListesPdeC.get(0).getLongueur();
        int nbPaysDeContMin = vListesPdeC.get(0).getLongueur();
        String nomContMax = vCont.get(0);
        String nomContMin = vCont.get(0);

        for (int i=0; i < vListesPdeC.size();i++) {
            if (vListesPdeC.get(i).getLongueur() > nbPaysDeContMax) {
                nbPaysDeContMax = vListesPdeC.get(i).getLongueur();
                nomContMax = vCont.get(i);
            }

            if (vListesPdeC.get(i).getLongueur() < nbPaysDeContMin) {
                nbPaysDeContMin = vListesPdeC.get(i).getLongueur();
                nomContMin = vCont.get(i);
            }
        }

        System.out.println("Continent comptant le plus de pays" + " : "  + nomContMax + " (" + nbPaysDeContMax + " pays)");
        System.out.println("Continent comptant le moins de pays" + " : " + nomContMin + " (" + nbPaysDeContMin + " pays)");
    }

    //(a) Liste triée des noms des pays d'un continent donné
    public static ListeChainee<String> listeNomsPdeC (String unCont, ListeChainee<PaysDeCont> listePDeC) throws ExceptionMauvaisIndice {
        // { * unCont est le nom d'un continent
        // * listePdeC contient les pays de unCont, triés par nom } =>
        // { résultat = liste triée dont chaque élément est une chaîne construite par
        // concaténation de unCont entre parenthèses, aux nom d'un pays
        // EXEMPLE : "Andorre (Europe)"

        ListeChainee<String> paysDeCont = new ListeChainee<>();

        for(int i=1; i < listePDeC.getLongueur()+1;i++){
            paysDeCont.insereTete(listePDeC.getInfoAtPosit(i).getNom() + " (" + unCont + ")" + "\n");
        }
        return paysDeCont;
    }

    //(b) Rang que devrait occuper une chaine donnée lors de son insertion dans une liste de String triée
    public static int posInsert(ListeChainee<String> uneListe, String uneChaine) throws ExceptionMauvaisIndice {
        // { uneListe triée, éventuellement vide } =>
        // { résultat = rang que devrait occuper uneChaine lors de son insertion dans
        // uneListe, pour que le tri soit respecté

        int i = 1;

        while(i < uneListe.getLongueur() && uneListe.getInfoAtPosit(i).compareTo(uneChaine) < 0){
            i++;
        }

        if(uneListe.getInfoAtPosit(i).compareTo(uneChaine) >= 0){
            return i;
        }else {
            return 1;
        }
    }

    //(c) Liste triée des noms de tous les pays du monde
    public static ListeChainee<String> listeNomsPaysDuMonde(ArrayList<String> vCont, ArrayList<ListeChainee<PaysDeCont>> vListesPdeC ) throws ExceptionMauvaisIndice {
        // { * vCont, trié et non vide : vecteur des continents du monde
        // * vListesPdeC, non vide : vecteur des listes de pays de ces continents } =>
        // { résultat = liste triée dont dont chaque élément est le nom d'un pays du
        // monde, concaténé au nom de son continent entre parenthèses

        ListeChainee<String> liste_res = new ListeChainee<>();

        for(int i=0; i < vCont.size();i++){
            ListeChainee<String> listNomPaysDeCont = listeNomsPdeC(vCont.get(i),vListesPdeC.get(i+1));
            for(int j=1; j < listNomPaysDeCont.getLongueur()+1;j++){
                int pos = posInsert(liste_res,vCont.get(i));
                liste_res.insereAtPosit(pos,vCont.get(i));
            }
        }
        return liste_res;
    }



}
