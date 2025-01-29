import java.util.ArrayList;
import java.util.Arrays;

public class ListesIntegerTriees {
    public static void main(String[] args) {
        ArrayList<Integer> vIntTest = new ArrayList(Arrays.asList(31, 1, 46, 35, 5, 32, 14, 49, 19, 28, 2, 30, 32, 12, 20));

        ListeTrieeD<Integer> listIntD = new ListeTrieeD<>();
        for(int i=0; i < vIntTest.size();i++){
            listIntD.insereTrie(vIntTest.get(i));
        }

        System.out.println("* Liste triée décroissante initialisée avec les éléments du vecteur vIntTest: ");
        listIntD.afficheGD();

        ArrayList<Integer> vIntRandom1 = new ArrayList<>();
        ArrayList<Integer> vIntRandom2 = new ArrayList<>();

        for(int i=0; i < 20; i++){
            vIntRandom1.add((int) (Math.random()*40));
        }

        for(int i=0; i < 15;i++){
            vIntRandom2.add((int) (Math.random()*40));
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("Génération de listes triées croissantes à partir de vecteurs initialisés aléatoirement");
        System.out.println("------------------------------------------------------------------------------------------------------------");

        System.out.println();
        System.out.println("* Vecteur de 20 entiers choisis aléatoirement dans [0..40] (vIntRandom1) ");
        System.out.println(vIntRandom1);
        System.out.println();
        System.out.println("* Vecteur de 15 entiers choisis aléatoirement dans [0..40] (vIntRandom2) ");
        System.out.println(vIntRandom2);

        ListeTrieeC<Integer> listIntC1 = new ListeTrieeC<>();
        ListeTrieeC<Integer> listIntC2 = new ListeTrieeC<>();

        for(int i=0; i < vIntRandom1.size();i++){
            listIntC1.insereTrie(vIntRandom1.get(i));
        }

        for(int i=0; i < vIntRandom2.size();i++){
            listIntC2.insereTrie(vIntRandom2.get(i));
        }
        System.out.println();
        System.out.println("* Liste triée croissante (listIntC1), générée à partir de vIntRandom1");
        listIntC1.afficheGD();
        System.out.println();
        System.out.println("* Liste triée croissante (listIntC2), générée à partir de vIntRandom2");
        listIntC2.afficheGD();

        System.out.println();

        ListeTrieeC<Integer>listIntC1_sdb = Utilitaire.lCsansDoublons(listIntC1);
        ListeTrieeC<Integer>listIntC2_sdb = Utilitaire.lCsansDoublons(listIntC2);

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("Génération de listes triées croissantes à partir de listIntC1 et listIntC2");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        System.out.println();
        System.out.println("* Liste triée croissante (listIntC1_sdb), générée à partir de listIntC11");
        listIntC1_sdb.afficheGD();
        System.out.println();
        System.out.println("* Liste triée croissante (listIntC2_sdb), générée à partir de listIntC2");
        listIntC2_sdb.afficheGD();

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("Listes triées croissantes résultant de l'union puis l'intersection de listIntC1_sdb et listIntC2_sdb");
        System.out.println("-------------------------------------------------------------------------------------------------------------");

        System.out.println();
        System.out.println("* Liste triée croissante résultant de l'union de listIntC1_sdb et listIntC2_sdb");
        Utilitaire.lCsansDoublons(Utilitaire.union(listIntC1_sdb,listIntC2_sdb)).afficheGD();
        System.out.println();
        System.out.println("* Liste triée croissante résultant de l'intersection de listIntC1_sdb et listIntC2_sdb");
        Utilitaire.intersect(listIntC1_sdb,listIntC2_sdb).afficheGD();
    }
}
