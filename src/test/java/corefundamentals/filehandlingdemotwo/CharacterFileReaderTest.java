package corefundamentals.filehandlingdemotwo;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sca820 on 18 nov., 2022
 */
class CharacterFileReaderTest {

    static final String desktop = new File(System.getenv("HOMEPATH") + "/" + "Desktop").getAbsolutePath();

    @Test
    void readLinesFromFile_File_on_computer_fileSystem() {
        CharacterFileReader reader = new CharacterFileReader(desktop + "/FakeNames1.CSV");
        List<String> lines = reader.readLinesFromFile();
        lines.forEach(System.out::println);
    }

    @Test
    void readLinesFromFile_File_in_ProjectDirectory() {
        //CharacterFileReader reader = new CharacterFileReader("files/FakeNames.CSV");
        CharacterFileReader reader = new CharacterFileReader("files/MyStory.txt");
        List<String> lines = reader.readLinesFromFile();
        lines.forEach(System.out::println);
    }
}