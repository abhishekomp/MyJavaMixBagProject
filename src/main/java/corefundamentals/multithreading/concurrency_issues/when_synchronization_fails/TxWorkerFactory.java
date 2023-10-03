package corefundamentals.multithreading.concurrency_issues.when_synchronization_fails;

/**
 * Created by sca820 on 03 juni, 2022
 */
public class TxWorkerFactory {
    public static TxWorker[] createTxWorkers() {
        BankAccount account = new BankAccount(100);
        return createTxWorkersForAccount(account);
    }

    public static TxWorker[] createTxWorkersForAccount(BankAccount account) {
        return new TxWorker[]{
                new TxWorker(account, 'd', 200),
                new TxWorker(account, 'w', 100),
                new TxWorker(account, 'd', 200)
        };
    }

    public static TxWorker[] createTxWorkersWithNameForAccount(BankAccount account) {
        return new TxWorker[]{
                new TxWorker(account, 'd', 300, "worker 1"),
                new TxWorker(account, 'w', 100, "worker 2"),
                new TxWorker(account, 'd', 200, "worker 3")
        };
    }
}
