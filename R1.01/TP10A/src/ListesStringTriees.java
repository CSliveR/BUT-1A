import java.util.Scanner;

public class ListesStringTriees {
    public static void main(String[] args) {
        ListeTrieeC<String> listStringC = new ListeTrieeC<>();
        listStringC.insereTrie("milou");
        listStringC.insereTrie("tintin");
        listStringC.insereTrie("rantanplan");

        System.out.println("------------------------------------------");
        System.out.println("* Liste triée croissante de chaînes: ");
        listStringC.afficheGD();
        System.out.println("------------------------------------------");
        System.out.println("* Recherche de la chaîne portée par une cellule de la liste");

        // test partie 2.3
        Scanner lecteur = new Scanner(System.in);
        int indice;
        char stop;
        do {
            // on fait saisir un entier et l'utilisateur est sage...
            System.out.println("Entrez un entier");
            indice = lecteur.nextInt();
            lecteur.nextLine();
            System.out.print("Information de la cellule " + indice + " ? ");
            try {
                System.out.println(listStringC.getInfoAtPosit(indice));
            } catch (ExceptionMauvaisIndice e) {
                System.out.println(e.getMessage());
            }
            System.out.print("Recommencer (o/n) ? ");
            stop = lecteur.next().charAt(0);
        } while (stop != 'n');


        System.out.println();

        System.out.println("* Modification de la chaîne portée par une cellule de la liste");

        do{
            lecteur = new Scanner(System.in);
            System.out.println("Entrez une chaine: ");
            String uneChaine;
            uneChaine = lecteur.nextLine();

            System.out.println();
            System.out.println("Cellule n°" + indice);
            System.out.println("--> nouvelle valeur : " + uneChaine);
            try{
                listStringC.setInfoAtPosit(indice, uneChaine);
            }catch (ExceptionMauvaisIndice | ExceptionViolationTri e){
                System.out.println(e.getMessage());
            }

            System.out.print("liste après modification : ");
            listStringC.afficheGD();
            System.out.print("Recommencer (o/n) ? ");
            stop = lecteur.next().charAt(0);
        }while(stop != 'n');

        System.out.println();
        System.out.print("CONTENU DE LA LISTE APRÈS MODIFICATION(S) : ");
        listStringC.afficheGD();
    }

}
