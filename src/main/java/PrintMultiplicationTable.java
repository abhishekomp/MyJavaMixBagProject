import java.util.Scanner;

public class PrintMultiplicationTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Babu please enter a number");
        int number = scanner.nextInt();

        System.out.println("Multiplication Table for " + number + " is:");
        for(int i = 1; i <= 10; i++) {
            System.out.println(number * i);
        }
    }
}
