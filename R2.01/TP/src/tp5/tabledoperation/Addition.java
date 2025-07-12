package tp5.tabledoperation;

public class Addition extends Operation {
    public Addition(double terme1, double terme2){
        super(terme1, terme2);
    }

    /**
     * Renvoie le résultat de la Addition entre le terme 1 et le terme 2
     * @return getTerme1() + getTerme2
     */
    @Override
    public double calculResultat() {
        return getTerme1()+getTerme2();
    }

    /**
     * Renvoie la description de l'Addition
     * @return getTerme1() + " + " + getTerme2() + " = "
     */

    @Override
    public String toString(){
        return getTerme1() + " + " + getTerme2() + " = ";
    }


}
