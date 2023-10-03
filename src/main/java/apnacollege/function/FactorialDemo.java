package apnacollege.function;

//https://www.youtube.com/watch?v=qcSz4ef9UHA&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=7
//20:05
public class FactorialDemo {
    public static void main(String[] args) {

        int n = 6;
        final long fact = fact(n);


        System.out.println("factorial = " + fact);
    }

    private static long fact(int n) {
        long factorial = 1;
        while(n >= 1) {
            factorial = factorial * n;
            n--;
        }
        return factorial;
    }
}
