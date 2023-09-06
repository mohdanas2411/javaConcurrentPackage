package concurrentApi.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Current Thread  :" + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}
