package be.ugent.objprog.schaakpuzzel;

/**
 * Schaakstuk
 */
public abstract class Stuk {


    /**
     * De overeenkomstige code van dit stuk
     * 0: dame, 1: toren, 2: loper, 3: paard
     */
    public abstract char getLetter();

    /**
     * Rijpositie.
     */
    private int rij;

    /**
     * Rijpositie van dit stuk.
     */
    public int getRij() {
        return rij;
    }

    /**
     * Stel de rijpositie van dit stuk in.
     */
    public void setRij(int rij) {
        this.rij = rij;
    }

    /**
     * Kolompositie.
     */
    protected int kolom;

    /**
     * Kolompositie van dit stuk.
     */
    public int getKolom() {
        return kolom;
    }

    /**
     * Stel de kolompositie van dit stuk in.
     */
    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    public abstract boolean bedreigtPositie(int rij, int kolom);
}