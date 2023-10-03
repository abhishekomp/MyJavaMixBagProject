package apnacollege.patternpractice;

import java.util.Scanner;

//            *
//            **
//            ***
//            ****
//            *****

public class NormalHalfRightPyramid {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Babu please enter a number");
        int number = scanner.nextInt();

        for(int i = 1; i <= number; i++) {
            for(int j = 1; j <= number - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
