package corefundamentals.filehandlingdemotwo.csvtomodel;

import corefundamentals.filehandlingdemotwo.csvtomodel.model.Customer;
import niodemo.processcsv.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by sca820 on 18 nov., 2022
 */
public class ReadCSVConvertToModel {

    private final Path inputFile;

    public ReadCSVConvertToModel(String inputFile) {
        this.inputFile = Path.of(inputFile);
    }

    public List<Customer> generateModelList() {
        if (!Files.exists(inputFile)) {
            throw new IllegalStateException("File not found: " + inputFile.toAbsolutePath());
        }
        System.out.println("File exists at " + inputFile.toAbsolutePath());
        try(Stream<String> lines = Files.lines(inputFile);) {
//            lines.filter(line -> !line.startsWith("#"))
//                    .flatMap(ReadCSVConvertToModel::lineToModel)
//                    .forEach(System.out::println);
            return lines.filter(line -> !line.startsWith("#"))
                    .flatMap(ReadCSVConvertToModel::lineToModel)
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private static Stream<Customer> lineToModel(String line) {
        final String[] elements = line.split("\\|");
        String firstName = elements[0];
        String lastName = elements[1];
        String fullName = elements[2];
        String emailAddress = elements[3];
        String userName = elements[4];

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setFullName(fullName);
        customer.setEmailAddress(emailAddress);
        customer.setUserName(userName);

        return Stream.of(customer);
    }

}
