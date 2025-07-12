package tp4.dalton;

import java.util.Comparator;

public class Dalton implements Comparable<Dalton> {
    private String nom;
    private Taille taille;

    public Dalton(String nom, Taille taille){
        setNom(nom);
        setTaille(taille);
    }

    public String getNom() {
        return nom;
    }

    public Taille getTaille() {
        return taille;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTaille(Taille taille) {
        this.taille = taille;
    }

    @Override
    public int compareTo(Dalton d){
        if(this.taille.compareTo(d.taille) != 0){
            return this.taille.compareTo(d.taille);
        }else{
            return this.nom.compareTo(d.getNom());
        }
    }

    public static final Comparator<Dalton> comparateurNomSolution2 = new Comparator<Dalton>() {
        @Override
        public int compare(Dalton d1, Dalton d2) {
            if(d1.getNom().compareTo(d2.getNom()) < 0){
                return -1;
            }else if(d1.getNom().compareTo(d2.getNom()) == 0){
                return 0;
            }else{
                return 1;
            }
        }
    };

    @Override
    public String toString(){
        return nom +" (" + taille + ")";
    }
}
