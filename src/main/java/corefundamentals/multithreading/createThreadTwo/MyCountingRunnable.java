package corefundamentals.multithreading.createThreadTwo;

public class MyCountingRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyCountingRunnable myCountingRunnable = new MyCountingRunnable();
        Thread t1 = new Thread(myCountingRunnable);
        t1.start();
        t1.join();
        System.out.println("End of Main");
    }
}
