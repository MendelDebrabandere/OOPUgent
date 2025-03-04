package be.ugent.objprog.schaakpuzzel.stukken;

import be.ugent.objprog.schaakpuzzel.Stuk;

public class Loper extends Stuk {
    @Override
    public char getLetter() {
        return 'L';
    }

    @Override
    public boolean bedreigtPositie(int rij, int kolom) {
        return
                getRij() + getKolom() == rij + kolom ||
                getRij() + kolom == rij + getKolom();
    }
}
