package tp1;

import java.util.Scanner;

public class TestString {
    public static void main(String[] args) {
        Scanner entree = new Scanner(System.in);
        System.out.println("Donnez une chaine de caractères maChaine : ");
        String maChaine = entree.nextLine();
        System.out.println(maChaine);


        System.out.println("Nombre de caractères de la chaine de caractères " + maChaine + " : " + maChaine.length());
        System.out.println("La chaine de caractères " + maChaine + " en majuscule : " + maChaine.toUpperCase());

        System.out.println("Donnez une deuxième chaine de caractères deuxiemeChaine : ");
        String maChaine2 = entree.nextLine();

        if(maChaine2.compareToIgnoreCase(maChaine) == 0){
            System.out.println("Les deux chaines sont identiques - sans tenir compte de la casse.");
        }else{
            System.out.println("Les deux chaines ne sont pas identiques - sans tenir compte de la casse.");
        }


        if(maChaine.compareTo(maChaine.toLowerCase()) == 0){
            System.out.println("La chaine de caractères " + maChaine + " est en minuscule.");
        }else{
            System.out.println("La chaine de caractères " + maChaine + " n'est pas en minuscule.");
        }

        System.out.println("La chaine de caractères " + maChaine + " en majuscule sans les 'blancs' en début " +
                "et fin de chaine " + maChaine.trim().toUpperCase());


        StringBuilder sb = new StringBuilder(maChaine);
        StringBuilder maChaineReversed = sb.reverse();

        if(maChaine.compareTo(maChaineReversed.toString()) == 0){
            System.out.println("La chaine de caractères " + maChaine + " est un palindrome.");
        }else{
            System.out.println("La chaine de caractères " + maChaine + " n'est pas un palindrome.");
        }





    }
}
