public class Rectangle {
    // un rectangle est défini par la longueur de ses côtés
    // quelle que soit sa position dans le plan

    // Attributs
    private float cote1; // longueur d'un côté
    private float cote2; // longueur des côtés adjacents à cote1

    // Constructeur - À DÉCOMMENTER ET COMPLÉTER
    public Rectangle(float cote1, float cote2) {
        this.cote1 = cote1;
        this.cote2 = cote2;
        
    }
    // Méthodes
    // 1 - getters 
    //1.1 - valeur de cote1 -  À DÉCOMMENTER ET COMPLÉTER
    public float getCote1() {
        return cote1;
     }
    //1.2 - valeur de cote2 -  À DÉCOMMENTER ET COMPLÉTER
    public float getCote2() {
        return cote2;
     }

    //2 - périmètre  -  À DÉCOMMENTER ET COMPLÉTER
    public float getPerimetre() {
        // { } => { résultat = périmètre de ce Rectangle }
        return (cote1 + cote2)*2;
    }

    // 3 - surface - À DÉCOMMENTER ET COMPLÉTER
    public float getSurface() {
        // { } => { résultat = surface de ce Rectangle }
        return cote1*cote2;
    }

    public Cercle cercleInscrit() {
        // { } => { résultat = le Cercle inscrit dans ceRectangle
        if (cote1 < cote2) {
            return new Cercle(cote1/2);
        }else{
            return new Cercle(cote2/2);
        }

    }
    public Cercle cercleCirconscrit() {
        // { } => { résultat = le Cercle circonscrit à ceRectangle

        return new Cercle((float) Math.sqrt(Math.pow(cote1,2) + Math.pow(cote2,2))/2);
    }

    // Pour l'affichage des cotés, du périmètre et de la surface de ce Rectangle
    // À DÉCOMMENTER ET NE PAS MODIFIER !!!
    @Override
    public String toString() {
        return "Cotés : ("+ cote1 + ", " + cote2 + ") | Périmètre : " + getPerimetre() + " | Surface : " + getSurface();
    }
}
