package tp3.billetterie;

import java.util.ArrayList;

public class TestBillet {
    public static void main(String[] args) {
        // Creation d'une liste de trajets
        ArrayList<Trajet> trajets = new ArrayList<>();
        // Creation de trajets
        Trajet T1, T2, T3;
        T1 = new Trajet("Paris", "Grenoble", 576);
        T2 = new Trajet("Grenoble", "Marseille", 307);
        T3 = new Trajet("Grenoble", "Voreppe", 16);
        // Ajout des trajets dans la liste
        trajets.add(T1);
        trajets.add(T2);
        trajets.add(T3);
        // Affichage des trajets
        BilletUtilitaire.afficheTrajets(trajets);
        // Creation d'une liste de billets
        ArrayList<Billet> billets = new ArrayList<>();
        // Creation de billets "normaux"
        Billet B1, B2, B3;
        B1 = new Billet(T1, 0.53);
        B2 = new Billet(T2, 0.43);
        B3 = new Billet(T3, 0.82);
        // Ajout des billets "normaux" dans la liste de billets
        billets.add(B1);
        billets.add(B2);
        billets.add(B3);
        // Affichage de la liste de billets
        BilletUtilitaire.afficheBillets(billets);
        // Creation de billets réduits
        BilletReduit BR1, BR2, BR3;
        BR1 = new BilletReduit(T1, 0.53, .2);
        BR2 = new BilletReduit(T2, 0.43, .3);
        BR3 = new BilletReduit(T3, 0.82, .4);
        // Ajout des billets réduits dans la liste de billets
        billets.add(BR1);
        billets.add(BR2);
        billets.add(BR3);
        // Affichage de la liste de billets
        // Vérifier le prix pour chaque billet normal ou réduit
        // Le mécanisme de polymorphisme s’applique ici !
        BilletUtilitaire.afficheBillets(billets);
    }
}
