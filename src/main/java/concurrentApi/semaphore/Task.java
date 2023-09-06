package concurrentApi.semaphore;

import java.util.concurrent.Semaphore;

public class Task implements Runnable {
    Semaphore semaphore;

    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        //general area any number of threads can access this area
        System.out.println("inside run method "+Thread.currentThread().getName());

        // only number of permits threads can access this area at ones
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Inside Restricted area");

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println();



        //super restricted area only 2 permits require for this area outer permit and inner permit
        try {
            semaphore.acquire(1);
           // Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("super restricted area only 1 thread can access this at ones "+Thread.currentThread().getName());
        semaphore.release(1);


        semaphore.release();
    }
}
