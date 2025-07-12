package tp6;

public class ArticleUtilitaire {
    public static String capitalize(String chaine){
        chaine = chaine.toLowerCase();
        char firstLetter = chaine.charAt(0);
        char majFirstLetter = Character.toUpperCase(firstLetter);
        return majFirstLetter + chaine.substring(1);
    }
}
