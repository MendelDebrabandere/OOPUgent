import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        String urlString = "https://raw.githubusercontent.com/OpenTaal/opentaal-wordlist/master/elements/basiswoorden-gekeurd.txt";

        try {
            URL url = new URL(urlString);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String longestWord = br.lines()
                        .filter(line -> !line.isEmpty()) // Ignore empty lines
                        .max(Comparator.comparingInt(String::length)) // Find the longest word
                        .orElse("No words found");

                System.out.println(longestWord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}