package concurrentApi.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 10; i++)
            service.submit(new Task(countDownLatch));

        System.out.println("Before countDownLatch.await() : ");

        //await barrier
        countDownLatch.await();


        //this line will print after all threads complete there work
        System.out.println("After countDownLatch.await() :");


    }
}

