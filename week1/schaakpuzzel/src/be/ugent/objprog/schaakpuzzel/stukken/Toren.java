package be.ugent.objprog.schaakpuzzel.stukken;

import be.ugent.objprog.schaakpuzzel.Stuk;

public class Toren extends Stuk {
    @Override
    public char getLetter() {
        return 'T';
    }

    @Override
    public boolean bedreigtPositie(int rij, int kolom) {
        return
                getRij() == rij || getKolom() == kolom;
    }
}
