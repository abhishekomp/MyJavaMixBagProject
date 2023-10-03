package corefundamentals.multithreading.createThreadOne;

public class MyCalculations implements Runnable {
    private final long numberToFactor;

    public MyCalculations(long numberToFactor){
        this.numberToFactor = numberToFactor;
    }

    @Override
    public void run() {
        isItPrime();
    }

    private void isItPrime(){
        long squareRoot = (long) Math.sqrt(numberToFactor);
        for (long i = 3; i <= squareRoot ; i++)	{
            if(numberToFactor % i == 0) {
                System.out.println("Number " + numberToFactor + " is first divisible by " + i);
                return;
            }
        }
        System.out.println("Number " + numberToFactor + " is prime");
    }
}
