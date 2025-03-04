package fractions;

/**
 * Gemeenschappelijke bovenklasse van de implementaties van {@link Expression}
 */
public abstract class Expression {

    /**
     * Breedte van het corresponderende blok
     */
    protected int width;

    /**
     * Hoe ver komt het blok boven de baseline
     */
    protected int height;

    /**
     * Hoe ver komt het blok onder de baseline
     */
    protected int depth;

    /**
     * Rijnummer van de bovenste lijn van het blok
     */
    protected int row;

    /**
     * Kolomnummer van de linkerkant van het blok
     */
    protected int column;

    /**
     * Bereken de breedte van het corresponderende blok
     */
    public abstract void computeWidth();

    /**
     * Bereken de hoogte en diepte van het corresponderende blok
     */
    public abstract void computeHeightAndDepth();

    /**
     * Bereken de coördinaten van de 'kinderen' van dit blok aan de hand van
     * de coördinaten van dit blok zelf (en van hun kinderen ...).
     */
    public abstract void computeCoordinates();

    /**
     * Wat is het letterteken op de opgegeven plaats? Zal enkel worden opgeroepen
     * wanneer de plaats binnen het corresponderende blok ligt.
     */
    public abstract char charAt(int rij, int kolom);

    /**
     * Hoe breed is het corresponderende blok (in lettertekens)
     */
    public int getWidth() {
        return width;
    }

    /**
     * Wat is de totale hoogte van het corresponderende blok (in lettertekens)
     */
    public int getTotalHeight() {
        return height + depth;
    }
}
