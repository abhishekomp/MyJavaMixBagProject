package niodemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingFile {
    public static void main(String[] args) {

        Path path = Path.of("files/debug.log");

        try (BufferedWriter writer = Files.newBufferedWriter(path);
             BufferedWriter writer2 = new BufferedWriter(writer);
             PrintWriter pw = new PrintWriter(writer2);
        ) {

            writer.write("Hello");

            pw.printf("\ni = %d\n", 120);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
