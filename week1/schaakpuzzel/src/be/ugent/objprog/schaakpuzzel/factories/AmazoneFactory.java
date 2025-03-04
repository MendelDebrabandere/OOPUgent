package be.ugent.objprog.schaakpuzzel.factories;

import be.ugent.objprog.schaakpuzzel.Stuk;
import be.ugent.objprog.schaakpuzzel.stukken.Amazone;

public class AmazoneFactory implements StukFactory{
    @Override
    public Stuk creerStuk() {
        return new Amazone();
    }
}
