package concurrentApi.executorService.fixedThreadpool;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Fixed Thread Pool Run() : Thread Name : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
