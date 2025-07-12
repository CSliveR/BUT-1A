package tp2.universite;
/**
 *  La classe Personne représente la notion de Personne (login, nom, prénom et adresse).
 */

public abstract class Personne {
    private String login;
    private String nom;
    private String prenom;
    private String adresse;

    public Personne(String login, String prenom, String nom){
        setLogin(login);
        setPrenom(prenom);
        setNom(nom);
    }

    public Personne(String login, String prenom, String nom, String adresse){
        setLogin(login);
        setPrenom(prenom);
        setNom(nom);
        setAdresse(adresse);
    }

    /**
     * Retourne le login d'une Personne
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Retourne le prénom d'une Personne
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Retourne le nom d'une Personne
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Retourne le nom complet d'une Personne
     * @return prenom + " " + nom
     */
    public String getNomComplet(){
        return prenom + " " + nom;
    }
    /**
     * Retourne l'adresse d'une Personne si elle existe "aucune" sinon
     * @return adresse, "aucune" sinon
     */

    public String getAdresse() {
        return adresse;
    }

    public abstract String getMail();

    /**
     * Vérifier l'existence d'une adresse pour une personne
     * @return Vrai si la personne a une adresse, Faux sinon
     */
    public boolean existAdresse(){
        return adresse != null && !adresse.isEmpty();
    }

    /**
     *Modifie le login de la Personne en minuscule
     * @param login
     */
    public void setLogin(String login) {
        this.login = login.toLowerCase();
    }

    /**
     *Modifie la première lettre du prénom de la Personne en majuscule
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = UniversiteUtilitaire.capitalize(prenom);
    }

    /**
     * Modifie la première lettre du nom de la Personne en majuscule
     * @param nom
     */

    public void setNom(String nom) {
        this.nom = UniversiteUtilitaire.capitalize(nom);
    }

    /**
     * Modifie l'adresse de la Personne
     * @param adresse
     */

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
