package corefundamentals.multithreading.concurrency_issues.when_synchronization_fails;

/**
 * Created by sca820 on 03 juni, 2022
 */
public class TxWorker implements Runnable{

    protected final BankAccount account;
    protected char transactionType;
    protected int amount;
    protected String workerName;

    public TxWorker(BankAccount account, char transactionType, int amount) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    //to do: call the above constructor from this constructor
    public TxWorker(BankAccount account, char transactionType, int amount, String workerName) {
        this.account = account;
        this.transactionType = transactionType;
        this.amount = amount;
        this.workerName = workerName;
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
                System.out.println("After transaction: " + this + " updated account is: " + account);
            }
        }
    }

//    @Override
//    public void run() {
//        if(transactionType == 'w') {
//            this.account.withdraw(amount);
//        } else if (transactionType == 'd') {
//            this.account.deposit(amount);
//        }
//        System.out.println("After transaction: " + this + " updated account is: " + account);
//    }

    @Override
    public String toString() {
        return "TxWorker{" +
                "transactionType=" + transactionType +
                ", amount=" + amount +
                ", workerName='" + workerName + '\'' +
                '}';
    }
}
