package be.ugent.objprog.schaakpuzzel.stukken;

import be.ugent.objprog.schaakpuzzel.Stuk;

public class Dame extends Stuk {
    @Override
    public char getLetter() {
        return 'D';
    }

    @Override
    public boolean bedreigtPositie(int rij, int kolom) {
        return
            getRij() == rij || getKolom() == kolom ||
            getRij() + getKolom() == rij + kolom ||
            getRij() + kolom == rij + getKolom();
    }
}
