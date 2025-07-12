package tp2.telephone;


import java.util.ArrayList;

public class Telephone {
    private String libelle;
    private Processeur processeur;
    private Memoire stockage;
    private ArrayList<Memoire> ram = new ArrayList<>();
    private Ecran ecran;

    public Telephone(Processeur processeur, Memoire stockage, Ecran ecran){
        this.processeur = processeur;
        this.stockage = stockage;
        this.ecran = ecran;
    }

    /**
     * Ajoute la ram passée en paramètre à l'ArrayList de ram
     * @param ram
     */

    public void addRam(Memoire ram){
        this.ram.add(ram);
    }

    /**
     *
     * @return
     */

    public int getNombreGigaRam(){
        int somme = 0;
        for(int i=0; i < ram.size();i++){
            somme+=ram.get(i).getNombreGiga();
        }
        return somme;
    }

    /**
     * Affiche les caractérisques d'un téléphone
     * @return "processeur = " + processeur.getLibelle() + " (" + processeur.getFrequence() + "GHz), " +
     *                 "ram = " + ram.get(0).getNombreGiga() + "Giga " + "[" + ram.get(0).getType() + "]" +
     *                 " ,stockage = [" + stockage.getType() + ", " + stockage.getNombreGiga() + "Giga] , " +
     *                 "ecran = [" + ecran.getType() + ", " + ecran.getTaille() + " pouces]"
     */

    @Override
    public String toString(){
        return "processeur = " + processeur.getLibelle() + " (" + processeur.getFrequence() + "GHz), " +
                "ram = " + ram.get(0).getNombreGiga() + "Giga " + "[" + ram.get(0).getType() + "]" +
                " ,stockage = [" + stockage.getType() + ", " + stockage.getNombreGiga() + "Giga] , " +
                "ecran = [" + ecran.getType() + ", " + ecran.getTaille() + " pouces]";
    }
}
