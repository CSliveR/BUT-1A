import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PaysDesContinents {
    public static void main(String[] args) throws ExceptionMauvaisIndice {
        ArrayList<Pays> mondeT = new ArrayList<>(InitMondeT.creerMondeT());
        ArrayList<String> vContinents = new ArrayList<>(Arrays.asList("Afrique","Amériques", "Antarctique", "Asie", "Europe", "Océanie"));
        Scanner lecteur = new Scanner(System.in);

        ListeChainee<PaysDeCont> listeAfrique = Utilitaire.countries(mondeT,"Afrique");
        ListeChainee<PaysDeCont> listeAmeriques = Utilitaire.countries(mondeT,"Amériques");
        ListeChainee<PaysDeCont> listeAntarctique = Utilitaire.countries(mondeT,"Antarctique");
        ListeChainee<PaysDeCont> listeAsie = Utilitaire.countries(mondeT,"Asie");
        ListeChainee<PaysDeCont> listeEurope = Utilitaire.countries(mondeT,"Europe");
        ListeChainee<PaysDeCont> listeOceanie = Utilitaire.countries(mondeT,"Océanie");

        System.out.println("* Afrique : " + listeAfrique.getLongueur() + " pays");
        System.out.println("* Amériques : " + listeAmeriques.getLongueur() + " pays");
        System.out.println("* Antarctique : " + listeAntarctique.getLongueur() + " pays");
        System.out.println("* Asie : " + listeAsie.getLongueur() + " pays");
        System.out.println("* Europe : " + listeEurope.getLongueur() + " pays");
        System.out.println("* Océanie : " + listeOceanie.getLongueur() + " pays");


        String unCont = "";
        try{
            int i=0;
            do{
                System.out.println("Entrez un nom de continent choisi parmi : " + vContinents + " : ");
                unCont = lecteur.nextLine();

                if(i == vContinents.size()) {
                    i = 0;
                }

                while(i < vContinents.size() && vContinents.get(i).compareTo(unCont)!=0){
                    i++;
                }

                if (i == vContinents.size()){
                    System.out.println("--> Saisie invalide, recommencez...");
                }

            }while(i == vContinents.size());

        }catch(InputMismatchException e){
            System.out.println("--> Saisie invalide, recommencez...");
        }

        System.out.println("------------------------------------------------------------------");
        System.out.println(" Pays du continent " + unCont.toUpperCase());
        System.out.println("------------------------------------------------------------------");
        Utilitaire.affichePaysDeCont(Utilitaire.countries(mondeT,unCont));

        ArrayList<ListeChainee<PaysDeCont>> vListesPdeC;
        vListesPdeC = new ArrayList<>(Arrays.asList(listeAfrique,listeAmeriques,listeAntarctique,listeAsie,listeEurope,listeOceanie));

        Utilitaire.contExtremes(vContinents,vListesPdeC);

        ListeChainee<String> lNomPaysDuMonde = Utilitaire.listeNomsPaysDuMonde(vContinents,vListesPdeC);

        for(int i=1;i < lNomPaysDuMonde.getLongueur()+1; i++){
            lNomPaysDuMonde.afficheDroiteGaucheRec();
        }



    }
}
