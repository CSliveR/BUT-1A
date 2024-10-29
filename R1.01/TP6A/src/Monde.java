import java.util.ArrayList;
import java.util.Scanner;

public class Monde {
    public static void main(String[] args) {
        ArrayList<Pays> leMonde = InitMonde.creerMonde();
        ArrayList<String> lesContinents = new ArrayList<>();
        int indCont;


        for (int i=0; i < leMonde.size(); i++){
            //System.out.println(leMonde.get(i)); //Pour chaque élément i du vecteur, on affiche ses attributs

            indCont = Utilitaire.indContinent(lesContinents, leMonde.get(i).getContinent());

            if(indCont != -1){
                lesContinents.add(indCont,leMonde.get(i).getContinent());
            }
        }

        //System.out.println(lesContinents);

        String cont = Utilitaire.saisieCont(lesContinents);
        ArrayList<Pays> vPaysDeCont = Utilitaire.paysDeCont(leMonde,cont);
        Scanner lecteur = new Scanner(System.in);

        System.out.println("----------------------");
        System.out.println("-Premier pays de ce continent: " + vPaysDeCont.get(0).getNom());
        System.out.println("-Dernier pays de ce continent: " + vPaysDeCont.get(vPaysDeCont.size()-1).getNom());
        System.out.println("-Nombre de pays: " + vPaysDeCont.size());
        System.out.println("----------------------");
        System.out.println("Donner le nom d'un pays: ");
        String nomPays = lecteur.nextLine();

        if (Utilitaire.rechPaysT(vPaysDeCont,nomPays) == vPaysDeCont.size()){
            System.out.println("Ce pays n'est pas dans le continent " + cont + "....");
        }else{
            System.out.println(vPaysDeCont.get(Utilitaire.rechPaysT(vPaysDeCont,nomPays)));
        }

        System.out.println("-----------------------------------");
        System.out.println("Pays le(s) moins peuplé(s): ");
        System.out.println("-----------------------------------");
        Utilitaire.paysMoinsPeuples(leMonde);
        System.out.println("---------------------------------------------------------");
        Utilitaire.contExtremes(leMonde,lesContinents);
        System.out.println("---------------------------------------------------------");
    }

}
