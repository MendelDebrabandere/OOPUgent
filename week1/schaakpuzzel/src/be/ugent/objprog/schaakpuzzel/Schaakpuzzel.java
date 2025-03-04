package be.ugent.objprog.schaakpuzzel;

import be.ugent.objprog.schaakpuzzel.factories.*;
import be.ugent.objprog.schaakpuzzel.stukken.*;

import java.util.Map;

public class Schaakpuzzel {

    /**
     * Creëer een nieuw stuk aan de hand van de opgegeven code. Geef null terug
     * als er een foutieve code werd ingegeven.
     */
    private static Stuk decodeerLijn(String lijn) {
        if (lijn.length() != 3) {
            return null;
        }
        Stuk stuk;
        char ch = lijn.charAt(0);
        Map<Character, StukFactory> factoryHashmap = Map.of(
                'T', new TorenFactory(),
                'P', new PaardFactory(),
                'L', new LoperFactory(),
                'D', new DameFactory(),
                'A', new AmazoneFactory()
        );

        stuk = factoryHashmap.get(ch).creerStuk();

        int rij = lijn.charAt(2) - '1';
        int kol = lijn.charAt(1) - 'a';
        if (rij < 0 || rij > 7 || kol < 0 || kol > 7) {
            return null;
        }
        stuk.setRij(rij);
        stuk.setKolom(kol);
        return stuk;
    }

    /**
     * Hoofdprogramma: begint met een nieuw bord en laat de gebruiker
     * achtereenvolgens type en coördinaten van de stukken intikken. Drukt
     * telkens het nieuwe bord af. Het programma stopt zodra een stuk op een
     * positie wordt geplaatst die door een ander stuk wordt bedreigd.
     */
    public static void main(String[] args) {
        System.out.println(
                "Probeer zoveel mogelijk stukken op het bord te zetten");
        System.out.println("zonder dat ze elkaar kunnen slaan.");

        Lijnenlezer lezer = new Lijnenlezer();
        Bord bord = new Bord();
        int aantal = 0;

        String lijn = "";
        while (lijn != null) {
            System.out.println(bord);
            System.out.print("Zet> ");
            System.out.flush();
            lijn = lezer.volgendeLijn();
            if (lijn != null && lijn.startsWith("q")) {
                lijn = null;
            } else if (lijn != null) {
                Stuk stuk = decodeerLijn(lijn);
                if (stuk == null) {
                    System.out.println("Ongeldige invoer.");
                } else if (!bord.geldigePlaatsVoor(stuk)) {
                    System.out.println("Ongeldige plaats.");
                } else {
                    bord.zet(stuk);
                    aantal++;
                }
            }
        }
        System.out.println("Aantal geplaatste stukken = " + aantal);
    }
}