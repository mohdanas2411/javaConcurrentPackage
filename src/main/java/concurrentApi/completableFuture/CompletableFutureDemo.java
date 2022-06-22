package concurrentApi.completableFuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletablefutureDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        Tasks tasks = new Tasks();

        for (int i = 0; i < 50; i++)
            CompletableFuture.supplyAsync(() -> tasks.getProduct()).thenApply(product -> tasks.enrichProduct(product)).thenApply(product -> tasks.performPayment(product)).thenAccept(product -> tasks.sendProduct(product));

    }
}
