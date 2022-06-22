package concurrentApi.executorService.singleThreadedExecutor;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Single Threaded Executor Run() : Thread Name : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
