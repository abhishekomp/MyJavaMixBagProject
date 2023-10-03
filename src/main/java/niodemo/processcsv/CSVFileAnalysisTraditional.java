package niodemo.processcsv;

import niodemo.processcsv.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class CSVFileAnalysisTraditional {
    public void analyseCSVTraditionally(String csvFilePath) {
        Path path = Path.of(csvFilePath);
        //System.out.println(Files.exists(path));

        Function<String, Person> lineToPerson = line -> lineToPerson(line);

        try (
                BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            while (line != null) {
                if (!line.startsWith("#")) {
                    final Person person = lineToPerson.apply(line);
                    //Person person = lineToPerson(line);
                    if(person != null) {
                        System.out.println("p = " + person);
                    }
                }
                line = reader.readLine();
            }
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static Person lineToPerson(String line) {
        try {
            final String[] elements = line.split(";");
            String name = elements[0];
            int age = Integer.parseInt(elements[1]);
            String city = elements[2];

            Person p = new Person(name, age, city);
            return p;
        } catch(Exception e) {

        }
        return null;
    }
}
