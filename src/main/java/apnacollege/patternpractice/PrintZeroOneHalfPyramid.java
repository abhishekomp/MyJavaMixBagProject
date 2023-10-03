package apnacollege.patternpractice;

import java.util.Scanner;

//        1
//        0 1
//        1 0 1
//        0 1 0 1
//        1 0 1 0 1

//https://www.youtube.com/watch?v=GjHNGM7KN3w&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=6
//https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa3BVVkx0by00Ym9HdGpKYjMzYWZUbFVBVnRRUXxBQ3Jtc0trcTdJMnN4TTRJNHBCOW8yM1VOUzlUZXVxdjQzZ2dyUDluVGlxVzNwSXNLU1JQSUh4eF80MEJlUU93eEd3cWFJRmNfcnVDNm5CVmpoQzJVTXpYRzQ1UGlsT1BqMTdhcll5Wndta0Z2NXhSbzNXYklXOA&q=https%3A%2F%2Fdocs.google.com%2Fdocument%2Fd%2F1OrUsnDqzma9ob467aCdvRlZwkK7mhl552n92vlBXr_U%2Fedit%3Fusp%3Dsharing&v=GjHNGM7KN3w
public class PrintZeroOneHalfPyramid {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Babu please enter a number");
        int number = scanner.nextInt();

        for(int i = 1; i <= number; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print((i + j) % 2 == 0 ? "1 ":"0 ");
            }
            System.out.println();
        }
    }
}
