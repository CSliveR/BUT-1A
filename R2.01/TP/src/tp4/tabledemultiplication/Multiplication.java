package tp4.tabledemultiplication;

public class Multiplication {
    private int terme1;
    private int terme2;
    private Integer reponseUtilisateur = 0;

    public Multiplication(int terme1, int terme2){
        this.terme1 = terme1;
        this.terme2 = terme2;
    }

    public int getTerme1() {
        return terme1;
    }

    public int getTerme2() {
        return terme2;
    }

    public Integer getReponseUtilisateur() {
        return reponseUtilisateur;
    }


    public void setReponseUtilisateur(Integer reponseUtilisateur) throws ErreurMultiplicationException {
        if(reponseUtilisateur ==  terme1*terme2){
            this.reponseUtilisateur = reponseUtilisateur;
        }else{
            throw new ErreurMultiplicationException();
        }
    }

    @Override
    public String toString(){
        return terme1 + " x " + terme2 + " = ";
    }


}
