package apnacollege.patternpractice;

import java.util.Scanner;

//        12345
//        1234
//        123
//        12
//        1

public class InvertedHalfPyramidWithNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Babu please enter a number");
        int number = scanner.nextInt();

        for(int i = number; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
