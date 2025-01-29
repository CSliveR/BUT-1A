import java.util.ArrayList;

public class YamSec {
    public static void main(String[] args) {
        // Une partie de YAMSEC : 4 joueurs, 6 lancers par joueur (à tour de rôle)
        // 1 - initialisation d'un vecteur de joueurs
        ArrayList<Joueur> lesJoueurs = Utilitaire.initJoueurs();

        // 2 – Suivi d'une partie... À COMPLÉTER
        // À chaque tour, pour chaque joueur : on enregistre son lancer, on met
        //  à jour son nombre de Yams et son nombre de points, puis on affiche son résultat intermédiaire

        ArrayList<Integer> unLancer;
        unLancer = Utilitaire.saisieLancerDeJoueur();

        for(int i=0; i < lesJoueurs.size(); i++){
            lesJoueurs.get(i).ajoutYam();
            lesJoueurs.get(i).ajoutPoints(Utilitaire.nbPoints(unLancer));
        }


        // Fin de la partie...
        System.out.println("FIN DE LA PARTIE");

        // 3 - création d'un nouveau vecteur de joueurs contenant les éléments de
        // lesJoueurs ordonnés selon l'ordre (nbPoints, nbYam)
        ArrayList<Joueur> lesJoueursTrie = Utilitaire.creeVectJoueurTrie(lesJoueurs);

        // 4 - affichage du nombre de gagnants, du nombre de points qu'ils ont acquis
        //     et du nombre de fois où ils ont fait un YAM au cours de la partie
        //     À COMPLÉTER

        int nbGagnants = Utilitaire.nbGagnants(lesJoueursTrie);
        System.out.println(nbGagnants);
        System.out.println(Utilitaire.nbPoints(unLancer));

        for(int i =0; i < nbGagnants; i++){
            System.out.println(lesJoueursTrie.get(i).getNbYams());
        }

    }
}
