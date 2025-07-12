package tp4.dalton;

import java.util.Comparator;

public class ComparateurTaille implements Comparator<Dalton> {
    @Override
    public int compare(Dalton d1, Dalton d2){
        if(d1.getTaille().compareTo(d2.getTaille()) < 0){
            return -1;
        }else if(d1.getTaille().compareTo(d2.getTaille()) == 0){
            return 0;
        }else{
            return 1;
        }
    }

}
