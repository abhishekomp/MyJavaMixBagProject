package corefundamentals.multithreading.concurrency_issues.without_synchronization;

/**
 * Created by sca820 on 03 juni, 2022
 */
public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
