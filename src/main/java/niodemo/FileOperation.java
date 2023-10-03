package niodemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOperation {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("files/Newfile.txt");

        //Create a newFile
        Files.createFile(path);

        //Delete a File
        //Files.delete(path);
        //System.out.println("Delete = " + Files.deleteIfExists(path));


        //Move a file
//        Path toPath = Path.of("downloads/" + path.getFileName());
//        final Path move = Files.move(path, toPath);
//        System.out.println("move = " + move.toString());
    }
}
