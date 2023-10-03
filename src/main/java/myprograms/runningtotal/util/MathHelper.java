package myprograms.runningtotal.util;

/**
 * Created by sca820 on 28 juni, 2022
 */
public class MathHelper {
    private int total;
    public static int count;

    public int getTotal() {
        return total;
    }

    public int doMath(int number) {
        total += number;
        count++;
        return number;
    }
}
