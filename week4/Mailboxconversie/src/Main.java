import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        assert args.length == 2;

        // get the correct input stream depending on argument 0
        InputStream in;
        if (args[0].startsWith("http://") || args[0].startsWith("https://")) {
            URL url = new URL(args[0]);
            in = url.openStream();
        } else if (args[0].equals("-")) {
            in = System.in;
        } else {
            in = Main.class.getResourceAsStream(args[0]);
        }

        // get the correct buffered writer depending on argument 1

        BufferedWriter uitvoer;
        if (args[1].equals("-")) {
            uitvoer = new BufferedWriter(new OutputStreamWriter(System.out));
        } else {
            uitvoer = Files.newBufferedWriter(Path.of(args[1]));
        }


        assert in != null;

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = br.readLine();
        while (line != null) {

            if (line.startsWith("From: ")) {
                uitvoer.write("</pre>" + "\n");
                uitvoer.write("<hr>" + "\n");
                uitvoer.write("<strong>From: </strong>" + line.substring(6) + "<br>" + "\n");
            } else if (line.startsWith("Date: ")) {
                uitvoer.write("<strong>Date: </strong>" + line.substring(6) + "<br>" + "\n");
            } else if (line.startsWith("Subject: ")) {
                uitvoer.write("<strong>Subject: </strong>" + line.substring(9) + "<br>" + "\n");
                uitvoer.write("<pre>" + "\n");
            } else {
                uitvoer.write(line + "\n");
            }

            line = br.readLine();
        }

        in.close();


    }

}