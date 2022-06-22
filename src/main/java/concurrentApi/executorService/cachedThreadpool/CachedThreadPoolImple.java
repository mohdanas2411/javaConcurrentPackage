package concurrentApi.executorService.cachedThreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolImple {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }

        System.out.println("Main : Thread Name : " + Thread.currentThread().getName());


    }
}

