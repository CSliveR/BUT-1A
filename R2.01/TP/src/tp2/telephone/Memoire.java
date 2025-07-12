package tp2.telephone;

public class Memoire {
    private String type;
    private int nombreGiga;
    public Memoire(String type, int nombreGiga){
        this.type = type;
        this.nombreGiga = nombreGiga;
    }
    /**
     * Renvoie le type d'une Memoire
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Renvoie le nombre de giga d'une Memoire
     * @return nombreGiga
     */

    public int getNombreGiga() {
        return nombreGiga;
    }
}
