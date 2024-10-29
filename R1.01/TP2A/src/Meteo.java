import java.util.Scanner;

public class Meteo {
    public static void main(String[] args) {
        boolean pluie, parapluie, tongs, chapeau, bonEquipement;
        Scanner lecteur = new Scanner(System.in);

        System.out.println("Est-ce qu'il pleut (true pour oui, false pour non) ?");
        pluie = lecteur.nextBoolean();
        lecteur.nextLine();

        System.out.println("Avez-vous un chapeau (true pour oui, false pour non) ?");
        chapeau = lecteur.nextBoolean();
        lecteur.nextLine();

        System.out.println("Avez-vous un parapluie (true pour oui, false pour non) ?");
        parapluie = lecteur.nextBoolean();
        lecteur.nextLine();

        System.out.println("Portez-vous des tongs (true pour oui, false pour non) ?");
        tongs = lecteur.nextBoolean();
        lecteur.nextLine();

        if(!pluie | ((parapluie | chapeau) & !tongs)){
            bonEquipement = true;
        }else{
            bonEquipement = false;
        }
        //bonEquipement = !pluie || ((parapluie || chapeau) && !tongs);

        if(bonEquipement){
            System.out.println("Vous êtes bien équipé");
        }else{
            System.out.println("Vous ếtes mal équipé");
        }
    }
}
