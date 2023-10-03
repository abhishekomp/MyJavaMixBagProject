package corefundamentals.multithreading.concurrency_issues.with_synchronization;

/**
 * Created by sca820 on 03 juni, 2022
 */
public class Worker implements Runnable {

    BankAccount account;
    String workerName;

    public Worker(BankAccount account) {
        this.account = account;
    }

    public Worker(BankAccount account, String workerName) {
        this.account = account;
        this.workerName = workerName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int startBalance = account.getBalance();
            account.deposit(10);
            int endBalance = account.getBalance();
            //System.out.println("StartBalance: " + startBalance + " End Balance: " + endBalance + " " + workerName + " deposit count: " + (i +1));
        }
    }
}
