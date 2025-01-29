import java.util.Scanner;

public class Jeu {
    public static void main(String[] args) {
        String nom;
        int anNaiss;
        float pointure;
        Scanner lecteur = new Scanner(System.in);

        System.out.println("BONJOUR !");

        System.out.println("Donner votre nom: ");
        nom = lecteur.nextLine();

        System.out.println("Donner votre année de naissance: ");
        anNaiss = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Donner votre pointure: ");
        pointure = lecteur.nextFloat();
        lecteur.nextLine();

        System.out.println("(1) On multiplie votre pointure par 5 :" + pointure*5);
        System.out.println("(2) On ajoute 50 :" + ((pointure*5) + 50));
        System.out.println("(3) On multiplie par 20: " + ((pointure*5) + 50)*20);
        System.out.println("(4) On ajoute 1023: " + ((((pointure*5) + 50)*20) + 1023));
        System.out.println("(5) On soustrait votre année de naissance: ");

        System.out.println("------------------");
        float RESULTAT = (((((pointure*5) + 50) * 20) + 1023) - anNaiss);
        System.out.println("RESULTAT = " + RESULTAT);
        System.out.println("------------------");


        System.out.println("Les 2 premiers chiffres sont: " + (int) RESULTAT/100);
        System.out.println("> C'est votre pointure !!!");

        System.out.println("Les 2 derniers chiffres sont: " + (int) RESULTAT%100);
        System.out.println("> C'est l'âge que vous atteignez cette année !!!");

        System.out.println("AU REVOIR " + nom + ' ' + '!');

    }
}
