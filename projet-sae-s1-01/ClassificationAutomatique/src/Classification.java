import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Classification {
    private static ArrayList<Depeche> lectureDepeches(String nomFichier) {
        //creation d'un tableau de dépêches
        ArrayList<Depeche> depeches = new ArrayList<>();
        try {
            // lecture du fichier d'entrée
            FileInputStream file = new FileInputStream(nomFichier);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                String id = ligne.substring(3);
                ligne = scanner.nextLine();
                String date = ligne.substring(3);
                ligne = scanner.nextLine();
                String categorie = ligne.substring(3);
                ligne = scanner.nextLine();
                String lignes = ligne.substring(3);
                while (scanner.hasNextLine() && !ligne.equals("")) {
                    ligne = scanner.nextLine();
                    if (!ligne.equals("")) {
                        lignes = lignes + '\n' + ligne;
                    }
                }
                Depeche uneDepeche = new Depeche(id, date, categorie, lignes);
                depeches.add(uneDepeche);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return depeches;
    }


    public static void classementDepeches(ArrayList<Depeche> depeches, ArrayList<Categorie> categories, String nomFichier) {
        //{} => {Pour chacune des dépêches de depeches, calcule le score pour chaque catégorie de categories et
        //écrit dans le fichier de nom nomFichier, le nom de la catégorie ayant le plus grand score ainsi que les pourcentages}
        try {
            FileWriter file = new FileWriter(nomFichier);
            String catPlusGrandScore;
            //Nom de la catégorie avec le plus grand score pour une dépêche donnée (une dépêche d'indice i)

            ArrayList<PaireChaineEntier> chaineCompteur = UtilitairePaireChaineEntier.listEntierPourChaqueCat(categories);
            //Tous les compteurs de chaque catégories (éléments de l'arrayList categories)
            for (int i = 0; i < depeches.size(); i++) {
                ArrayList<PaireChaineEntier> listScore = new ArrayList<>();
                for (int j = 0; j < categories.size(); j++) {
                    listScore.add(0, new PaireChaineEntier(categories.get(j).getNom(), categories.get(j).score(depeches.get(i))));
                }
                catPlusGrandScore = UtilitairePaireChaineEntier.chaineMax(listScore);  //on prend le score max dans listScore
                file.write(depeches.get(i).getId() + ":" + catPlusGrandScore + "\n"); //code pour afficher les catégories trouvées des dépeches

                //System.out.println(catPlusGrandScore + " "+depeches.get(i).getCategorie());
                if (catPlusGrandScore.compareToIgnoreCase(depeches.get(i).getCategorie()) == 0) { //
                    chaineCompteur.get(UtilitairePaireChaineEntier.indicePourChaine(chaineCompteur, catPlusGrandScore)).ajoutEntier(1);
                    //On ajoute 1 à l'entier présent dans la PaireChaineEntier de chaineCompteur à l'emplacement de catégorie
                }
            }
            //System.out.println(chaineCompteur.get(2).getChaine());
            for (int h = 0; h < chaineCompteur.size(); h++) {
                file.write(chaineCompteur.get(h).getChaine() + ":       " + chaineCompteur.get(h).getEntier() + "%\n");
            }
            file.write("MOYENNE:        " + UtilitairePaireChaineEntier.moyenne(chaineCompteur) + "%");
            file.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<PaireChaineEntier> initDico(ArrayList<Depeche> depeches, String categorie) {
        //{} => {renvoie une liste de PaireChaineEntier contenant tous les mots des depeches de la categorie en paramètre}
        ArrayList<PaireChaineEntier> resultat = new ArrayList<>();

        for (int i = 0; i < depeches.size(); i++) {  //Pour chaque dépêche
            if (depeches.get(i).getCategorie().compareToIgnoreCase(categorie) == 0) {
                for (int r = 0; r < depeches.get(i).getMots().size(); r++) { //Pour tous les mots d'une dépêche de la catégorie categorie
                    if (UtilitairePaireChaineEntier.indicePourChaine(resultat, depeches.get(i).getMots().get(r)) == -1) {

                        //Si la chaine n'est pas présente, on rajoute le mot.
                        resultat.add(new PaireChaineEntier(depeches.get(i).getMots().get(r), 0));

                    }

                }
            }

        }
        return resultat;
    }

    public static void calculScores(ArrayList<Depeche> depeches, String categorie, ArrayList<PaireChaineEntier> dictionnaire) {
        //{} => {actualise l'entier de chaque PaireChaineEntier de dictionnaire en fonction d'où il apparaît pour calculer son poids plus tard}
        for (int i = 0; i < depeches.size(); i++) {
            for (int r = 0; r < depeches.get(i).getMots().size(); r++) {
                int indMot = UtilitairePaireChaineEntier.indicePourChaine(dictionnaire, depeches.get(i).getMots().get(r));
                if (indMot != -1) {          //Si le mot n'est pas dans le dictionnaire alors on passe juste au suivant
                    if (depeches.get(i).getCategorie().compareToIgnoreCase(categorie) == 0) {   //Si la depeche dans laquelle est située le mot a la catégorie
                        dictionnaire.get(indMot).ajoutEntier(1);                             //qu'on observe alors on rajoute 1
                    } else {                                                                    //Sinon on enlève 1
                        dictionnaire.get(indMot).ajoutEntier(-1);
                    }
                }
            }
        }
    }

    public static int poidsPourScore(int score) {
        //{} => {Pour chacune des dépêches de depeches, calcule le score pour chaque catégorie de categories et
               //écrit dans le fichier de nom nomFichier, le nom de la catégorie ayant le plus grand score ainsi que les pourcentages}
        int poids;
        if (score < 1) {        //Si score négatif ou nul, score=1
            poids = 1;
        } else if (score <= 3) {      //Si score∈[1;3], score
            poids = 2;
        } else {                    //Si score∈[
            poids = 3;
        }

        return poids;
    }

    public static void generationLexTri(ArrayList<Depeche> depeches, String categorie, String nomFichier) {
        ArrayList<PaireChaineEntier> PCE = initDicoT(depeches, categorie);
        calculScores(depeches, categorie, PCE);

        try {
            FileWriter file = new FileWriter(nomFichier);

            for (int i = 0; i < PCE.size(); i++) {
                file.write(PCE.get(i).getChaine() + ":" + poidsPourScore(PCE.get(i).getEntier()) + "\n");

            }

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void generationLexique(ArrayList<Depeche> depeches, String categorie, String nomFichier) {
        ArrayList<PaireChaineEntier> PCE = initDico(depeches,categorie);
        calculScores(depeches,categorie,PCE);

        try {
            FileWriter file = new FileWriter(nomFichier);

            for(int i=0; i<PCE.size();i++){
                file.write(PCE.get(i).getChaine()+":"+poidsPourScore(PCE.get(i).getEntier()) + "\n");
            }

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void classementDepechesT(ArrayList<Depeche> depeches, ArrayList<Categorie> categories, String nomFichier) {
        // { lexique dans categories trié selon la valeur de leur chaine } => {Idem que pour classementDepeches}
        try {
            FileWriter file = new FileWriter(nomFichier);
            String catPlusGrandScore;
            //Nom de la catégorie avec le plus grand score pour une dépêche donnée (une dépêche d'indice i)

            ArrayList<PaireChaineEntier> chaineCompteur = UtilitairePaireChaineEntier.listEntierPourChaqueCat(categories);
            //Tous les compteurs de chaque catégories (éléments de l'arrayList categories)
            for (int i = 0; i < depeches.size(); i++) {
                ArrayList<PaireChaineEntier> listScore = new ArrayList<>();
                for (int j = 0; j < categories.size(); j++) {
                    listScore.add(0, new PaireChaineEntier(categories.get(j).getNom(), categories.get(j).score(depeches.get(i))));
                }
                catPlusGrandScore = UtilitairePaireChaineEntier.chaineMax(listScore);  //on prend le score max dans listScore
                file.write(depeches.get(i).getId() + ":" + catPlusGrandScore + "\n"); //code pour afficher les catégories trouvées des dépeches

                //System.out.println(catPlusGrandScore + " "+depeches.get(i).getCategorie());
                if (catPlusGrandScore.compareToIgnoreCase(depeches.get(i).getCategorie()) == 0) { //
                    chaineCompteur.get(UtilitairePaireChaineEntier.indicePourChaine(chaineCompteur, catPlusGrandScore)).ajoutEntier(1);
                    //On ajoute 1 à l'entier présent dans la PaireChaineEntier de chaineCompteur à l'emplacement de catégorie
                }
            }
            //System.out.println(chaineCompteur.get(2).getChaine());
            for (int h = 0; h < chaineCompteur.size(); h++) {
                file.write(chaineCompteur.get(h).getChaine() + ":       " + chaineCompteur.get(h).getEntier() + "%\n");
            }
            file.write("MOYENNE:        " + UtilitairePaireChaineEntier.moyenne(chaineCompteur) + "%");
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<PaireChaineEntier> initDicoT(ArrayList<Depeche> depeches, String categorie) {
        ArrayList<PaireChaineEntier> resultat = new ArrayList<>();
        int j;
        boolean onAPermute = true;

        for (int i = 0; i < depeches.size(); i++) {  //Pour chaque dépêche
            if (depeches.get(i).getCategorie().compareToIgnoreCase(categorie) == 0) {
                for (int r = 0; r < depeches.get(i).getMots().size(); r++) { //Pour tous les mots d'une dépêche de la catégorie categorie
                    if(resultat.size()==0){
                        resultat.add(new PaireChaineEntier(depeches.get(i).getMots().get(r), 0));
                    }
                    UtilitairePaireChaineEntier.triElement(resultat, depeches.get(i).getMots().get(r));
                    /*if (UtilitairePaireChaineEntier.indicePourChaine(resultat, depeches.get(i).getMots().get(r)) == -1
                            && resultat.get(i).getChaine().compareTo()) {

                        //Si la chaine n'est pas présente, on rajoute le mot.
                        resultat.add(new PaireChaineEntier(depeches.get(i).getMots().get(r), 0));

                    }*/

                }
            }

        }
        return resultat;
    }

    public static void generationLexiqueCompteur(ArrayList<Depeche> depeches, String categorie, String nomFichier) {
        ArrayList<PaireChaineEntier> PCE = initDico(depeches,categorie);
        calculScoresCompteur(depeches,categorie,PCE);

        try {
            FileWriter file = new FileWriter(nomFichier);

            for(int i=0; i<PCE.size();i++){
                file.write(PCE.get(i).getChaine()+":"+poidsPourScore(PCE.get(i).getEntier()) + "\n");
            }

            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void calculScoresCompteur (ArrayList < Depeche > depeches, String categorie, ArrayList < PaireChaineEntier > dictionnaire){
        //{} => {met à jour les scores des mots présents dans dictionnaire. Lorsqu'un mot présent dans dictionnaire apparaît dans une dépêche de depeches
        //son score est : décrémenté si la dépêche n'est pas dans la catégorie categorie
        //incrémenté si la dépêche est dans la catégorie categorie.
        int nbComparaisons = 0;
        PaireResultatCompteur<Integer> compteurIndMot;
        for (int i = 0; i < depeches.size(); i++) {
            nbComparaisons++;
            for (int r = 0; r < depeches.get(i).getMots().size(); r++) {
                nbComparaisons++;
                compteurIndMot = UtilitairePaireChaineEntier.indicePourChaineNbComp(dictionnaire, depeches.get(i).getMots().get(r));
                nbComparaisons += compteurIndMot.getCompteur();     //On rajoute le nombre de compa d'indicePourChaineNbComp à nbCompa
                if (compteurIndMot.getRes() != -1) {          //Si le mot n'est pas dans le dictionnaire alors on passe juste au suivant
                    if (depeches.get(i).getCategorie().compareToIgnoreCase(categorie) == 0) {   //Si la depeche dans laquelle est située le mot a la catégorie
                        dictionnaire.get(compteurIndMot.getRes()).ajoutEntier(1);                             //qu'on observe alors on rajoute 1
                    } else {                                                                    //Sinon on enlève 1
                        dictionnaire.get(compteurIndMot.getRes()).ajoutEntier(-1);       //Pas de comparatisons dans ajoutEntier
                    }
                    nbComparaisons++;
                }
                nbComparaisons++;
            }
        }
        System.out.println("Il y a eu " + nbComparaisons + " comparaisons.");
    }

    /*renvoie les catégories qui ont le meme score*/
    public static ArrayList<String> chaineMaxEgalite() {return new ArrayList<>();}

    public static void main(String[] args) {
        //Chargement des dépêches en mémoire
        System.out.println("chargement des dépêches");
        ArrayList<Depeche> depeches = lectureDepeches("./depeches.txt");

//        for (int i = 0; i < depeches.size(); i++) {
//            depeches.get(i).afficher();
//        }

        Categorie lexiqueSport = new Categorie("SPORTS");
        lexiqueSport.initLexique("./Lexique_SPORTS.txt");

        Categorie lexiqueCulture = new Categorie("CULTURE");
        lexiqueCulture.initLexique("./Lexique_CULTURE.txt");

        Categorie lexiqueEco = new Categorie("ECONOMIE");
        lexiqueEco.initLexique("./Lexique_ECONOMIE.txt");

        Categorie lexiqueEnvSciences = new Categorie("ENVIRONNEMENT-SCIENCES");
        lexiqueEnvSciences.initLexique("./Lexique_ENVIRONNEMENT-SCIENCES.txt");

        Categorie lexiquePolitique = new Categorie("POLITIQUE");
        lexiquePolitique.initLexique("./Lexique_POLITIQUE.txt");


        /*  //5.4 */

        ArrayList<Categorie> listCategorie = new ArrayList<>(Arrays.asList(lexiqueCulture, lexiqueEnvSciences, lexiquePolitique, lexiqueSport, lexiqueEco));
        ArrayList<PaireChaineEntier> listScore = new ArrayList<>();
        for (int i = 0; i < listCategorie.size(); i++) {
            listScore.add(0, new PaireChaineEntier(listCategorie.get(i).getNom(), listCategorie.get(i).score(depeches.get(450))));
            //System.out.println(listScore.get(0).getChaine() + " : " + listScore.get(0).getEntier()); //On les rajoute à l'emplacement 0
        }
        //System.out.println(UtilitairePaireChaineEntier.chaineMax(listScore));



  /*    //5.2 c)
        for (int i = 0; i < lexiqueSport.getLexique().size();i++){
            System.out.println(lexiqueSport.getLexique().get(i).getChaine()+ ":" +lexiqueSport.getLexique().get(i).getEntier());
        }
*/
        //5.2 e)
 /*       System.out.println(depeches.get(0).getMots());
        Scanner lecteur = new Scanner(System.in);
        System.out.println("Entrez un mot");
        String mot = lecteur.nextLine();

//        System.out.println(UtilitairePaireChaineEntier.entierPourChaine(lexiqueSport.getLexique(),mot));

        System.out.println(depeches.get(400).getMots());
        // 5.3
        // System.out.print(lexiqueSport.score(depeches.get(400)));

        System.out.println(UtilitairePaireChaineEntier.moyenne(listScore));

        System.out.println(UtilitairePaireChaineEntier.indicePourChaine(listScore,mot));
*/
//5.5) procédure-3ème méthode
        classementDepeches(depeches, listCategorie, "ResultatsManuels.txt");

//-----------------------------------------------------------------------------------
        //PARTIE 2


        //ArrayList<PaireChaineEntier> dicoEco = initDico(depeches, "ECONOMIE");
        //UtilitairePaireChaineEntier.affichageListesPaire(dicoEco);
        //calculScores(depeches, "ECONOMIE", dicoEco);
        //UtilitairePaireChaineEntier.affichageListesPaire(dicoEco);
        ArrayList<Categorie> listCategorieGenere = new ArrayList<>();
        for(int i=0; i<listCategorie.size();i++){
            Categorie lexique = new Categorie(listCategorie.get(i).getNom());

            generationLexiqueCompteur(depeches, lexique.getNom(), "./LexiqueGenere_"+ listCategorie.get(i).getNom()+".txt");
            lexique.initLexique("./LexiqueGenere_"+ listCategorie.get(i).getNom()+".txt");
            listCategorieGenere.add(lexique);
        }
        ArrayList<Depeche> depechesTest = lectureDepeches("./depeches.txt");
        System.out.println("DEBUT lexique Non Trie");

        //3.5)
        classementDepeches(depechesTest, listCategorieGenere, "./ResultatsFinalGenere.txt");
        classementDepeches(depechesTest, listCategorie, "./ResultatsFinalManuel.txt");


        //3.6) lexique non trié
        long startTime = System.currentTimeMillis();
        classementDepeches(depechesTest, listCategorieGenere, "./ResultatsFinalGenere.txt");
        long endTime = System.currentTimeMillis();
        System.out.println("votre saisie a été réalisée en : " + (endTime-startTime) + "ms");
//        for(int i=0; i<listCategorieGenere.size();i++) {
//            System.out.println(listCategorie.get(i).getNom() + ' ' + UtilitairePaireChaineEntier.verifTri(listCategorieGenere.get(i).getLexique()));
//        }

        //3.6) lexique trié

        System.out.println("DEBUT lexique Trie");


        /*for(int i=0; i<listCategorieGenere.size();i++) {


            System.out.println(listCategorie.get(i).getNom() + ' ' + UtilitairePaireChaineEntier.verifTri(listCategorieGenere.get(i).getLexique()));
        }*/

        ArrayList<Categorie> listCategorieGenereTri = new ArrayList<>();
        for(int i=0; i<listCategorie.size();i++){
            Categorie lexique = new Categorie(listCategorieGenere.get(i).getNom());
            generationLexTri(depeches, lexique.getNom(), "./LexiqueGenereTri_"+ listCategorie.get(i).getNom()+".txt");
            lexique.initLexique("./LexiqueGenereTri_"+ listCategorie.get(i).getNom()+".txt");

            //lexique.initLexique("./LexiqueGenereTri_"+ listCategorie.get(i).getNom()+".txt");
            listCategorieGenereTri.add(lexique);
        }


        long startTimeT = System.currentTimeMillis();
        classementDepechesT(depechesTest, listCategorieGenereTri, "./ResultatsFinalGenereTrie.txt");
        long endTimeT = System.currentTimeMillis();
        System.out.println("votre saisie a été réalisée en : " + (endTimeT-startTimeT) + "ms");



    }


}