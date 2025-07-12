package jeu;

public class ChefNain extends Nain{
    /**
     * Un ChefNain subit 2 fois moins de dégats qu'un Nain (4 fois moins de dégats qu'un Guerrier. Les dégats passés en paramètre).
     * @param degats
     */
    @Override
    protected void subirDegats(int degats) {
        super.subirDegats(degats/2);
    }
}
