package apnacollege.function;

//We need to find the value of n raised to m. For example 2 raised to 5 = 32
public class NumberRaisedToPower {
    public static void main(String[] args) {
        int base = 2;
        int pow = 5;

        final double pow1 = Math.pow(base, pow);
        System.out.println("pow1 = " + pow1);
    }
}
