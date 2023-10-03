package completionstagedemo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

/**
 * Created by sca820 on 02 mars, 2023
 */
public class CompletableFutureWithSupplier {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> Thread.currentThread().getName();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);

        String string = completableFuture.join();   //this is a blocking call
        System.out.println(string);
    }
}
