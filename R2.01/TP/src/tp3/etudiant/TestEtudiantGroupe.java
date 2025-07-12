package tp3.etudiant;

import tp2.universite.Etudiant;
import tp2.universite.Groupe;

import java.util.Collection;
import java.util.Collections;

public class TestEtudiantGroupe {
    public static void main(String[] args) {
        // Créer des groupes
        Groupe groupeA = new Groupe("A");
        Groupe groupeB = new Groupe("B");
        // Créer des étudiants
        Etudiant etudiant1 = new Etudiant("SANZF", "FLORIANT", "Sanz");
        Etudiant etudiant2 = new Etudiant("portepa", "Pierre-Antoine", "Porte");
        Etudiant etudiant3 = new Etudiant("burlatn", "nils", "burlat");
        Etudiant etudiant4 = new Etudiant("brunetr", "Raphaël", "Brunet-Manquat");
        Etudiant etudiant5 = new Etudiant("brunetm", "Maxime", "Brunet-Manquat");
        // Ajouter TOUS les étudiants au groupe A
        // ATTENTION à ne pas boucler à cause de l'association bidirectionnelle !
        groupeA.addEtudiant(etudiant1);
        groupeA.addEtudiant(etudiant1);
        // On ajoute plusieurs fois le même étudiant
        groupeA.addEtudiant(etudiant1); //
        groupeA.addEtudiant(etudiant2);
        groupeA.addEtudiant(etudiant3);

        groupeA.addEtudiant(etudiant4);
        groupeA.addEtudiant(etudiant5);
        // Ajouter les deux derniers étudiants au groupe B
        etudiant4.setGroupe(groupeB);
        etudiant5.setGroupe(groupeB);
        // Afficher les étudiants du groupe A
        System.out.println("---------");
        System.out.println("Etudiants du Groupe A");
        for (Etudiant etudiant : groupeA.getEtudiants()) {
            if(etudiant.getGroupe().getLibelle().compareTo("A") == 0){
                System.out.println(etudiant.getGroupe().getLibelle() + " " +
                        etudiant.getNom() + " " + etudiant.getPrenom());
            }
        }

        // Afficher les étudiants du groupe B
        System.out.println("---------");
        System.out.println("Etudiants du Groupe B");
        for (Etudiant etudiant : groupeB.getEtudiants()) {
            if(etudiant.getGroupe().getLibelle().compareTo("B") == 0){
                System.out.println(etudiant.getGroupe().getLibelle() + " " +
                        etudiant.getNom() + " " + etudiant.getPrenom());
            }
        }
    }
}
