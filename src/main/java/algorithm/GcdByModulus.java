package algorithm;

public class GcdByModulus {
    public static void main(String[] args) {
        int a = 36;
        int b = 8;

        int gcd = gcdByModulus(a, b);
        System.out.println("gcd = " + gcd);
    }

    private static int gcdByModulus(int a, int b) {
        if(b == 0)
            return a;
        else
            return gcdByModulus(b, a%b);
    }
}
