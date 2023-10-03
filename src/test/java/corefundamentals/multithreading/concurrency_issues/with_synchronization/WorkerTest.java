package corefundamentals.multithreading.concurrency_issues.with_synchronization;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sca820 on 03 juni, 2022
 */
class WorkerTest {

    ExecutorService es;

    @BeforeEach
    void setUp() {
        es = Executors.newFixedThreadPool(20);
    }

    @AfterEach
    void tearDown() {
        //To do
    }

    @RepeatedTest(10)
    void shouldTestWorkersDepositing10TimesWithSynchronization() throws InterruptedException {
        BankAccount account = new BankAccount(100);
        int numOfWorkers = 5;
        int expectedFinalBalance = 100 + (numOfWorkers * 10 * 10);
        System.out.println("Expected Final Balance: " + expectedFinalBalance);
        for (int i = 1; i <= numOfWorkers; i++) {
            Worker worker = new Worker(account, "Worker " + i);
            es.submit(worker);
        }
        es.shutdown();
        es.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("Actual Final Balance: " + account.getBalance());
        assertThat(account.getBalance()).isEqualTo(expectedFinalBalance);
    }

}