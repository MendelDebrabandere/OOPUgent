package be.ugent.objprog.schaakpuzzel.stukken;

import be.ugent.objprog.schaakpuzzel.Stuk;

public class Amazone extends Stuk {
    @Override
    public char getLetter() {
        return 'A';
    }

    @Override
    public boolean bedreigtPositie(int rij, int kolom) {
        int dr = getRij() - rij;
        int dk = getKolom() - kolom;

        return
            getRij() == rij || getKolom() == kolom ||
            getRij() + getKolom() == rij + kolom ||
            getRij() + kolom == rij + getKolom() ||
            dr * dr + dk * dk == 5;
    }
}
