package apnacollege.function;

/*
Pseudo Code of the Algorithm-
Step 1:  Let  a, b  be the two numbers
Step 2:  a mod b = R
Step 3:  Let  a = b  and  b = R
Step 4:  Repeat Steps 2 and 3 until  a mod b  is greater than 0
Step 5:  GCD = b
Step 6: Finish
 */
//https://www.freecodecamp.org/news/euclidian-gcd-algorithm-greatest-common-divisor/
public class GCDOfTwoNumbers {
    public static void main(String[] args) {
        int a = 1000;
        int b = 56;

        int mod = gcd(a, b);
        System.out.println("mod = " + mod);
    }

    static int gcd(int a, int b)
    {
        if(b == 0)
        {
            return a;
        }
        return gcd(b, a % b);
    }
}
