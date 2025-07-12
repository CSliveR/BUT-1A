package tp1.universite;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  La classe Etudiant représente la notion d'étudiant (login, nom, prénom
 * et adresse).
 * * ATTENTION des contraintes sur la notion d’étudiant :
 * * – un étudiant doit toujours avoir un login en minuscule
 * * – un étudiant doit toujours avoir un nom et un prénom avec
 * * le premier caractère en majuscule et les autres en minuscule.
 */

public class Etudiant {
    private String login;
    private String prenom;
    private String nom;
    private String adresse;
    private double[] notes = new double[5];
    private int indice = 0;

    public Etudiant(String login, String prenom, String nom){
        setLogin(login);
        setPrenom(prenom);
        setNom(nom);
    }

    /**
     * Renvoie le login d'un Etudiant
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Renvoie le nom d'un Etudiant
     * @return nom
     */

    public String getNom() {
        return nom;
    }

    /**
     * Renvoie le prénom d'un Etudiant
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Renvoie le nom complet d'un Etudiant
     * @return prenom + " " + nom
     */

    public String getNomComplet(){
        return prenom + " " + nom;
    }

    /**
     * Renvoie l'adresse d'un Etudiant si elle existe, la chaine "aucune" sinon
     * @return adresse
     *         "aucune"
     */

    public String getAdresse() {
        if (existAdresse()){
            return adresse;
        }else{
            return "aucune";
        }
    }

    /**
     * Renvoie le mail d'un Etudiant
     * @return prenom + "." + nom + "@etu.univ-grenoble-alpes.fr"
     */

    public String getMail(){
        return prenom + "." + nom + "@etu.univ-grenoble-alpes.fr";
    }

    /**
     * Renvoie un tableau de 5 notes d'un Etudiant
     * @return notes
     */

    public double[] getNotes() {
        return notes;
    }

    /**
     * Renvoie un indice qui compte le nombre de notes du tableau
     * @return indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * Vérifier l'existence d'un adresse pour l'étudiant
     *@return Vrai si l'étudiant a une adresse, Faux sinon
     */
    public boolean existAdresse(){
        return adresse != null;
    }

    /**
     *Met le login de l'Etudiant en minuscule
     *@param login
     */

    public void setLogin(String login) {
        this.login = login.toLowerCase();
    }

    /**
     *Met la première lettre du nom en majuscule
     *@param nom
     */
    public void setNom(String nom) {
        this.nom = EtudiantUtilitaire.capitalize(nom);
    }

    /**
     *Met la première lettre du prenom en majuscule
     *@param prenom
     */

    public void setPrenom(String prenom) {
        this.prenom = EtudiantUtilitaire.capitalize(prenom);
    }

    /**
     *Met l'adresse de l'Etudiant à l'adresse passée en paramètre
     *@param adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Calcule la moyenne des notes d'un Etudiant
     * @return somme/indice
     */

    public double getMoyenne(){
        double somme = 0;

        if(notes.length == 0){
            return 0;
        }else{
            for(int i=0; i < notes.length; i++){
                somme+=notes[i];
            }

            return somme/ indice;
        }
    }

    /**
     * Incrémente la valeur de l'indice et insère la note passée en paramètre à la position indice
     * @param note
     */

    public void addNote(double note){
        indice++;
        notes[indice] = note;
    }



}
