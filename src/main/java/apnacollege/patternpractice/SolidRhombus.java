package apnacollege.patternpractice;

//Output
/*
    *****
   *****
  *****
 *****
*****
*/
//Solve hollow rhombus
//https://docs.google.com/document/d/1uh_l3ifDCfy9ljDgzK1wjaP2Vpz3sEAA4ADHAtbKfJ0/edit
public class SolidRhombus {
    public static void main(String[] args) {

        int numOfStars = 5;
        for(int i = 1; i <= numOfStars; i++) {
            for(int j = 1; j <= numOfStars - i; j++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= numOfStars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //System.out.println("\n");
    }
}
