public class Explore_Strings {
        private static int nbOccCar(String uneChaine, char unCar) {
            // { } => { résultat = nombre de fois où le caractère unCar
            // apparaît dans la chaîne uneChaine

            int nbOcc = 0;

            for(int i = 0; i < uneChaine.length(); i++){
                if(unCar == uneChaine.charAt(i)){
                    nbOcc ++;
                }
            }
            return nbOcc;
        }

        private static int nbLettresMajSansAccent(String uneChaine) {
            // { } => { résultat = nombre de lettres majuscules
            // non accentuées dans uneChaine

            int nbMaj = 0;

            for(int i = 0; i < uneChaine.length(); i++){
                if(uneChaine.charAt(i) >= 'A' & uneChaine.charAt(i) <= 'Z'){
                    nbMaj ++;
                }
            }

            return nbMaj;
        }

        private static int nbMots(String uneChaine) {
            // { uneChaine ne contient que :
            // * des lettres de l'alphabet (accentuées ou non)
            // * des espaces
            // * un point final }
            // => { résultat = nombre de mots dans uneChaine
            // NOTE : un mot est constitué de lettres de l'alphabet

            int nbMots = 0;

            for(int i=0; i < uneChaine.length(); i++){
                if(uneChaine.charAt(i)  == ' ' | uneChaine.charAt(i) == '.'){
                    nbMots ++;
                }
            }

            return nbMots;
        }

        private static int nbCarMax(String uneChaine) {
            // { uneChaine ne contient que :
            // * des lettres de l'alphabet (accentuées ou non)
            // * des espaces
            // * un point final }
            // => { résultat = plus grand nombre de caractères
            // d'un mot de uneChaine
            // NOTE : un mot est constitué de lettres de l'alphabet

            int nbCarMot = 0;

            for(int i = 0; i < nbMots(uneChaine); i++){
                if(uneChaine.charAt(i) != ' ' | uneChaine.charAt(i) != '.'){
                    nbCarMot = Math.max(i,i+1);

                }
            }

            return nbCarMot;
        }

        public static void main(String[] args) {
            String lipogramme = "Un rond pas tout à fait clos, fini par un trait horizontal";
            String lesVoyellesSansAccent = "aeiouy";
            String ch1 = "Il y a huit mots dans cette phrase.";
            String ch2 = "CE TP GAGNERAIT À ETRE TERMINÉ.";
            String ch3 = "CE TP JAVA.";

            System.out.println("Analyse de la chaîne: " + lipogramme);
            System.out.println("*nombre de 'a': " + nbOccCar(lipogramme,lesVoyellesSansAccent.charAt(0)));
            System.out.println("*nombre de 'e': " + nbOccCar(lipogramme,lesVoyellesSansAccent.charAt(1)));
            System.out.println("*nombre de 'i': " + nbOccCar(lipogramme,lesVoyellesSansAccent.charAt(2)));
            System.out.println("*nombre de 'o': " + nbOccCar(lipogramme,lesVoyellesSansAccent.charAt(3)));
            System.out.println("*nombre de 'u': " + nbOccCar(lipogramme,lesVoyellesSansAccent.charAt(4)));
            System.out.println("*nombre de 'y': " + nbOccCar(lipogramme,lesVoyellesSansAccent.charAt(5)));
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("NOMBRE DE MOTS");
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("Nombre de mots dans la chaîne " + ch1 +  " : " + nbMots(ch1));
            System.out.println("Nombre de mots dans la chaîne " + ch2 + " : " + nbMots(ch2));
            System.out.println("------------------------------------------------");
            System.out.println("NOMBRE DE MAJUSCULES NON ACCENTUÉES");
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("Nombre de majuscules non accentuées dans la chaine " + ch1 + " : " + nbLettresMajSansAccent(ch1));
            System.out.println("Nombre de majuscules non accentuées dans la chaine " + ch2 + " : " + nbLettresMajSansAccent(ch2));
            System.out.println("------------------------------------------------");
            System.out.println("PLUS GRAND NOMBRE DE CARACTÈRES D'UN MOT");
            System.out.println();
            System.out.println("------------------------------------------------");
            System.out.println("Nombre maximal de caractères d'un mot de la chaîne " + ch1 + " : " +  nbCarMax(ch1));
            System.out.println("Nombre maximal de caractères d'un mot de la chaîne " + ch2 + " : " +  nbCarMax(ch2));
            System.out.println("Nombre maximal de caractères d'un mot de la chaîne " + ch3 + " : " +  nbCarMax(ch3));
        }
}

