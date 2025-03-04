package be.ugent.objprog.schaakpuzzel.factories;

import be.ugent.objprog.schaakpuzzel.Stuk;
import be.ugent.objprog.schaakpuzzel.stukken.Toren;

public class TorenFactory implements StukFactory{
    @Override
    public Stuk creerStuk() {
        return new Toren();
    }
}
