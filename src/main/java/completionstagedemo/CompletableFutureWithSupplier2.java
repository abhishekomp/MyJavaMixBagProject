package completionstagedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * Created by sca820 on 02 mars, 2023
 */
public class CompletableFutureWithSupplier2 {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Supplier<String> supplier = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return Thread.currentThread().getName();
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier, executor);

        String string = completableFuture.join();   //this is a blocking call
        System.out.println(string);
        executor.shutdown();
    }
}
