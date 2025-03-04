package be.ugent.objprog.muizenhuis;

public interface Toestand {

    Toestand linksAan(Kamers kamers);
    Toestand linksUit(Kamers kamers);

    Toestand rechtsAan(Kamers kamers);
    Toestand rechtsUit(Kamers kamers);
}
