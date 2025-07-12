package tp4.tabledemultiplication;

import java.util.ArrayList;
import java.util.Collections;

public class TableDeMultiplication {
    private int nombreTable;
    private ArrayList<Multiplication> multiplications = new ArrayList<>();

    public TableDeMultiplication(int nombreTable, boolean estMelange, boolean modeSansErreur){
        this.nombreTable = nombreTable;
        initialisation();
        if(estMelange){melange();}
    }

    private void initialisation(){
        for(int i=1; i<11; i++){
            multiplications.add(new Multiplication(i,nombreTable));
        }
    }

    private void melange(){
        Collections.shuffle(multiplications);
    }

    public int getNombreReponsesJustes(){
        int nbRepJustes = 0;
        for(int i=0; i < getNombreDeMultiplications();i++){
            if(getMultiplication(i).getTerme1()*getMultiplication(i).getTerme2() == getMultiplication(i).getReponseUtilisateur()){
                nbRepJustes++;
            }
        }
        return nbRepJustes;
    }

    public int getNombreDeMultiplications(){
        return multiplications.size();
    }

    public Multiplication getMultiplication(int index){
        return multiplications.get(index);
    }



}
