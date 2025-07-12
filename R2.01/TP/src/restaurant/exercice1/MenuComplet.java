package restaurant.exercice1;

public class MenuComplet extends MenuDeBase{
    private Plat dessert;
    public MenuComplet(String nom, Plat entree, Plat platPrincipal, Plat dessert){
        super(nom, entree, platPrincipal);
        this.dessert = dessert;
    }

    public Plat getDessert() {
        return dessert;
    }

    @Override
    protected double getPrixDeVenteAvantRemise(){
        return super.getPrixDeVenteAvantRemise() + dessert.getPrixDeVente();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "Dessert : " + dessert;
    }
}
