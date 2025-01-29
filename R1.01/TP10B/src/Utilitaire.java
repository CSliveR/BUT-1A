import java.util.ArrayList;

public class Utilitaire {
    public static void afficheListeCat(ListeTrieeC<Categorie> lCategories) {
        // { } => { les éléments de lCategories ont été affichés }
        Cellule<Categorie> catCour = lCategories.getTete();
        System.out.println("LISTE DES CATEGORIES D'INSTRUMENTS");
        for (int i = 0; i < lCategories.getLongueur(); i++) {
            catCour.getInfo().afficheCat();
            System.out.println(" " + '↡');
            catCour = catCour.getCelluleSuivante();
        }
    }

    //(a) recherche d'un instrument de nom donné dans une catégorie de nom donné
    public static Instrument chercheInstrument(ListeTrieeC<Categorie> lCategories, String nomCat, String nomInst) {
        // { } =>
        // { résultat = Instrument dont l'attribut nomInstrument est nomInst si trouvé,
        // null sinon

        Cellule<Categorie> cellCour = lCategories.getTete();

        while(cellCour != null && cellCour.getInfo().getNomCat().compareTo(nomCat) != 0){
            cellCour = cellCour.getCelluleSuivante();
        }


        if(cellCour != null && cellCour.getInfo().getlInstruments().getTete().getInfo().getNomInstrument().compareTo(nomInst) == 0){
            return cellCour.getInfo().getlInstruments().getTete().getInfo();
        }else{
            return null;
        }
    }

    //(b) vecteur trié croissant des noms des différentes catégories
    public static ArrayList<String> vNomsDesCat(ListeTrieeC<Categorie> lCategories) {
        // { } =>
        // { résultat = vecteur de chaînes trié croissant, contenant les valeurs de
        // l'attribut nomCat de chaque élément de lCategories

        ArrayList<String> vNomDesCat = new ArrayList<>();
        Cellule<Categorie> cellCour = lCategories.getTete();

        while(cellCour != null){
            vNomDesCat.add(cellCour.getInfo().getNomCat());
            cellCour = cellCour.getCelluleSuivante();
        }

        int i=0;
        String premString = vNomDesCat.get(0);

        while (i < vNomDesCat.size() && vNomDesCat.get(i).compareTo(premString) < 0){
            vNomDesCat.add(0,vNomDesCat.get(i));
            premString = vNomDesCat.get(i);
            vNomDesCat.remove(vNomDesCat.get(i));
            i++;
        }

        return vNomDesCat;
    }

    //(c) vecteur trié croissant des noms des instruments d'une catégorie d'un nom donné
    public static ArrayList<String> vNomsDesInsDeCat(ListeTrieeC<Categorie> lCategories, String nomCat) {
        // { } =>
        // { résultat = vecteur de chaînes trié croissant, contenant les valeurs de
        // l'attribut nomInst de chaque élément de la liste d'instruments
        // de la catégorie de nom nomCat

        ArrayList<String> vNomsDesInsDeCat = new ArrayList<>();
        Cellule<Categorie> cellCour = lCategories.getTete();

        while(cellCour != null){
            vNomsDesInsDeCat.add(cellCour.getInfo().getlInstruments().getTete().getInfo().getNomInstrument());
            cellCour = cellCour.getCelluleSuivante();
        }
        return vNomsDesInsDeCat;
    }


    

}
