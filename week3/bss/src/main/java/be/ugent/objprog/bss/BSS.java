package be.ugent.objprog.bss;

import java.util.Map;

public enum BSS {

    BLAD, STEEN, SCHAAR;



    public static int gameOutcomeVersus(BSS p1, BSS p2) {
        Map<BSS, BSS> winsAgainst = Map.of(
                BLAD, STEEN,
                STEEN, SCHAAR,
                SCHAAR, BLAD
        );

        if (winsAgainst.get(p1) == p2) {
            return 1;
        }
        else if (winsAgainst.get(p2) == p1) {
            return 2;
        }
        return 0;
    }

}
