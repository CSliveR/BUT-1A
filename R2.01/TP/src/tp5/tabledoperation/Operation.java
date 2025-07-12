package tp5.tabledoperation;

public abstract class Operation {
    private double terme1;
    private double terme2;
    private Double reponseUtilisateur;

    public Operation(double terme1, double terme2){
        this.terme1 = terme1;
        this.terme2 = terme2;
    }

    public void setReponseUtilisateur(Double reponseUtilisateur) {
        this.reponseUtilisateur = reponseUtilisateur;
    }

    public boolean existeReponseUtilisateur(){
        return reponseUtilisateur != null;
    }

    public boolean isReponseJuste(){
        return (terme1+terme2 == reponseUtilisateur) | (terme1-terme2 == reponseUtilisateur) | (terme1*terme2 == reponseUtilisateur);
    }

    public abstract double calculResultat();

    public double getTerme1() {
        return terme1;
    }

    public double getTerme2() {
        return terme2;
    }
}
