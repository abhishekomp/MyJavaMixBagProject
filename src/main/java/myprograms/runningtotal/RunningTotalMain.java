package myprograms.runningtotal;

import myprograms.runningtotal.util.MathHelper;

import java.util.Scanner;

/**
 * Created by sca820 on 28 juni, 2022
 * Parsing a string as a number: https://stackoverflow.com/questions/33018208/how-do-i-parse-any-number-type-from-a-string-in-java
 */
public class RunningTotalMain {
    public static void main(String[] args) {
        MathHelper mathHelper = new MathHelper();
        try {
            while (true) {
                System.out.print("Enter a number: ");
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                //Number number = NumberFormat.getInstance().parse(line);
                int number = Integer.parseInt(line);
                final int addNumber = mathHelper.doMath(number);
                String message = String.format("You entered: %d, current total = %d", addNumber, mathHelper.getTotal());
                System.out.println(message);
            }
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Total count of numbers " + MathHelper.count);
            System.out.println("Final sum: " + mathHelper.getTotal());
            System.out.println("All done");
        }
    }
}
