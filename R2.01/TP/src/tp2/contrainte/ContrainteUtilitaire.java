package tp2.contrainte;

import java.util.Scanner;

public class ContrainteUtilitaire {
    public static ReelContraint saisir(double min, double max){
        Scanner lecteur = new Scanner(System.in);
        double unReel;
        do{
            System.out.println("Entrez un réel entre [" + min + "," + max + "]");
            unReel = lecteur.nextDouble();
            lecteur.nextLine();
        }while(unReel > max || unReel < min);

        ReelContraint reel = new ReelContraint(min,max);
        reel.setValeur(unReel);

        return reel;
    }

    public static Note saisir(){
        return new Note(saisir(0,20).getValeur());
    }
}
