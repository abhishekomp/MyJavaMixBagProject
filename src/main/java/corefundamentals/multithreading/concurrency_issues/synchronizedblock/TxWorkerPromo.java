package corefundamentals.multithreading.concurrency_issues.synchronizedblock;

/**
 * Created by sca820 on 04 juni, 2022
 */
public class TxWorkerPromo extends TxWorker{
    public static void main(String[] args) {
        TxWorker worker = new TxWorkerPromo(new BankAccount(100), 'd', 500, "Worker");
        worker.run();
    }

    public TxWorkerPromo(BankAccount account, char transactionType, int amount, String workerName) {
        super(account, transactionType, amount, workerName);
    }

    @Override
    public void run() {
        if(transactionType == 'w') {
            synchronized (account) {
                this.account.withdraw(amount);
                System.out.println("After transaction: " + this + " updated account is: " + account);
            }

        } else if (transactionType == 'd') {
            synchronized (account) {
                this.account.deposit(amount);
                if(this.account.getBalance() >= 500) {
                    int amountGreater = this.account.getBalance() - 500;
                    int extraAmountToDeposit = (int) ((amountGreater * 10) / 100);
                    this.account.deposit(extraAmountToDeposit);
                }
                System.out.println("After transaction: " + this + " updated account is: " + account);
            }
        }
    }
}
