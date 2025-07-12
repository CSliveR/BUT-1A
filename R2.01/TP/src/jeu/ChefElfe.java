package jeu;

public class ChefElfe extends Elfe{
    /**
     * Redéfinition de getForce(): Un ChefElfe tape 2 fois plus fort qu'un Elfe (4 fois plus fort qu'un Guerrier).
     * @return super.getForce()*2;
     */
    @Override
    public int getForce(){
        return super.getForce()*2;
    }
}
