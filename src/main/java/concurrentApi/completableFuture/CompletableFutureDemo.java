package concurrentApi.completableFuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo {
    public static void main(String[] args) {


        Tasks tasks = new Tasks();

        for (int i = 0; i < 10; i++)
            CompletableFuture.supplyAsync(tasks::getProduct).thenApply(tasks::enrichProduct).thenApply(tasks::performPayment).thenAccept(tasks::sendProduct);

        // or

        for (int i = 0; i < 5; i++)
            CompletableFuture.supplyAsync(() -> tasks.getProduct()).thenApply(product -> tasks.enrichProduct(product)).thenApply(product -> tasks.performPayment(product)).thenAccept(product -> tasks.sendProduct(product));


        //by default completableFuture use ForkJoinPool but we can pass our own thread pool
        //for that we have to use Async methods
        //eg..
        System.out.println("user choice thread pool");

        ExecutorService IOBasedOperationS = Executors.newCachedThreadPool();
        //number of processors's threads
        ExecutorService CPUBasedOperations = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        //Multiple threads performing tasks asyncly ,  operation order can't predict
        for (int i = 0; i < 30; i++)
            CompletableFuture.supplyAsync(tasks::getProduct, IOBasedOperationS)
                    .thenApplyAsync(tasks::enrichProduct, CPUBasedOperations)
                    .thenApplyAsync(tasks::performPayment, IOBasedOperationS)
                    .thenAcceptAsync(tasks::sendProduct, CPUBasedOperations);


        //for exception handling

        for (int i = 0; i < 30; i++)
            CompletableFuture.supplyAsync(tasks::getProduct, IOBasedOperationS)
                    .thenApplyAsync(tasks::enrichProduct, CPUBasedOperations)
                    .thenApplyAsync(tasks::performPayment, IOBasedOperationS)
                    .exceptionally(exp-> new FailedProduct())
                    .thenAcceptAsync(tasks::sendProduct, CPUBasedOperations);

    }
}
