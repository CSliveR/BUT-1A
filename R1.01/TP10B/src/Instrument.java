public class Instrument implements Comparable<Instrument> {
    private String nomInstrument;
    private int nbDispo;

    public Instrument(String nomInstrument, int nbDispo){
        this.nomInstrument = nomInstrument;
        this.nbDispo = nbDispo;
    }

    public String getNomInstrument() {
        return nomInstrument;
    }

    public int getNbDispo() {
        return nbDispo;
    }

    //a) Mise à jour de nbDispo suite au rendu de nbEx exemplaires de cet Instrument
    public void renduExemplaires(int nbEx) {
        // { } => { nbDispo a été mis à jour
        nbDispo = nbDispo + nbEx;
    }

    //b) Mise à jour de nbDispo suite au prêt de nbEx exemplaires de cet Instrument
    public void retraitExemplaires(int nbEx) throws ExceptionDefautDispo {
        // { } => { nbDispo a été mis à jour si et seulement si sa valeur était
        // supérieure à nbEx, sinon, l'exception ExceptionDefautDispo
        // est levée

        if(nbDispo > nbEx){
            nbDispo = nbDispo - nbEx;
            System.out.println("--> EMPRUNT VALIDE");
        }else{
            throw new ExceptionDefautDispo("STOCK INSUFFISANT, IL NE RESTE QUE " + nbDispo + " EXEMPLAIRES DE CET INSTRUMENT");
        }
    }

    @Override
    public String toString(){
        return "(" + nomInstrument + "," + nbDispo + ")";
    }

    public int compareTo(Instrument i){
        if(this.nomInstrument.compareTo(i.nomInstrument) < 0){
            return -1;
        }else if(this.nomInstrument.compareTo(i.nomInstrument) == 0){
            return 0;
        }else{
            return 1;
        }
    }



}
