package niodemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FindFile {
    public static void main(String[] args) throws IOException {
        //Path path = Path.of("C:\\dmp");   //works
        Path path = Path.of("C:", "dmp");   //works
        System.out.println("Path exists = " + Files.exists(path));

        String fileName = "read.txt";

        //https://mkyong.com/java/java-files-find-examples/
        final Stream<Path> stream = Files.find(path, Integer.MAX_VALUE,
                (p, basicFileAttributes) -> p.getFileName().toString().equalsIgnoreCase(fileName));
        stream.forEach(System.out::println);
//        stream.map(p -> p.getParent())
//                .forEach(System.out::println);

//        stream.map(p -> p.getRoot())
//                .forEach(System.out::println);
    }
}
