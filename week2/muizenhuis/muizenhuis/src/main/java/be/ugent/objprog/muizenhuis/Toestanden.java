package be.ugent.objprog.muizenhuis;

/**
 * Alle mogelijke toestanden
 */
public class Toestanden {

    /**
     * Gemeenschappelijke bovenklasse van de verschillende toestanden. Doet niets bij elke sensorverandering
     */
    private static class AbstractToestand implements Toestand {
        @Override
        public Toestand linksAan(Kamers kamers) {
            return this;
        }
        @Override
        public Toestand linksUit(Kamers kamers) {
            return this;
        }
        @Override
        public Toestand rechtsAan(Kamers kamers) {
            return this;
        }
        @Override
        public Toestand rechtsUit(Kamers kamers) {
            return this;
        }
    }

    public static class Basis extends AbstractToestand {
        @Override
        public Toestand linksAan(Kamers kamers) {
            return new Pos1();
        }
        @Override
        public Toestand rechtsAan(Kamers kamers) {
            return new Pos4();
        }
    }

    private static class Pos1 extends AbstractToestand {
        @Override
        public Toestand linksUit(Kamers kamers) {
            return new Basis();
        }
        @Override
        public Toestand rechtsAan(Kamers kamers) {
            return new Pos2();
        }
    }

    private static class Pos2 extends AbstractToestand {
        @Override
        public Toestand linksUit(Kamers kamers) {
            return new Pos3();
        }
        @Override
        public Toestand rechtsUit(Kamers kamers) {
            return new Pos1();
        }
    }

    private static class Pos3 extends AbstractToestand {
        @Override
        public Toestand linksAan(Kamers kamers) {
            return new Pos2();
        }
        @Override
        public Toestand rechtsUit(Kamers kamers) {
            kamers.vanLinksNaarRechts();
            return new Basis();
        }
    }

    private static class Pos4 extends AbstractToestand {
        @Override
        public Toestand linksAan(Kamers kamers) {
            return new Pos5();
        }
        @Override
        public Toestand rechtsUit(Kamers kamers) {
            return new Basis();
        }
    }

    private static class Pos5 extends AbstractToestand {
        @Override
        public Toestand linksUit(Kamers kamers) {
            return new Pos4();
        }
        @Override
        public Toestand rechtsUit(Kamers kamers) {
            return new Pos6();
        }
    }

    private static class Pos6 extends AbstractToestand {
        @Override
        public Toestand linksUit(Kamers kamers) {
            kamers.vanRechtsNaarLinks();
            return new Basis();
        }
        @Override
        public Toestand rechtsAan(Kamers kamers) {
            return new Pos5();
        }
    }

}
