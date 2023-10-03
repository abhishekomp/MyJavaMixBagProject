package corefundamentals.multithreading.createThreadTwo;

public class MyCounting extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyCounting myCounting = new MyCounting();
        System.out.println("Inside Main");
        myCounting.start();
        myCounting.join();
        System.out.println("End of Main");
    }
}
