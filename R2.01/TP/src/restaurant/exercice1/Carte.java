package restaurant.exercice1;

import java.util.ArrayList;

public class Carte {
    private ArrayList<Plat> entrees = new ArrayList<>();
    private ArrayList<Plat> platsPrincipaux = new ArrayList<>();
    private ArrayList<Plat> desserts = new ArrayList<>();
    private ArrayList<MenuDeBase> menus = new ArrayList<>();

    public Carte(){}

    public void addEntree(Plat entree){
        this.entrees.add(entree);
    }

    public void addPlatPrincipal(Plat plat){
        this.platsPrincipaux.add(plat);
    }

    public void addDessert(Plat dessert){
        this.desserts.add(dessert);
    }

    public void addMenu(MenuDeBase menuDeBase){
        this.menus.add(menuDeBase);
    }

    public ArrayList<Plat> getEntrees() {
        return entrees;
    }

    public ArrayList<Plat> getPlatsPrincipaux() {
        return platsPrincipaux;
    }

    public ArrayList<Plat> getDesserts() {
        return desserts;
    }

    public ArrayList<MenuDeBase> getMenus() {
        return menus;
    }
//
//    @Override
//    public String toString(){
//        return "Nos entrées : " + getEntrees()
//    }
}
