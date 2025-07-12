package tp2.universite;


import java.util.Comparator;

/**
 *  La classe Etudiant représente la notion d'étudiant (login, nom, prénom
 * et adresse).
 * * ATTENTION des contraintes sur la notion d’étudiant :
 * * – un étudiant doit toujours avoir un login en minuscule
 * * – un étudiant doit toujours avoir un nom et un prénom avec
 * * le premier caractère en majuscule et les autres en minuscule.
 */
public class Etudiant extends Personne implements Comparable<Etudiant> {
    private String adresseParent;
    private double[] notes = new double[5];
    private int indice = 0;
    private Groupe groupe = new Groupe("A");

    public Etudiant(String login, String prenom, String nom){
        super(login, prenom, nom);
    }

    public Etudiant(String login, String prenom, String nom, String adresse, String adresseParent){
        super(login, prenom, nom, adresse);
        setAdresse(adresse,adresseParent);
    }

    /**
     *Renvoie le mail d'un Etudiant
     * @return getPrenom() + "." + getNom() + "@etu.univ-grenoble-alpes.fr"
     */
    @Override
    public String getMail(){
        return getPrenom() + "." + getNom() + "@etu.univ-grenoble-alpes.fr";
    }

    /**
     *l'adresse d'un étudiant et de ses parents
     *l'adresse de l'étudiant uniquement si celle des parents n'est pas renseignée
     *aucune des deux si aucune adresse est renseignée
     * @return super.getAdresse() + " (Adresse des parents " + adresseParent + ")"
     *         super.getAdresse()
     *         aucune
     */

    @Override
    public String getAdresse() {
        if (super.existAdresse() && existAdresseParent()){
            return super.getAdresse() + " (Adresse des parents " + adresseParent + ")";
        }else if(super.existAdresse()){
            return super.getAdresse();
        }else{
            return getAdresseParent();
            /*Avec le existAdresse en bas, on a forcement au moins l'adresse des parents*/
        }
    }

    /**
     *Retourne l'adresse des parents
     * @return adresseParent
     */

    public String getAdresseParent(){
        return adresseParent;
    }

    /**Vérifie si l'adresse des parents existe
     * @return adresseParent != null && !adresseParent.isEmpty()
     */

    public boolean existAdresseParent(){
        return adresseParent != null && !adresseParent.isEmpty();
    }

    /**
     *Vérifie si une des 2 adresses est renseignée
     * @return super.existAdresse() || existAdresseParent()
     */
    @Override
    public boolean existAdresse(){
        return super.existAdresse() || existAdresseParent();
    }

    /**
     * Modifie l'adresse de l'étudiant avec celle des parents
     * @param adresseEtudiant
     * @param adresseParent
     */

    public void setAdresse(String adresseEtudiant, String adresseParent){
        setAdresse(adresseEtudiant);
        this.adresseParent = adresseParent;
    }

    /**
     * Calcule la moyenne des valeurs du tableau de notes d'un Etudiant
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
     * Incrémente la valeur d'un indice et ajoute une note à cet indice dans le tableau de notes d'un Etudiant
     * @param note
     */

    public void addNote(double note){
        indice++;
        notes[indice] = note;
    }

    /**
     * Ordre naturel sur l'attribut nom d'un Etudiant et pour un même nom, ordre naturel sur son prénom
     * @param e the object to be compared.
     * @return this.getNom().compareTo(e.getNom())
     *         this.getPrenom().compareTo(e.getPrenom())
     */

    @Override
    public int compareTo(Etudiant e){
        if(this.getNom().compareTo(e.getNom()) != 0){
            return this.getNom().compareTo(e.getNom());
        }else{
            return this.getPrenom().compareTo(e.getPrenom());
        }
    }

    public static final Comparator<Etudiant> CompEtudiantTriParMoyenne = new Comparator<Etudiant>() {
        @Override
        public int compare(Etudiant e1, Etudiant e2) {
            if(e1.getMoyenne() < e2.getMoyenne()){
                return -1;
            }else if(e1.getMoyenne() == e2.getMoyenne()){
                return 0;
            }else{
                return 1;
            }
        }
    };

    public boolean existGroupe(){
        return groupe != null;
    }

    public boolean isContainedGroupe(Groupe groupe){
        return this.existGroupe();
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        if(this.isContainedGroupe(groupe)){
            getGroupe().removeEtudiant(this);
            getGroupe().addEtudiant(this);
        }else{
            getGroupe().addEtudiant(this);
        }
    }


}
