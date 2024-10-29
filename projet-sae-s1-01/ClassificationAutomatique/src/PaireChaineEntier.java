public class PaireChaineEntier {
    private String chaine;
    private int entier;

    public PaireChaineEntier(String chaine, int entier){
        this.chaine = chaine;
        this.entier = entier;
    }

    public int getEntier() {
        return entier;
    }

    public String getChaine() {
        return chaine;
    }

    public void setEntier(int nb){
        this.entier = nb;
    }

    public void ajoutEntier(int nb){
        this.entier += nb;
    }




}
