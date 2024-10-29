public class Categorie implements Comparable<Categorie>{
    private String nomCat;
    private ListeTrieeC<Instrument> lInstruments;

    public Categorie(String nomCat, ListeTrieeC<Instrument>lInstruments){
        this.nomCat = nomCat;
        this.lInstruments = lInstruments;
    }

    public String getNomCat() {
        return nomCat;
    }

    public ListeTrieeC<Instrument> getlInstruments() {
        return lInstruments;
    }

    //a) affichage – FOURNIE
    public void afficheCat() {
        System.out.print(this.nomCat + " (" + this.lInstruments.getLongueur()+") : ");
        lInstruments.afficheGD();
    }

    //b) Disponibilité pour prêt, d'au moins un élément de lInstruments
    public boolean exixstInsDispo() {
        // { lInstruments non vide } =>
        // { résultat = vrai si au moins un instrument de lInstruments peut être prêté

        Cellule<Instrument> cellCour = lInstruments.getTete();

        while(cellCour != null && cellCour.getInfo().getNbDispo() <= 0){
            cellCour = cellCour.getCelluleSuivante();
        }

        return cellCour != null && cellCour.getInfo().getNbDispo() > 0;
    }

    public int compareTo(Categorie c){
        if(this.nomCat.compareTo(c.nomCat) < 0){
            return -1;
        }else if (this.nomCat.compareTo(c.nomCat) == 0){
           return 0;
        }else{
            return 1;
        }
    }


}
