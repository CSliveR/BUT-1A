package restaurant.exercice1;

public class MenuDeBase {
    private String nom;
    private Plat entree;
    private Plat platPrincipal;

    public MenuDeBase(String nom, Plat entree, Plat platPrincipal){
        this.nom = nom;
        this.entree = entree;
        this.platPrincipal = platPrincipal;
    }

    public String getNom() {
        return nom;
    }

    public Plat getEntree() {
        return entree;
    }

    public Plat getPlatPrincipal() {
        return platPrincipal;
    }

    protected double getPrixDeVenteAvantRemise(){
        return entree.getPrixDeVente() + platPrincipal.getPrixDeVente();
    }

    public double getPrixDeVente(){
        return CarteUtilitaire.arrondi(getPrixDeVenteAvantRemise()*0.8);
    }

    public String getDescription(){
        return nom + " - " + getPrixDeVente() + " euros\n\t " + "Entrée : "  + entree + "\n\tPlat principal : " + platPrincipal + "\n\n";
    }

    @Override
    public String toString(){
        return "Menu : " + getDescription();
    }
}
