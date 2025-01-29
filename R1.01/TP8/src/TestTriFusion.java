import java.util.ArrayList;
import java.util.Arrays;

public class TestTriFusion {
    //le point d'entrée
    public static void triFusion(ArrayList<Integer> vInt, int inf, int sup) {
        // { vInt[inf..sup] non vide } => { vInt[inf..sup] trié

        if (inf < sup) {
            int m = (inf + sup) / 2;
            triFusion(vInt, inf, m); // appel récursif sur tranche gauche
            triFusion(vInt, m + 1, sup); // appel récursif sur tranche droite
            fusionTabGTabD(vInt, inf, m, sup); // appel du worker : tri de inf à sup
        }
    }

    //le worker
    public static void fusionTabGTabD(ArrayList<Integer> vInt, int inf, int m, int sup) {
            // { inf <= sup, m = (inf+sup)/2, vInt[inf..m] trié, vInt[m+1..sup] trié }
            // => { VInt[inf..sup] trié
        ArrayList<Integer> vTemp = new ArrayList<>();

        int i = inf;
        int j = m+1;

        while(i < m && j < sup){
            if(vInt.get(inf) < vInt.get(m+1)){
                vTemp.add(vInt.get(inf));
                i++;
            }else{
                vTemp.add(vInt.get(m+1));
                j++;
            }
        }

        for(int k=0; k < vTemp.size(); k++){
            vInt.set(k,vTemp.get(k));
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> v = new ArrayList<>(Arrays.asList(4,37,12,8,-5,9,1));
        System.out.println("Vecteur d'entier de " + v.size() + " éléments: " + v);
        triFusion(v,0,v.size()-1);
        System.out.println("Vecteur d'entier de " + v.size() + " éléments après le tri par fusion: " + v);

    }

}
