package tp2.telephone;

public class Processeur {
    private String libelle;
    private double frequence;

    public Processeur(String libelle, double frequence){
        this.libelle = libelle;
        this.frequence = frequence;
    }
    /**
     * Renvoie le libellé d'un Processeur
     * @return libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Renvoie la fréquence d'un Processeur
     * @return frequence
     */

    public double getFrequence() {
        return frequence;
    }
}
