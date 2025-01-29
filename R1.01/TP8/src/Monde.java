import java.util.ArrayList;
import java.util.Scanner;

public class Monde {
    public static void main(String[] args) {
        ArrayList<Pays> leMonde = InitMonde.creerMonde();
        Pays plusGrandPaysIter = Utilitaire.plusGrandPaysIter(leMonde);
        Pays plusGrandPaysDPR = Utilitaire.plusGrandPaysDPR(leMonde);
        int indMinPopIter = Utilitaire.indMinPopIter(leMonde);
        int indMinPopDPR = Utilitaire.indMinPopDPR(leMonde);

        Scanner lecteur = new Scanner(System.in);

        System.out.println("---------------------------------------------");
        System.out.println("PAYS DE PLUS GRANDE SUPERFICIE");
        System.out.println("---------------------------------------------");
        System.out.println("* Pays trouvé par parcours itératif :");
        System.out.println(plusGrandPaysIter);
        System.out.println("* Pays trouvé par parcours récursif :");
        System.out.println(plusGrandPaysDPR);

        System.out.println("---------------------------------------------");
        System.out.println("INDICE DU PAYS LE MOINS PEUPLÉ");
        System.out.println("---------------------------------------------");
        System.out.println("* indice trouvé par parcours itératif : " + indMinPopIter);
        System.out.println("* indice trouvé par parcours récursif : " + indMinPopDPR);
        System.out.println("Caractéristiques de l'élément " + indMinPopDPR + " : " + leMonde.get(indMinPopDPR));

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("TRI DU VECTEUR LEMONDE SELON L'ORDRE(continent nom)");
        System.out.println("------------------------------------------------------------------------------");
        ArrayList<Pays> leMondeTrie = Utilitaire.triBulleContNom(leMonde);
        if (Utilitaire.verifTriContNom(leMondeTrie)) {
            System.out.println("* Vérification du tri: vecteur trié selon l'ordre défini");
        }else{
            System.out.println("* Vérification du tri: vecteur pas trié selon l'ordre défini");
        }

        System.out.println("------------------------------------------------------------------------------");
        System.out.println("INDICE D'UN PAYS DANS LE VECTEUR TRIÉ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("- Entrez le nom d'un continent: ");
        String unCont = lecteur.nextLine();
        System.out.println("- Entrez le nom d'un pays: ");
        String unPays = lecteur.nextLine();

        int indDichoIter = Utilitaire.indDichoIter(leMondeTrie,unCont,unPays);
        int indDichoRec = Utilitaire.indDichoRec(leMondeTrie,unCont,unPays);

        System.out.println("* Indice trouvé par recherche dichotomique itérative : " + indDichoIter);
        System.out.println("* Indice trouvé par recherche dichotomique récursive : " + indDichoRec);

        if(indDichoIter != -1){
            System.out.println("Vérification : caractéristiques du pays d'indice " + leMondeTrie.get(indDichoIter));
        }else{
            System.out.println(unPays + " n'est pas en " + unCont);
        }

        System.out.println("Entrez un nombre d'habitants >= 0:");
        int popMax = lecteur.nextInt();
        lecteur.nextLine();

        int nbPaysDeContInfNbHabIter = Utilitaire.nbPaysDeContInfNbHabIter(leMondeTrie,unCont,popMax);
        int nbPaysDeContInfNbHabRec = Utilitaire.nbPaysDeContInfNbHabRec(leMondeTrie,unCont,popMax);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("NOMBRE DE PAYS DE MOINS DE " + popMax + " HABITANTS SITUES EN " + unCont.toUpperCase());
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("* Nombre de pays trouvé par parcours itératif : " + nbPaysDeContInfNbHabIter);
        System.out.println("* Nombre de pays trouvé par parcours récursif: " + nbPaysDeContInfNbHabRec);



    }
}
