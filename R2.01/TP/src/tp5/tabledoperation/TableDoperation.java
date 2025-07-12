package tp5.tabledoperation;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class TableDoperation {
    private OperationEnum typeOperation;
    ArrayList<Operation> operations = new ArrayList<>();

    public TableDoperation(OperationEnum typeOperation){
        this.typeOperation = typeOperation;
        initialisation();
    }

    private void initialisation(){
        try{
            Class<?> c = Class.forName(typeOperation.toString());
            Constructor<?> ct = c.getConstructor(double.class, double.class);
            Object o = ct.newInstance(OperationUtilitaire.randomDouble(),OperationUtilitaire.randomDouble());
            operations.add((Operation) o);
        }catch(Exception e){
            ;
        }
    }
    public int getNombreReponsesJustes(){
        int nbRepJustes = 0;
        for(int i=0; i < getNombreDOperations();i++){
            if(operations.get(i).isReponseJuste()){
                nbRepJustes++;
            }
        }
        return nbRepJustes;
    }

    public int getNombreDOperations(){
        return operations.size();
    }

    public Operation getOperation(int index){
        return operations.get(index);
    }


}
