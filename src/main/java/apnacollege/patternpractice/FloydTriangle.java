package apnacollege.patternpractice;

import java.util.Scanner;

//        1
//        2 3
//        4 5 6
//        7 8 9 10
//        11 12 13 14 15

public class FloydTriangle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Babu please enter a number");
        int number = scanner.nextInt();

        //floydMyTrial(number);
        floydInVideo(number);
    }

    private static void floydInVideo(int number) {
        int token = 1;
        for(int i = 1; i <= number; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(token + " ");
                token++;
            }
            System.out.println();
        }
    }

    private static void floydMyTrial(int number) {
        int token = 1;
        for(int i = 1; i <= number; i++) {
            for(int j = 1; j <= i; j++) {
                if(i == 1) {
                    System.out.print(token);
                } else {
                    System.out.print(++token + " ");
                }
            }
            System.out.println();
        }
    }
}
