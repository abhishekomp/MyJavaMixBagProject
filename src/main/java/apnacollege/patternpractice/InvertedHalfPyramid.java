package apnacollege.patternpractice;

import java.util.Scanner;

//        *****
//        ****
//        ***
//        **
//        *
public class InvertedHalfPyramid {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Babu please enter a number");
        int number = scanner.nextInt();

        for(int i = number; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
