package niodemo.readcsvfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by sca820 on 11 okt., 2022
 */
public class ReadCSVFile {

    public List<String> readLines(String csvFilePath) {
        Path path = Path.of(csvFilePath);
        try(Stream<String> lines = Files.lines(path);) {
            return lines.collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return Collections.EMPTY_LIST;
        //return Collections.<String>emptyList();
        return Collections.emptyList();
    }

}
