package concurrentApi.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {
    CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Current Thread  :" + Thread.currentThread().getName());

        System.out.println("Beforr Cyclic Barrier await()");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        //this line will print after number of threads set in parties reach here , in this case parties are = 3
        System.out.println("After Cyclic Barrier await()");
        System.out.println();

    }
}
