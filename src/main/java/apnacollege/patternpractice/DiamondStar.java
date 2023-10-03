package apnacollege.patternpractice;

//https://www.youtube.com/watch?v=Dr4PpNa7AYo&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=6&t=891s
//https://docs.google.com/document/d/1uh_l3ifDCfy9ljDgzK1wjaP2Vpz3sEAA4ADHAtbKfJ0/edit
//33:08
public class DiamondStar {
    public static void main(String[] args) {
        int n = 4;

        //upper half
        for(int i = 1; i <= n; i++) {
            //spaces
            for(int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= ((2*i)-1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //lower half. invert the conditions. copy-paste the code for upper pattern and change just the initial for loop
        for(int i = n; i >= 1; i--) {
            //spaces
            for(int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= ((2*i)-1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
