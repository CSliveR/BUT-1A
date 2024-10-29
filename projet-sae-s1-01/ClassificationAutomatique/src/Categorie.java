import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Categorie {

    private String nom; // le nom de la catégorie p.ex : sport, politique,...
    private ArrayList<PaireChaineEntier> lexique; //le lexique de la catégorie

    // constructeur
    public Categorie(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public  ArrayList<PaireChaineEntier> getLexique() {
        return lexique;
    }


    // initialisation du lexique de la catégorie à partir du contenu d'un fichier texte
    public void initLexique(String nomFichier) {
        // {} => {}
        //creation d'un tableau de dépêches
        //Categorie<PaireChaineEntier> depeches = new ArrayList<>();
        try {
            // lecture du fichier d'entrée
            FileInputStream file = new FileInputStream(nomFichier);
            Scanner scanner = new Scanner(file);
            this.lexique = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                //System.out.println(ligne);
                //Partie 2 erreur avec :: donc on va check pour prendre le dernier : de la chaine
                int separateur = ligne.lastIndexOf(':');            //Pour la question
                int poids = Integer.parseInt(ligne.substring(separateur+1));
                String mot = ligne.substring(0,separateur);
                PaireChaineEntier unePaireChaineEntier = new PaireChaineEntier(mot,poids);
                this.lexique.add(unePaireChaineEntier);
            }
            scanner.close();
            //UtilitairePaireChaineEntier.affichageListesPaire(lexique);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //calcul du score d'une dépêche pour la catégorie
    public int score(Depeche d) {
        // {} => {retourne l’entier correspondant au score de la depêche d pour la catégorie sur laquelle l’appel est réalisé.}
        int score = 0;
        for(int i=0;i < d.getMots().size();i++){
            score += UtilitairePaireChaineEntier.entierPourChaine(this.lexique,d.getMots().get(i));
        }
        return score;
    }





}
