public class Polar implements Comparable<Polar> {

    // attributs
    private int annee; // année de première parution
    private String auteur; // auteur du roman policier
    private String titre; // titre du roman policier

    // constructeur
    public Polar(int annee, String auteur, String titre) {
	// À COMPLÉTER...
        this.annee = annee;
        this.auteur = auteur;
        this.titre = titre;
    }

    // getters
    public int getAnnee() {
	// À COMPLÉTER...
        return annee;
    }
   public String getAuteur() {
	// À COMPLÉTER...
        return auteur;
    }
    public String getTitre() {
	// À COMPLÉTER...
        return titre;
    }

    @Override
    // ordre naturel sur l'année et à année égale sur l'auteur : ordre (annee, auteur)
    public int compareTo(Polar o) {
        // { } =>
        // { résultat =
        //      * -1 si l'attribut annee de cePolar est inférieur à celui de o,
        //             ou si l'attribut annee de cePolar est égal à celui de o
        //                  et l'attribut auteur de cePolar précède celui de o selon l'ordre lexicograpique
        //      *  0 si les attributs annee de cePolar et de o sont égaux
        //            et les attributs auteur de cePolar et de o sont selon l'ordre lexicographique
        //       *  1 dans tous les autres cas
        //  À MODIFIER...

        if(this.annee < o.annee || (this.annee == o.annee && this.auteur.compareTo(o.auteur) < 0)){
            return -1;
        }else if(this.annee == o.annee && this.auteur.compareTo(o.auteur) == 0){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    // traduction en chaîne de caractères
    public String toString() {
        // { } =>
        // { résultat = chaîne représentant les attributs de cePolar
        //   EXEMPLE : (2019, SYLVAIN, Kabukicho}
        // À MODIFIER...

            return "(" + annee + ", " + auteur + ", " + titre + ")";
    }
}