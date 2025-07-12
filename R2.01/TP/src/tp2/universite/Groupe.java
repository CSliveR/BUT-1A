package tp2.universite;

import java.util.Comparator;
import java.util.TreeSet;

public class Groupe {
    private String libelle;
    private TreeSet<Etudiant> etudiants = new TreeSet<>();

    public Groupe(String libelle){
        setLibelle(libelle);
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void addEtudiant(Etudiant etudiant){
        if(!this.containsEtudiant(etudiant)){
            etudiants.add(etudiant);
        }else{
            removeEtudiant(etudiant);
            this.addEtudiant(etudiant);
        }
    }

    public void removeEtudiant(Etudiant etudiant){
        etudiants.remove(etudiant);
    }

    public boolean containsEtudiant(Etudiant etudiant){
        return etudiants.contains(etudiant);
    }

    public TreeSet<Etudiant> getEtudiants(){
        return etudiants;
    }

    public static final Comparator<Groupe> CompEtudiantTriParLibelleGroupe = new Comparator<Groupe>() {
        @Override
        public int compare(Groupe g1, Groupe g2) {
            if(g1.getLibelle().compareTo(g2.getLibelle()) < 0){
                return -1;
            }else if(g1.getLibelle().compareTo(g2.getLibelle()) == 0){
                return 0;
            }else{
                return 1;
            }
        }
    };


}
