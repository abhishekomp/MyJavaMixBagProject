package apnacollege.patternpractice;

import java.util.Scanner;

//        1
//        12
//        123
//        1234
//        12345

public class HalfPyramidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Babu please enter a number");
        int number = scanner.nextInt();
        for(int i = 1; i <= number; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
