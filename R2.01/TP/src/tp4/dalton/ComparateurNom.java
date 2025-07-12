package tp4.dalton;

import java.util.Comparator;

public class ComparateurNom implements Comparator<Dalton> {
    @Override
    public int compare(Dalton d1, Dalton d2){
        if(d1.getNom().compareTo(d2.getNom()) < 0){
            return -1;
        }else if(d1.getNom().compareTo(d2.getNom()) == 0){
            return 0;
        }else{
            return 1;
        }
    }
}
