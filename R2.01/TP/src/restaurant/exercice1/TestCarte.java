package restaurant.exercice1;

/**
 *  Classe de test pour la création d'une carte
 *
 */
public class TestCarte {
    
    public static void main(String[] args) throws PlatException {
        /////// Création des plats
        // Création des entrées
        Plat entree1 = new Plat("Taboulé", 2);
        Plat entree2 = new Plat("Croquettes de carottes", 4);
        Plat entree3 = new Plat("Chèvre en feuilleté", 6);

        // Création des plats principaux
        Plat plat1 = new Plat("Paupiette de veau aux olives et son gratin", 4);
        Plat plat2 = new Plat("Filet de lieu sauce armoricaine et son riz", 6);
        Plat plat3 = new Plat("Crumble de ravioles/épinards", 8);

        // Création des desserts
        Plat dessert1 = new Plat("Fondant au chocolat", 2);
        Plat dessert2 = new Plat("Flan pâtissier traditionnel", 3);
        Plat dessert3 = new Plat("Brownies aux noix", 4);

        /////// Création des menus
        MenuDeBase menu1 = new MenuDeBase("Essentiel", entree1, plat1);
        MenuDeBase menu2 = new MenuDeBase("Inspiration", entree2, plat2);
        MenuComplet menu3 = new MenuComplet("Gourmand", entree3, plat3, dessert3);

        /////// Création de la carte
        Carte carte = new Carte();

        // Ajout des entrées
        carte.addEntree(entree1);
        carte.addEntree(entree2);
        carte.addEntree(entree3);

        // Ajout des plats principaux
        carte.addPlatPrincipal(plat1);
        carte.addPlatPrincipal(plat2);
        carte.addPlatPrincipal(plat3);

        // Ajout des desserts
        carte.addDessert(dessert1);
        carte.addDessert(dessert2);
        carte.addDessert(dessert3);

        // Ajout des menus
        carte.addMenu(menu1);
        carte.addMenu(menu2);
        carte.addMenu(menu3);

        /////// Affichage de la carte
        CarteUtilitaire.printCarte(carte);
    }
}
