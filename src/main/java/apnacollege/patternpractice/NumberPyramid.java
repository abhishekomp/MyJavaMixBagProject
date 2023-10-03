package apnacollege.patternpractice;

/*
        1
       2 2
      3 3 3
     4 4 4 4
    5 5 5 5 5
   6 6 6 6 6 6
  7 7 7 7 7 7 7
 8 8 8 8 8 8 8 8
9 9 9 9 9 9 9 9 9
 */

//What if we want to print *    //Done
//https://www.youtube.com/watch?v=Dr4PpNa7AYo&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=6&t=891s
public class NumberPyramid {
    public static void main(String[] args) {
        int n = 9;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++) {
                //System.out.print(i + " ");
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
