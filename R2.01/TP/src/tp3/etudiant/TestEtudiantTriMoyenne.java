package tp3.etudiant;

import tp2.universite.Etudiant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestEtudiantTriMoyenne {
    public static void main(String[] args) {
        // Créer les étudiants
        Etudiant etudiant1 = new Etudiant("SANZF", "FLORIANT", "Sanz");
        Etudiant etudiant2 = new Etudiant("portepa", "Pierre-Antoine", "Porte");
        Etudiant etudiant3 = new Etudiant("burlatn", "nils", "burlat", "1 rue pas loin", "10 rue des parents");
        Etudiant etudiant4 = new Etudiant("brunetr", "Raphaël", "Brunet-manquat");
        Etudiant etudiant5 = new Etudiant("brunetm", "Maxime", "Brunet-manquat");

        // Ajouter des notes aux étudiants

        etudiant1.addNote(16);
        etudiant2.addNote(9);
        etudiant3.addNote(13);
        etudiant4.addNote(19);
        etudiant5.addNote(18);

        // Créer la liste d'étudiants et ajouter les étudiants
        ArrayList<Etudiant> mesEtudiantsTries = new ArrayList<>();
        mesEtudiantsTries.add(etudiant1);
        mesEtudiantsTries.add(etudiant2);
        mesEtudiantsTries.add(etudiant3);
        mesEtudiantsTries.add(etudiant4);
        mesEtudiantsTries.add(etudiant5);

        // Afficher la liste des étudiants avant tri
        System.out.println("--------------");
        System.out.println("Les étudiants avant Collections.sort() : ");
        affichageMoyEtudiants(mesEtudiantsTries);

        // trier la liste
        Collections.sort(mesEtudiantsTries, Etudiant.CompEtudiantTriParMoyenne);

        // Afficher la liste des étudiants après tri
        System.out.println("--------------");
        System.out.println("Les étudiants après Collections.sort() : ");
        affichageMoyEtudiants(mesEtudiantsTries);

    }

    private static void affichageMoyEtudiants(Collection<Etudiant> etudiants) {
        for (Etudiant etudiant : etudiants) {
            System.out.println("Moyenne = " + etudiant.getMoyenne() + " : " + etudiant.getNom() + ", " + etudiant.getPrenom());
        }
    }
}
