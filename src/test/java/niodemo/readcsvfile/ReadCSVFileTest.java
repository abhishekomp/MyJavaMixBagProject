package niodemo.readcsvfile;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sca820 on 11 okt., 2022
 */
class ReadCSVFileTest {

    ReadCSVFile csvFileReader = new ReadCSVFile();

    @Test
    void read172PNRLines() {
        List<String> lines = csvFileReader.readLines("files/pnr172List.csv");
        lines.forEach(System.out::println);
        System.out.println("lines.size() = " + lines.size());
    }

    @Test
    void read28PNRLines() {
        List<String> lines = csvFileReader.readLines("files/pnr28List.csv");
        lines.forEach(System.out::println);
        System.out.println("lines.size() = " + lines.size());
    }

    @Test
    void remove28From172AndReturnNewList() {
        List<String> lines172 = csvFileReader.readLines("files/pnr172List.csv");
        List<String> lines28 = csvFileReader.readLines("files/pnr28List.csv");
        final List<String> collect = lines172.stream().filter(pnr -> !lines28.contains(pnr)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    void remove28From172AndReturnNewListVersion2() {
        List<String> lines172 = csvFileReader.readLines("files/pnr172List.csv");
        List<String> lines28 = csvFileReader.readLines("files/pnr28List.csv");
        final List<String> collect = lines172.stream().filter(pnr -> !lines28.contains(pnr)).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}