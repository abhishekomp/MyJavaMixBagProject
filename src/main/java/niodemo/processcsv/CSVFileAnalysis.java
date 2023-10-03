package niodemo.processcsv;

import niodemo.processcsv.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Stream;

public class CSVFileAnalysis {
    public void analyseCSVUsingStream(String csvFilePath) {

        Path path = Path.of(csvFilePath);
        //System.out.println(Files.exists(path));

        Function<String, Stream<Person>> lineToPerson = line -> lineToPerson(line);

        //try(BufferedReader reader = Files.newBufferedReader(path)) {
        try(Stream<String> lines = Files.lines(path);) {

            //final Stream<String> lines = Files.lines(path);
            //final Stream<String> lines = reader.lines();  //not needed
            lines.filter(line -> !line.startsWith("#"))
                    .flatMap(CSVFileAnalysis::lineToPerson)
                    .forEach(System.out::println);

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static Stream<Person> lineToPerson(String line) {
        try {
            final String[] elements = line.split(";");
            String name = elements[0];
            int age = Integer.parseInt(elements[1]);
            String city = elements[2];

            Person p = new Person(name, age, city);
            return Stream.of(p);
        } catch(Exception e) {

        }
        return Stream.empty();
    }
}
