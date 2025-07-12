package tp5.tabledoperation;

public enum OperationEnum {
    ADDITION("tp5.tableDoperation.Addition"),
    SOUSTRACTION("tp5.tableDoperation.Soustraction"),
    MULTIPLICATION("tp5.tabledoperation.Multiplication");

    private String nomClasse;
    OperationEnum(String n){
        this.nomClasse = n;
    }

    @Override
    public String toString(){
        return nomClasse;
    }
}
