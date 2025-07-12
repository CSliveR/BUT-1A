package jeu;

public class Elfe extends Guerrier{
    /**
     * Redéfinition de la méthode getForce(): Un Elfe tape 2 fois plus fort qu'un Guerrier.
     * @return super.getForce()*2;
     */
    @Override
    public int getForce(){
        return super.getForce()*2;
    }

    /**
     * Un Elfe subit les dégats passés en paramétre
     * @param degats
     */

    protected void subirDegats(int degats) {
        System.out.println(" dégats subis: " + degats);
        setPointDeVie(getPointsDeVie() - degats);

        if(this.getPointsDeVie() < 0){
            this.setPointDeVie(0);
        }
    }

}
