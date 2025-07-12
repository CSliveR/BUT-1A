package tp2.telephone;

public class Ecran {
    private String type;
    private int taille;

    public Ecran(String type, int taille){
        this.type = type;
        this.taille = taille;
    }

    /**
     * Renvoie le type d'un Ecran
     * @return type
     */

    public String getType() {
        return type;
    }

    /**
     * Renvoie le taille d'un Ecran
     * @return taille
     */

    public int getTaille() {
        return taille;
    }
}
