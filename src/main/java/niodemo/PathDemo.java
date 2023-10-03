package niodemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("c:/MyJava/ReadFile.txt");
        Path path2 = Paths.get("c:", "MyJava", "ReadFile.txt");

        System.out.println("Exists path1 = " + Files.exists(path1));
        System.out.println("Exists path2 = " + Files.exists(path2));

        System.out.println("Path2 writable = " + Files.isWritable(path2));

        BufferedReader reader = Files.newBufferedReader(path1);
        String line = reader.readLine();
        while(line != null) {
            System.out.println("line = " + line);
            line = reader.readLine();
        }
    }
}
