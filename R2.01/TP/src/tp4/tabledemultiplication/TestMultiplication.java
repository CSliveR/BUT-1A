package tp4.tabledemultiplication;

import java.util.Scanner;

public class TestMultiplication {
    public static void main(String[] args){
        Scanner lecteur = new Scanner(System.in);
        int nombreTable;
        int choix;
        boolean modeSansErreur;

        System.out.println("Donner un nombre pour la table de multiplication entre 1 et 10 : ");
        do{
            nombreTable = lecteur.nextInt();
            lecteur.nextLine();
            if(nombreTable < 1 | nombreTable > 10){
                System.out.println("Merci de répondre entre 1 et 10 ? ");
            }
        }while(nombreTable < 1 | nombreTable > 10);

        System.out.println("Entrainement 1 ou exercice 2 ? ");
        do{
            choix = lecteur.nextInt();
            lecteur.nextLine();
            if(choix != 1 & choix != 2){
                System.out.println("Merci de répondre par 1 ou 2 ? ");
            }
        }while(choix != 1 & choix != 2);

        System.out.println("Mode sans erreur true ou false ? ");
        modeSansErreur = lecteur.nextBoolean();
        lecteur.nextLine();

        TableDeMultiplication table = new TableDeMultiplication(nombreTable,choix == 2, modeSansErreur);

        if(modeSansErreur){
            for(int i=0; i < table.getNombreDeMultiplications();i++){
                demandeReponseUtilisateur(table.getMultiplication(i));}
        }else{
            System.out.println("Donnez les réponses aux multiplications : ");
            for(int i=0; i < table.getNombreDeMultiplications();i++){
                System.out.print(table.getMultiplication(i));
                try {
                    table.getMultiplication(i).setReponseUtilisateur(lecteur.nextInt());
                } catch (ErreurMultiplicationException e) {
                    table.getMultiplication(i);
                }
            }
            System.out.println("Nombre de réponses justes : " + table.getNombreReponsesJustes());
        }
    }

    private static void demandeReponseUtilisateur(Multiplication multiplication){
        Scanner entree = new Scanner(System.in);
        // Affichage de la multiplication
        System.out.print(multiplication);
        // Demander la réponse utilisateur
        int reponseUtilisateur = entree.nextInt();
        entree.nextLine();
        // Enregistrer la réponse utilisateur
        // Mode sans erreur : attraper l'exception si la réponse de
        // l'utilisateur n'est pas la bonne et redemander la reponse
        // utilisateur
        // A COMPLETER

        try {
            multiplication.setReponseUtilisateur(reponseUtilisateur);
        } catch (ErreurMultiplicationException e) {
            System.out.println("Votre réponse n'est pas correcte, réessayez ! ");
            demandeReponseUtilisateur(multiplication);
        }


    }
}
