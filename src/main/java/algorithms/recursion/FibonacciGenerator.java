package algorithms.recursion;

/**
 * Created by sca820 on 15 dec., 2022
 */
public class FibonacciGenerator {
    public static void main(String[] args) {
        int n = 6;
        int nthFibonacciNum = fibonacci(n);
        System.out.println("nthFibonacciNum = " + nthFibonacciNum);
    }

    private static int fibonacci(int n) {
//        if(n == 1) {
//            return 0;
//        } else if(n == 2) {
//            return 1;
//        }
        if(n < 2) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}

