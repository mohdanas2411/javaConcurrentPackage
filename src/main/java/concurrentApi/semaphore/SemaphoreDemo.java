package concurrentApi.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++)
            service.execute(new Task(semaphore));
    }
}
