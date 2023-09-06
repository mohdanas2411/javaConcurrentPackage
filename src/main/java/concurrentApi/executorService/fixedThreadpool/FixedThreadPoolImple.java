package concurrentApi.executorService.fixedThreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolImple {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println("availableProcessors: " + Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
            service.execute(()->{});
        }

        System.out.println("Main : Thread Name : " + Thread.currentThread().getName());


    }
}

