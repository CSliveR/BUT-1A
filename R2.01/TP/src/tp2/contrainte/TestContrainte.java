package tp2.contrainte;

public class TestContrainte {
    public static void main(String[] args) {
        Note note1 = new Note();
        Note note2 = new Note(10);

        System.out.println(note1);
        System.out.println(note2);

        System.out.println(note1.getValeur());
        System.out.println(note2.getValeur());

        note2.setValeur(14);
        System.out.println(note2.getValeur());

        note2.setValeur(-3);
        System.out.println(note2.getValeur());

        Note note3 = ContrainteUtilitaire.saisir();
        System.out.println(note3);

    }

}
