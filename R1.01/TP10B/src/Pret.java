import java.util.ArrayList;

public class Pret implements Comparable<Pret> {
    private int numPret;
    private ArrayList<Instrument> instrumentsPretes;

    public Pret(int numPret, ArrayList<Instrument> instrumentsPretes){
        this.numPret = numPret;
        this.instrumentsPretes = instrumentsPretes;
    }

    public int getNumPret() {
        return numPret;
    }

    public ArrayList<Instrument> getInstrumentsPretes() {
        return instrumentsPretes;
    }


    //(a) ajout d'un instrument dans instrumentsPretes
    public void addTrieIns(Instrument unInstrument) {
        // { le vecteur instrumentsPretes de ce Pret est trié
        // et peut contenir plusieurs occurrences de unInstrument } =>
        // { unInstrument a été ajouté dans ce vecteur, en respect du tri

        int i=0;

        while(i < instrumentsPretes.size() && instrumentsPretes.get(i).compareTo(unInstrument) < 0){
            i++;
        }

        instrumentsPretes.add(i,unInstrument);
    }

    //(b) suppression d'un instrument dans instrumentsPretes
    public void removeTrieIns(Instrument unInstrument) {
        // { le vecteur instrumentsPretes de ce Pret est trié
        // et contient au moins une occurrence de unInstrument } =>
        // { la première occurrence de unInstrument a été supprimée de ce vecteur

        int i=0;

        while(i < instrumentsPretes.size() && instrumentsPretes.get(i).compareTo(unInstrument) < 0){
            i++;
        }

        if(instrumentsPretes.get(i).compareTo(unInstrument) == 0){
            instrumentsPretes.remove(unInstrument);
        }
    }

    //(c) nombre d'exemplaires d'un instrument dans instrumentsPretes
    public int nbExemplaires(Instrument unInstrument) {
        // { le vecteur instrumentsPretes de ce Pret est trié et contient une
        // ou plusieurs occurrences de unInstrument }=>
        // { résultat = nombre d'occurrences de unInst dans instrumentsPretes

        int i=0;
        int nbOcc = 0;

        while(i < instrumentsPretes.size() && instrumentsPretes.get(i).compareTo(unInstrument) < 0){
            i++;
        }

        if(instrumentsPretes.get(i).compareTo(unInstrument) == 0){
            nbOcc++;
        }

        return nbOcc;
    }

    //(d) ce prêt est-il soldé ?
    public boolean isSolde() {
        // { } =>
        // { résultat = vrai si le vecteur instrumentsPretes de ce Prêt est vide

        return instrumentsPretes.isEmpty();
    }

    //(e) récapitulatif de l'état de ce prêt
    public void recapPret() {
        // { } =>
        // { * si ce Pret n'est pas soldé, pour chaque Instrument différent dans
        // instrumentsPretes, le nom de l'instrument et son nombre d'exemplaires
        // dans ce vecteur a été affiché
        // * sinon, un message rappellant que ce Pret est soldé a été affiché

        if(!isSolde()){
            for (int i=0;i < instrumentsPretes.size();i++){
                removeTrieIns(instrumentsPretes.get(i));
                System.out.println(instrumentsPretes.get(i).getNomInstrument() + instrumentsPretes.get(i).getNbDispo());
            }
        }else{
            System.out.println("Ce prêt est soldé");
        }
    }

    public int compareTo(Pret p){
        if(this.numPret < p.numPret){
            return -1;
        }else if(this.numPret == p.numPret){
            return 0;
        }else{
            return 1;
        }
    }

}
