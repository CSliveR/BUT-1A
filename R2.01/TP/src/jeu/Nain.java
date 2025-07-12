package jeu;

public class Nain extends Guerrier {
    /**
     * Un Nain subit deux fois moins de dégats qu'un Guerrier (les dégats passés en paramètre).
     * @param degats
     */
    protected void subirDegats(int degats) {
        System.out.println(" dégats subis: " + degats/2);
        setPointDeVie(getPointsDeVie() - degats/2);

        if(this.getPointsDeVie() < 0){
            this.setPointDeVie(0);
        }
    }
}
