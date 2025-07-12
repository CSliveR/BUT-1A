package tp1.universite;

/**
 * La classe TestEtudiant instancie les étudiants et appelle les getters associés
 */

public class TestEtudiant {
    public static void main(String[] args) {

        // Création des étudiants
        // IMPORTANT mettre des valeurs qui ne respectent pas les contraintes
        // pour vérifier leur prise en compte
        Etudiant etudiant1 = new Etudiant("DUPONTP", "pierre", "DUPONT");
        Etudiant etudiant2 = new Etudiant("martinf", "francis", "martin");

        // Ajouter une adresse
        etudiant2.setAdresse("2 Place Doyen Gosse");

        EtudiantUtilitaire.affiche(etudiant1);

        etudiant2.addNote(8.5);
        etudiant2.addNote(10.0);
        etudiant2.addNote(11.5);

        EtudiantUtilitaire.affiche(etudiant2);
    }


}
