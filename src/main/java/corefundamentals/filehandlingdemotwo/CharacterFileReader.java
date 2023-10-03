package corefundamentals.filehandlingdemotwo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by sca820 on 18 nov., 2022
 * <p>
 * This will read an input file (text, character, csv file), to make sure it can interpret everything, then write the content to an output file
 * to see that we can create the same file with our own data. Contents are then compared on a logical and bytewise
 * level.
 * <p>
 */
public class CharacterFileReader {

    private final Path inputFile;

    public CharacterFileReader(String inputFile) {
        this.inputFile = Path.of(inputFile);
    }
    //static final String desktop = new File(System.getenv("HOMEPATH") + "/" + "Desktop").getAbsolutePath();
    public List<String> readLinesFromFile() {
        System.out.println("inputFile variable is: " + inputFile);
        if (!Files.exists(inputFile)) {
            throw new IllegalStateException("File not found: " + inputFile.toAbsolutePath());
        }
        System.out.println("File exists at " + inputFile.toAbsolutePath());
        try(Stream<String> lines = Files.lines(inputFile);) {
//            lines.filter(line -> !line.startsWith("#"))
//                    .forEach(System.out::println);
            return lines.collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void compareFilesOnByteLevel(String fileOne, String fileTwo) throws IOException {
        String desktop = new File(System.getenv("HOMEPATH") + "/" + "Desktop").getAbsolutePath();
        File f1 = new File(desktop + fileOne);
        File f2 = new File(desktop + fileTwo);
        System.out.println("Comparing bytewise content...");
        System.out.println("original size: " + f1.length());
        System.out.println("output size:   " + f2.length());
        long pos = 0;
        try (FileInputStream fis1 = new FileInputStream(f1); FileInputStream fis2 = new FileInputStream(f2)) {
            int byte1;
            while ((byte1 = fis1.read()) != -1) {
                int byte2 = fis2.read();
                System.out.print("\rpos: " + pos + " -> ");
                //assertThat(byte2).isEqualTo(byte1);
                //at this point when byte1 = fis1.read() has become -1 then byte2 should be equal to byte1 if the file has exact same content. but i don't understand this
                pos++;
            }
            System.out.println("Done.");
        }
    }
}
