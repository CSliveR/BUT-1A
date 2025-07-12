package tp6;

public class Article {
    private String intitule;
    private double prix;
    private int stock;
    private final int SEUIL = 100;

    public Article(String intitule, double prix, int stock) throws IntituleException, PrixException {
        setIntitule(intitule);
        setPrix(prix);
        setStock(stock);
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) throws IntituleException {
        if (intitule == null || intitule.isEmpty()) {
            throw new IntituleException("Un intitulé ne peut être null ou vide");
        }
        this.intitule = ArticleUtilitaire.capitalize(intitule);
    }

    public double getPrix() {
        return prix;
    }

    public double getPrix(int quantite) {
        if (quantite >= SEUIL){
            return getPrix()*quantite*0.9;
        }else{
            return getPrix()*quantite;
        }
    }

    public void setPrix(double prix) throws PrixException {
        if(prix <= 0){
            throw new PrixException();
        }
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean existQuantite(int quantite){
        return quantite >= getStock();
    }

    public void removeQuantite(int quantite) throws StockException{
        if(existQuantite(quantite)){
            setStock(getStock() - quantite);
        }else{
            throw new StockException();
        }
    }
}
