package corefundamentals.multithreading.pluralsight_trial_two.adder_multithreaded;

public class AdderMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started");

        String[] inFiles = {"file1.txt", "file2.txt"};
        String[] outFiles = {"outFile1.txt", "outFile2.txt"};

        //Demerit of this approach is, if we have a large number of files then the main method will spawn those many threads which could hit the performance of the system
        //Hence a better way is to use a Thread pool where we maintain a fixed number of threads
        Thread[] threads = new Thread[inFiles.length];
        for(int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            //threads[i] = new Thread(adder);
            threads[i] = new Thread(adder, "Thread " + i);  //named thread
            threads[i].start();
        }

        for(Thread thread : threads) {
            try {
                thread.join();  //here main says join which means it will wait for the background thread to complete its work before moving ahead
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
