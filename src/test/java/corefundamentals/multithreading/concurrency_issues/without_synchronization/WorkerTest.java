package corefundamentals.multithreading.concurrency_issues.without_synchronization;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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
        es = Executors.newFixedThreadPool(3);
    }

//    @AfterEach
//    void tearDown() throws InterruptedException {
//        es.shutdown();
//        es.awaitTermination(20, TimeUnit.SECONDS);
//    }

    //@Test
    @RepeatedTest(10)
    public void shouldTestWorkersDepositing10TimesWithoutSynchronization() throws InterruptedException {

        BankAccount account = new BankAccount(100);
        for (int i = 1; i <= 10; i++) {
            Worker worker = new Worker(account, "Worker " + i);
            es.submit(worker);
        }
        es.shutdown();
        es.awaitTermination(20, TimeUnit.SECONDS);
        System.out.println("Final Balance: " + account.getBalance());
        assertThat(account.getBalance()).isEqualTo(1100);
    }

}