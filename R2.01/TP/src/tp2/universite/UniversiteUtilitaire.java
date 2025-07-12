package tp2.universite;

public class UniversiteUtilitaire {

    public static void affichePersonne(Personne p){
        System.out.println("-----------------");
        System.out.println("Login : " + p.getLogin());
        System.out.println("Nom complet : " + p.getNomComplet());
        System.out.println("Mail : " + p.getMail());
        if (p.existAdresse()){
            System.out.println("Adresse : " + p.getAdresse());
        } else {
            System.out.println("aucune adresse");
        }
    }

    public static void affichePersonnel(Personnel p){
        System.out.println("-----------------");
        System.out.println("Login : " + p.getLogin());
        System.out.println("Nom complet : " + p.getNomComplet());
        System.out.println("Mail : " + p.getMail());
        System.out.println("Adresse : " + p.getAdresse());
        System.out.println("Echelon : " + p.getEchelon());
        System.out.println("Point d'indice : " + p.getPointDindice());
        System.out.println("Salaire : " + p.getSalaire());
    }


    public static String capitalize(String chaine){
        chaine = chaine.toLowerCase();
        char firstLetter = chaine.charAt(0);
        char majFirstLetter = Character.toUpperCase(firstLetter);

        //Exercice 1.5

        if(chaine.contains("-")){
            char firstLetter2 = chaine.substring(chaine.indexOf("-")).charAt(1);
            char majFirstLetter2 = Character.toUpperCase(firstLetter2);
            return majFirstLetter + chaine.substring(1,chaine.indexOf(firstLetter2)) + majFirstLetter2 +
                    chaine.substring(chaine.indexOf(firstLetter2)+1);
        }else{
            return majFirstLetter + chaine.substring(1);
        }


    }

}
