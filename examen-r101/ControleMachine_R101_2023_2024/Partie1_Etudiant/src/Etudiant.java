import java.util.ArrayList;

/**
 * CLASSE À COMPLÉTER - Exercices 2 et 3
 */
public class Etudiant {
    // attributs : nom, prenom et notes - Exercice 2
    private String nom;
    private String prenom;
    private ArrayList<Float> notes;

    // constructeur avec nom et prenom comme paramètres - Exercice 2
    public Etudiant(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        this.notes = new ArrayList<>();
    }


    // Accesseur
    // notes de cet Etudiant - Exercice 2

    public ArrayList<Float> getNotes() {
        return notes;
    }


    // Autres méthodes
    // Consultation du nom complet de cet Etudiant - Exercice 2

    public String getNomComplet() {
        return prenom + ' ' + nom;
    }

    // Ajout d'un élément dans notes de cet Etudiant - Exercice 2

    public void addNote(float note){
        notes.add(note);
    }


    // Nombre de notes de cet Etudiant - Exercice 2
    public int getNbNotes(){
        return notes.size();
    }


    // Consultation de la moyenne de notes pour cet Etudiant
    // V1 - Moyenne sachant que notes n'est pas vide - Exercice 2

    public float getMoyenneV1(){
        float somme = 0;

        for(int i=0; i < notes.size();i++){
            somme = somme + notes.get(i);
        }

        return somme / notes.size();
    }


    // V2 - Moyenne sachant que notes est peut-être vide - Exercice 3

    public float getMoyenneV2() throws ExceptionMoyenneNonCalculable {
        float somme = 0;

        if(notes.isEmpty()){
            throw new ExceptionMoyenneNonCalculable(getNomComplet() + " n'a pas de notes !");
        }else{
            for(int i=0; i < notes.size();i++){
                somme = somme + notes.get(i);
            }

            return somme / notes.size();
        }

    }
}
