public class Utilitaire {
    //Liste triée croissante sans doublons, construite à partir d'une liste triée croissante non vide, contenant potentiellement des doublons
    public static ListeTrieeC<Integer> lCsansDoublons(ListeTrieeC<Integer> lC){
        // { lC non vide, avec potentiellement des doublons } =>
        // { résultat = nouvelle liste triée croissante dont les cellules portent
        // les mêmes entiers que lC, mais sans doublons

        ListeTrieeC<Integer> lcsdb = new ListeTrieeC<>();
        Cellule<Integer> cellCour = lC.getTete();
        int val;

        while(cellCour != null){
            val = cellCour.getInfo();
            lcsdb.insereTrie(val);
            cellCour = cellCour.getCelluleSuivante();
            while(cellCour != null && cellCour.getInfo() == val){
                cellCour = cellCour.getCelluleSuivante();
            }
        }

        return lcsdb;
    }

    //a) Existence d'un entier donné dans une liste triée croissante sans doublons
    //le worker (récursif)
    private static boolean estDansListeC_wk(Cellule<Integer> cellCour, int unEnt) {

        if (cellCour == null){
            return false;
        } else if(cellCour.getInfo() == unEnt) {
            return true;
        } else {
            return estDansListeC_wk(cellCour.getCelluleSuivante(), unEnt);
        }
    }

    //le point d'entrée
    public static boolean estDansListeC(ListeTrieeC<Integer> lC, int unEnt) {
        // { lC non vide, sans doublons } =>
        // { résultat = vrai s'il existe une cellule de lC portant l'entier unEnt,
        // faux sinon

        return estDansListeC_wk(lC.getTete(),unEnt);
    }


    //(b) Union dans une nouvelle liste triée croissante de deux listes triées croissantes sans doublons
    public static ListeTrieeC<Integer> union(ListeTrieeC<Integer> lC1_sdb, ListeTrieeC<Integer> lC2_sdb) {
        // { lC1_sdb et lC2_sdb non vides, sans doublons } =>
        // { résultat = liste triée croissante, contenant, sans doublons,
        // les entiers portés par les cellules de lC1_sdb et
        // les entiers portés par les cellules de lC2_sdb

        ListeTrieeC<Integer> ltc = new ListeTrieeC<>();
        Cellule<Integer> cellCour1 = lC1_sdb.getTete();
        Cellule<Integer> cellCour2 = lC2_sdb.getTete();

        while(cellCour1 != null && cellCour2 != null){
            if(cellCour1.getInfo() < cellCour2.getInfo()){
                ltc.insereTrie(cellCour1.getInfo());
                cellCour1 = cellCour1.getCelluleSuivante();
            }else{
                ltc.insereTrie(cellCour2.getInfo());
                cellCour2 = cellCour2.getCelluleSuivante();
            }
        }
        return ltc;
    }

    //(c) Intersection dans une nouvelle liste triée croissante de deux listes triées croissantes sans doublons
    public static ListeTrieeC<Integer> intersect(ListeTrieeC<Integer> lC1_sdb, ListeTrieeC<Integer> lC2_sdb) {
        // { lC1_sdb et lC2_sdb non vides, sans doublons } =>
        // { résultat = liste triée croissante, contenant, sans doublons,
        // les entiers portés par les cellules de lC1_sdb qui sont
        // égaux à ceux portés par les cellules de lC2_sdb

        ListeTrieeC<Integer> ltc = new ListeTrieeC<>();
        Cellule<Integer> cellCour1 = lC1_sdb.getTete();
        Cellule<Integer> cellCour2 = lC2_sdb.getTete();

        while(cellCour1 != null && cellCour2 != null){
            if(cellCour1.getInfo() < cellCour2.getInfo()) {
                cellCour1 = cellCour1.getCelluleSuivante();
            }else{
                cellCour2 = cellCour2.getCelluleSuivante();
            }

            if(cellCour1.getInfo() == cellCour2.getInfo()){
                ltc.insereTrie(cellCour1.getInfo());
                cellCour1 = cellCour1.getCelluleSuivante();
                cellCour2 = cellCour2.getCelluleSuivante();
            }

        }
        return ltc;
    }

}