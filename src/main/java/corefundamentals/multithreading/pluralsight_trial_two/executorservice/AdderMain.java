package corefundamentals.multithreading.pluralsight_trial_two.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AdderMain {
    public static void main(String[] args) {
        String[] inFiles = {"file1.txt", "file2.txt"};
        String[] outFiles = {"outFile1.txt", "outFile2.txt"};

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i = 0; i < inFiles.length; i++) {
            Adder adder = new Adder(inFiles[i], outFiles[i]);
            executorService.submit(adder);
        }

        try {
            executorService.shutdown();
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
