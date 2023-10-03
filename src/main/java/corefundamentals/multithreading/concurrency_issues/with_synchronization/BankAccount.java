package corefundamentals.multithreading.concurrency_issues.with_synchronization;

/**
 * Created by sca820 on 03 juni, 2022
 */
public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }
}
