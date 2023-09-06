package concurrentApi.reentrantLock;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++)
            service.submit(new Task(lock));
            // CompletableFuture.runAsync(new Task(lock)).thenAccept(System.out::println);
    }

}
