package corefundamentals.multithreading.concurrency_issues.synchronizedblock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sca820 on 03 juni, 2022
 */
public class TxClient {

    static BankAccount account = new BankAccount(100);

    public static void main(String[] args) {
        System.out.println("Initial account: " + account);
        executeTransactionsConcurrently();
//        executeTransactionsSequentially();
    }

    private static void executeTransactionsSequentially() {
        final TxWorker[] workers = TxWorkerFactory.createTxWorkersWithNameForAccount(account);
        for(TxWorker worker : workers) {
            worker.run();
        }
        System.out.println("Final Balance: " + account.getBalance());
    }

    private static void executeTransactionsConcurrently() {
        ExecutorService es = Executors.newFixedThreadPool(5);

        final TxWorker[] workers = TxWorkerFactory.createTxWorkersWithNameForAccount(account);
        for(TxWorker worker : workers) {
            es.submit(worker);
        }
        try {
            es.shutdown();
            es.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        printTransactions(workers);
        System.out.println("Final Balance: " + account.getBalance());
    }

// private static void printTransactions(TxWorker[] workers) {
//     for(TxWorker worker : workers) {
//         System.out.println(worker);
//     }
// }
}
