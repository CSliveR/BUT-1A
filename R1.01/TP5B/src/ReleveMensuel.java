public class ReleveMensuel {
    private String mois;
    private float concentration;

    public ReleveMensuel(String mois, float concentration){
        this.mois = mois;
        this.concentration = concentration;
    }
    public String getMois() {
        return mois;
    }

    public float getConcentration() {
        return concentration;
    }

    public String toString() {
        return mois + " : " + concentration;
    }

}
