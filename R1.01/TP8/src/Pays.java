public class Pays implements Comparable<Pays> {

    private String nom; // nom de ce Pays
    private String continent; // continent de ce Pays
    private int population; // nombre d'habitants de ce Pays
    private int superficie; // superficie de ce Pays

    // constructeur
    public Pays(String nom, String continent, int population, int superficie) {
        this.nom = nom;
        this.continent = continent;
        this.population = population;
        this.superficie = superficie;
    }

    // getters
    public String getNom() {
        return nom;
    }

    public String getContinent() {
        return continent;
    }

    public int getPopulation() {
        return population;
    }

    public int getSuperficie() {
        return superficie;
    }

    @Override
    // ordre naturel (continent, nom)  
    public int compareTo(Pays o) {
        // { } =>
        // { résultat = -1      si le continent de ce Pays précède celui de o,
        //                          ou si, le ce Pays a le même continent que o, mais son nom
        //                          précède celui de o (casse prise en compte)
        //  résultat =   0      si le continent et le nom de ce Pays sont les mêmes
        //                          que ceux de o (casse prise en compte)
        //  résultat =  1       dans tous les autres cas }

        // ÉCRIRE LE CODE ADÉQUAT À LA PLACE DE L'INSTRUCTION return 0;

        if(this.continent.compareTo(o.continent) < 0 || (this.continent.compareTo(o.continent) == 0 && this.nom.compareTo(o.nom) < 0)){
            return -1;
        }else if (this.continent.compareTo(o.continent) == 0 && this.nom.compareTo(o.nom) == 0) {
            return 0;
        }else{
            return 1;
        }
    }
    @Override
    // chaîne représentant ce Pays
    public String toString() {
        return (continent + " (" + nom +  " - " + population + " hab. - "  + superficie + " km2)");
    }
}