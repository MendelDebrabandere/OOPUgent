package be.ugent.objprog.vormen;

public abstract class RechteVorm implements Vorm {

    protected double breedte;

    protected double hoogte;

    protected RechteVorm(double breedte, double hoogte) {
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    public double getBreedte() {
        return breedte;
    }

    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    public double getHoogte() {
        return hoogte;
    }

    public void setHoogte(double hoogte) {
        this.hoogte = hoogte;
    }

}
