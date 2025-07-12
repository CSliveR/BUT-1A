package tp2.universite;

import tp2.contrainte.ReelContraint;

public class Personnel extends Personne {
    private int echelon;
    private ReelContraint pointDIndice;
    public static final int ECHELON_MIN = 1;

    public Personnel(String login, String prenom, String nom){
        super(login, prenom, nom);
        setEchelon(ECHELON_MIN);
        setPointDIndice(1000);
    }

    public Personnel(String login, String prenom, String nom, int echelon, double pointDIndice){
        super(login,prenom,nom);
        if(echelon < ECHELON_MIN){echelon = ECHELON_MIN;}
        setEchelon(echelon);
        if(pointDIndice < 1000){pointDIndice = 1000;}
        if(pointDIndice > 1200){pointDIndice = 1200;}
        setPointDIndice(pointDIndice);
    }

    /**
     * Renvoie l'échelon d'un Personnel supérieur ou égal à ECHELON_MIN = 1
     * @return echelon
     */

    public int getEchelon() {
        return echelon;
    }

    /**
     * Renvoie les pointsDIndice d'un Personnel
     * @return pointDIndice.getvaleur()
     */

    public double getPointDindice() {
        return pointDIndice.getValeur();
    }

    /**
     * Renvoie le salaire d'un Personnel qui est le produit de son echelon et de ses points d'indice
     * @return echelon*pointDIndice.getValeur();
     */

    public double getSalaire(){
        return echelon*pointDIndice.getValeur();
    }

    /**
     * Retourne le mail d'une Personne
     * @return prenom + "." + nom + "@univ-grenoble-alpes.fr"
     */
    public String getMail(){
        return getPrenom()+ "." + getNom() + "@univ-grenoble-alpes.fr";
    }

    /**
     * Met un échelon à un Personnel entre 1 et 4 inclus
     * @param echelon
     */

    public void setEchelon(int echelon) {
        if(echelon < 1){
            this.echelon = 1;
        }else if(echelon > 4){
            this.echelon = 4;
        }else{
            this.echelon = echelon;
        }
    }

    /**
     * Met un pointDIndice à un Personnel dans l'intervalle [1000;1200]
     * @param pointDIndice
     */

    public void setPointDIndice(double pointDIndice) {
        this.pointDIndice = new ReelContraint(1000,1200);
        this.pointDIndice.setValeur(pointDIndice);
    }

}

