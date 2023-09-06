package concurrentApi.waitForSimilarThread;

import java.util.concurrent.TimeUnit;


public class Task implements Runnable{
     String lock = null;


    public void run( ){
        System.out.println("enter " + Thread.currentThread().getName() );


        synchronized (this) {
            System.out.println();
            try {
                TimeUnit.MICROSECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("synchro " + Thread.currentThread().getName() );

            notifyAll();
        }

        System.out.println("after " + Thread.currentThread().getName());

        //}
    }

}
