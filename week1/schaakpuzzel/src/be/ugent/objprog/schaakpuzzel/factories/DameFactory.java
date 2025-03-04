package be.ugent.objprog.schaakpuzzel.factories;

import be.ugent.objprog.schaakpuzzel.Stuk;
import be.ugent.objprog.schaakpuzzel.stukken.Dame;

public class DameFactory implements StukFactory{
    @Override
    public Stuk creerStuk() {
        return new Dame();
    }
}
