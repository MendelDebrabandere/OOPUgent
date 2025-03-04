package be.ugent.objprog.schaakpuzzel.factories;

import be.ugent.objprog.schaakpuzzel.Stuk;
import be.ugent.objprog.schaakpuzzel.stukken.Paard;

public class PaardFactory implements StukFactory{
    @Override
    public Stuk creerStuk() {
        return new Paard();
    }
}
