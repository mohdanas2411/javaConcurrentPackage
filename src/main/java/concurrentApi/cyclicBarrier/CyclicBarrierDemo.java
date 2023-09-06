package concurrentApi.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 0; i < 10; i++)
            service.submit(new Task(cyclicBarrier));

    }
}

