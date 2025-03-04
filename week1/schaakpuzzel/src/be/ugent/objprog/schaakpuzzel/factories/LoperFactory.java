package be.ugent.objprog.schaakpuzzel.factories;

import be.ugent.objprog.schaakpuzzel.Stuk;
import be.ugent.objprog.schaakpuzzel.stukken.Loper;

public class LoperFactory implements StukFactory{
    @Override
    public Stuk creerStuk() {
        return new Loper();
    }
}
