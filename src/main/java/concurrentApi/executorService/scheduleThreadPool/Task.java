package concurrentApi.executorService.scheduleThreadPool;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Schedule Thread Pool Run() : Thread Name : " + Thread.currentThread().getName());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
