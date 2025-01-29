public class Cercle {
    // Constante PI (rapport constant du périmètre d'un cercle à son diamètre)
    final double PI = 3.14;
    // Attribut
    float rayon;  // longueur du rayon

    public Cercle(float rayon) {
        this.rayon = rayon;
    }


    // Méthodes
    // 1 - getter - À DÉCOMMENTER ET COMPLÉTER
    public float getRayon() {
        return rayon;
    }

    //2 - périmètre - À DÉCOMMENTER ET COMPLÉTER
    public float getPerimetre() {
        // { } => { Résultat = périmètre de ce Cercle }
        return (float) (PI*rayon*2);
    }

    // 3 - surface - À DÉCOMMENTER ET COMPLÉTER
    public float getSurface() {
        // { } => { Résultat = surface de ce Cercle }
        return (float) (PI*rayon*rayon);
    }

    // Pour l'affichage du rayon, du périmètre et de la surface de ce Cercle
    @Override
    public String toString() {
        return "Rayon : "+ rayon + " | Périmètre : " + getPerimetre() + " | Surface : " + getSurface();
    }
}
