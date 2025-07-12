package restaurant.exercice1;

/**
 * Classe permettant de représenter un plat : son nom, son cout de fabrication et son prix de vente
 *
 * @author fbm
 */
public class Plat {

    // Constantes représentant le MIN et MAX du cout de fabrication d'un plat (inclus)
    public static final int COUT_DE_FABRICATION_MIN = 1;
    public static final int COUT_DE_FABRICATION_MAX = 20;
    private String nom;
    private double coutDeFabrication;

    /**
     *
     * Création d'un plat
     * <br/>Lève une exception si les paramètres fournis ne correspondent pas aux contraintes imposées par le client
     *
     * @param nom nom du plat
     * @param coutDeFabrication cout de fabrication du plat
     * @throws PlatException
     */
    public Plat(String nom, double coutDeFabrication) throws PlatException {
        setNom(nom);
        this.coutDeFabrication = coutDeFabrication;
    }

    /**
     * @return le nom du plat
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom du plat
     * <br/>Lève une exception si les paramètres fournis ne correspondent pas aux contraintes imposées par le client
     *
     * @param nom
     * @throws PlatException
     */
    private void setNom(String nom) throws PlatException {
        if (nom == null || nom.isEmpty()) {
            throw new PlatException("Un nom de plat ne peut être null ou vide");
        }
        this.nom = CarteUtilitaire.capitalize(nom);
    }

    /**
     * @return le cout de fabrication d'un plat
     */
    public double getCoutDeFabrication() {
        return coutDeFabrication;
    }

    /**
     * Modifie le cout de fabrication du plat
     * <br/>Lève une exception si les paramètres fournis ne correspondent pas aux contraintes imposées par le client
     *
     * @param coutDeFabrication
     * @throws PlatException
     */
    private void setCoutDeFabrication(double coutDeFabrication) throws PlatException {
        if (coutDeFabrication >= COUT_DE_FABRICATION_MIN && coutDeFabrication <= COUT_DE_FABRICATION_MAX) {
            this.coutDeFabrication = coutDeFabrication;
        } else {
            throw new PlatException("Attention au coût de fabrication");
        }
    }

    /**
     * @return le prix de vente du plat
     */
    public double getPrixDeVente() {
        return CarteUtilitaire.arrondi(getCoutDeFabrication() * 1.5);
    }
    
    @Override
    public String toString(){
        return nom + " - " + getPrixDeVente() + " euros ";
    }

}
