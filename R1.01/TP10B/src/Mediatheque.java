import java.util.ArrayList;
import java.util.Scanner;

public class Mediatheque {
    public static void main(String[] args){
        ListeTrieeC<Categorie> lCategories = new ListeTrieeC<>();

        Categorie c1 = new Categorie("casserolerie",new ListeTrieeC<>());
        Categorie c2 = new Categorie("vaisselle",new ListeTrieeC<>());

        lCategories.insereTrie(c1);
        lCategories.insereTrie(c2);

        c1.getlInstruments().insereTrie(new Instrument("wok",3));
        c2.getlInstruments().insereTrie(new Instrument("verre ballon",10));
        c2.getlInstruments().insereTrie(new Instrument("assiette",5));

        Utilitaire.afficheListeCat(lCategories);

        System.out.println("EMPRUNT DE 2 WOKS DANS LA CATEGORIE CASSEROLLERIE: ");

        try {
            c1.getlInstruments().getInfoAtPosit(1).retraitExemplaires(2);
        } catch (ExceptionDefautDispo | ExceptionMauvaisIndice e) {
            System.out.println(e.getMessage());
        }

        Utilitaire.afficheListeCat(lCategories);

        System.out.println();

        System.out.println("EMPRUNT DE 15 VERRES BALLON DANS LA CATEGORIE VAISSELLE");
        try {
            c2.getlInstruments().getInfoAtPosit(2).retraitExemplaires(15);
        } catch (ExceptionDefautDispo | ExceptionMauvaisIndice e) {
            System.out.println(e.getMessage());
        }

        Utilitaire.afficheListeCat(lCategories);

        System.out.println();

        try {
            c1.getlInstruments().getInfoAtPosit(1).renduExemplaires(1);
        } catch (ExceptionMauvaisIndice e) {
            System.out.println(e.getMessage());
        }

        Utilitaire.afficheListeCat(lCategories);

        System.out.println();

        Pret unPret = new Pret(1,new ArrayList<>());

        Scanner lecteur = new Scanner(System.in);
        String saisieCat;

        ArrayList<String> vNomsDesCat = Utilitaire.vNomsDesCat(lCategories);


        do{
            System.out.println("Choisissez un nom de catégorie " + Utilitaire.vNomsDesCat(lCategories));
            saisieCat = lecteur.nextLine();
        }while(vNomsDesCat.get(1).compareTo(saisieCat) != 0);



        System.out.println("Choississez parmi ces instruments : ");
        lCategories.getTete().getInfo().getlInstruments().afficheGD();

    }
}
