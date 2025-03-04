package fractions;

public class Main {

    public static void main(String[] args) {
        Expression expr = new Parser().parse(args[0]);

        // System.out.println(expr); // deze lijn vervangen door onderstaande!


        expr.computeWidth();
        expr.computeHeightAndDepth();
        expr.computeCoordinates();

        for (int rij = 0; rij < expr.getTotalHeight(); rij++) {
            for (int kolom = 0; kolom < expr.getWidth(); kolom++) {
                System.out.print(expr.charAt(rij,kolom));
            }
            System.out.println();
        }


    }
}
