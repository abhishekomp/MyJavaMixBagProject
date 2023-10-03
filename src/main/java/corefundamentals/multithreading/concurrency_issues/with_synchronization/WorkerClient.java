package corefundamentals.multithreading.concurrency_issues.with_synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sca820 on 03 juni, 2022
 */
public class WorkerClient {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            Worker worker = new Worker(account, "Worker " + i);
            es.submit(worker);
        }

        try {
            es.shutdown();
            es.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final balance: " + account.getBalance());
    }
}
