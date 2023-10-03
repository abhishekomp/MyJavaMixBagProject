package readtextfile;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by sca820 on 29 sep., 2022
 */
class ReadTextFileTest {

    ReadTextFile reader = new ReadTextFile();

    @Test
    void extractURLsSeparatedByPipe() {
        ReadTextFile reader = new ReadTextFile("allURLs.txt");
        List<String> urlList = reader.extractURLsSeparatedByPipe();
        urlList.forEach(System.out::println);
    }

    @Test
    void readTextFileFromResources() {
        List<String> strings = reader.readTextFileFromResources("InputSSN.txt");
        strings.forEach(System.out::println);
    }
}