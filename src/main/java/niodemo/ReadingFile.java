package niodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingFile {
    public static void main(String[] args) {
        Path path = Path.of("files/MyStory.txt");
        //System.out.println(Files.exists(path));

        //BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);

        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            while(line != null) {
                System.out.println("line = " + line);
                line = reader.readLine();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
