package be.ugent.objprog.schaakpuzzel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Een lijnenlezer laat toe om afzonderlijke lijnen in te lezen vanaf het
 * toetsenbord. Gebruik per toepassing slechts één object van dit type.
 */
public class Lijnenlezer {

    //
    private final BufferedReader reader;

    /**
     * Maakt een nieuwe lijnenlezer aan. Gebruik per toepassing slechts één
     * object van dit type.
     */
    public Lijnenlezer() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * @return de volgende lijn die door de gebruiker werd ingetikt, of null
     * bij een invoer/uitvoer-fout of bij het einde van de invoer.
     */
    public String volgendeLijn() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            return null;
        }
    }
}