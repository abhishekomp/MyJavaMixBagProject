package apnacollege.function;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.stream.Collectors.*;

//Write a program to enter the numbers till the user wants and at the end it should display the count of positive, negative and zeros entered.
public class PrintPositiveNegativeZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String line = sc.nextLine();

        final List<Integer> collect = Arrays.asList(line.split(" ")).stream()
                .map(Integer::parseInt)
                .collect(toList());
        System.out.println("collect = " + collect);

        final long countPositiveInt = Arrays.asList(line.split(" ")).stream()
                .map(Integer::parseInt)
                .filter(e -> e > 0)
                .count();
        System.out.println("countPositiveInt = " + countPositiveInt);

        final long countNegativeInt = Arrays.asList(line.split(" ")).stream()
                .map(Integer::parseInt)
                .filter(e -> e < 0)
                .count();
        System.out.println("countNegativeInt = " + countNegativeInt);

        final long countZeros = Arrays.asList(line.split(" ")).stream()
                .map(Integer::parseInt)
                .filter(e -> e == 0)
                .count();
        System.out.println("countZeros = " + countZeros);


        final Map<Integer, Long> collect1 = Arrays.asList(line.split(" ")).stream()
                .map(Integer::parseInt)
                .collect(groupingBy(Integer::signum, counting()));
        System.out.println("collect1 = " + collect1);

    }
}
