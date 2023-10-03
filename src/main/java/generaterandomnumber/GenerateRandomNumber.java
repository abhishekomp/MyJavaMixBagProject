package generaterandomnumber;

import java.util.Random;

public class GenerateRandomNumber {
    public static void main(String[] args) {
        int low = 10;
        int high = 20;

        final int i = new Random().nextInt(high - low) + low;
        //System.out.println("i = " + i);

        System.out.println("Random number " + i);
    }
}
