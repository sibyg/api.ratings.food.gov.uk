package uk.gov.food.ratings.api.domain;

public class Scores {
    private int Hygiene;

    public int getHygiene() {
        return this.Hygiene;
    }

    public void setHygiene(int Hygiene) {
        this.Hygiene = Hygiene;
    }

    private int Structural;

    public int getStructural() {
        return this.Structural;
    }

    public void setStructural(int Structural) {
        this.Structural = Structural;
    }

    private int ConfidenceInManagement;

    public int getConfidenceInManagement() {
        return this.ConfidenceInManagement;
    }

    public void setConfidenceInManagement(int ConfidenceInManagement) {
        this.ConfidenceInManagement = ConfidenceInManagement;
    }
}