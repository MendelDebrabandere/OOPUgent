package be.ugent.objprog.schaakpuzzel.stukken;

import be.ugent.objprog.schaakpuzzel.Stuk;

public class Paard extends Stuk {
    @Override
    public char getLetter() {
        return 'P';
    }

    @Override
    public boolean bedreigtPositie(int rij, int kolom) {
        int dr = getRij() - rij;
        int dk = getKolom() - kolom;
        return dr * dr + dk * dk == 5;  // [!] wiskundig truukje
    }
}
