package tp2.telephone;

public class TestTelephone {
    public static void main(String[] args) {
        // Liste de processeurs disponibles : Octa-Core 2.84Ghz et Octa-Core 3Ghz
        // A COMPLETER
        Processeur processeur1 = new Processeur("Octa-Core", 2.84);
        Processeur processeur2 = new Processeur("Octa-Core", 3);

        // Liste de ram disponibles : LPDDR5 4G et LPDDR5 8G
        // A COMPLETER

        Memoire ram1 = new Memoire("LPDDR5 4G",4);
        Memoire ram2 = new Memoire(ram1.getType() + " + " + ram1.getType(), ram1.getNombreGiga()*2);

        // Liste de stockage disponibles : 3 mémoires UFS Storage 3.1 de grandeur 64/128/256
        // A COMPLETER
        Memoire stockage1 = new Memoire("UFS Storage 3.1", 64);
        Memoire stockage2 = new Memoire("UFS Storage 3.1", 128);
        Memoire stockage3 = new Memoire("UFS Storage 3.1", 256);

        // Liste d'écran disponibles : 3 amoled de tailles 5/6/7
        // A COMPLETER
        Ecran ecran1 = new Ecran("amoled",5);
        Ecran ecran2 = new Ecran("amoled",6);
        Ecran ecran3 = new Ecran("amoled",7);

        ///// Construction des téléphones
        // Bas de gamme
        // A COMPLETER
        Telephone telephone1 = new Telephone(processeur1, stockage1, ecran1);
        telephone1.addRam(ram1);
        // Bas de gamme +
        Telephone telephone2 = new Telephone(processeur1, stockage2, ecran1);
        telephone2.addRam(ram2);
        // Milieu de gamme
        Telephone telephone3 = new Telephone(processeur1, stockage2, ecran2);
        telephone3.addRam(ram2);
        // Haut de gamme
        Telephone telephone4 = new Telephone(processeur2, stockage3, ecran3);
        telephone4.addRam(new Memoire("LPDDR5 8G + LPDDR5 8G", ram2.getNombreGiga()*2));

        System.out.println(telephone1);
        System.out.println(telephone2);
        System.out.println(telephone3);
        System.out.println(telephone4);

    }
}
