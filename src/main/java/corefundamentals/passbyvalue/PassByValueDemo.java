package corefundamentals.passbyvalue;

public class PassByValueDemo {

    //private final int x = 10;
    public void printsX(){

        int x = 1;
        System.out.println("in printsX method (before invoking incrementX method) = " + x);
        getXAndIncrement(x);
        System.out.println("in printsX method (after invoking incrementX method) = " + x);
    }
    public void getXAndIncrement(int x) {
        x++;
        System.out.println("x after increment (inside the getXAndIncrement method) = " + x);
    }

    public static void main(String[] args) {
        PassByValueDemo passByValueDemo = new PassByValueDemo();
        passByValueDemo.printsX();
    }
}
