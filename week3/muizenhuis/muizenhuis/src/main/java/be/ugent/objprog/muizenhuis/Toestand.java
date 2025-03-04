package be.ugent.objprog.muizenhuis;

import java.util.HashMap;
import java.util.Map;

public enum Toestand {

    BASIS, LINKS_START, LINKS_MIDDEN, LINKS_END, RECHTS_START, RECHTS_MIDDEN, RECHTS_END;

    public Toestand linksAan(Kamers kamers) {
        Map<Toestand, Toestand> volgende = Map.of(
                BASIS, RECHTS_START,
                LINKS_START, LINKS_MIDDEN,
                RECHTS_END, RECHTS_MIDDEN
        );

        if (volgende.containsKey(this)) {
            return volgende.get(this);
        }

        return BASIS;
    }

    public Toestand rechtsAan(Kamers kamers) {
        Map<Toestand, Toestand> volgende = Map.of(
                RECHTS_START, RECHTS_MIDDEN,
                BASIS, LINKS_START,
                LINKS_END, LINKS_MIDDEN
        );

        if (volgende.containsKey(this)) {
            return volgende.get(this);
        }

        return BASIS;
    }

    public Toestand linksUit(Kamers kamers) {
        Map<Toestand, Toestand> volgende = Map.of(
                RECHTS_START, BASIS,
                RECHTS_MIDDEN, RECHTS_END,
                LINKS_MIDDEN, LINKS_START,
                LINKS_END, BASIS
        );

        if (volgende.containsKey(this)) {
            if (this == LINKS_END) {
                kamers.vanRechtsNaarLinks();
            }

            return volgende.get(this);
        }

        return BASIS;
    }

    public Toestand rechtsUit(Kamers kamers) {
        Map<Toestand, Toestand> volgende = Map.of(
                RECHTS_MIDDEN, RECHTS_START,
                RECHTS_END, BASIS,
                LINKS_START, BASIS,
                LINKS_MIDDEN, LINKS_END
        );

        if (volgende.containsKey(this)) {
            if (this == RECHTS_END) {
                kamers.vanLinksNaarRechts();
            }

            return volgende.get(this);
        }

        return BASIS;
    }
}
