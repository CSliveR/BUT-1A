package tp2.contrainte;

public class Note extends ReelContraint{
    public Note(){
        super(0,20);
        setValeur(0);
    }

    public Note(double valeur){
        super(0,20);
        setValeur(valeur);
    }
}
