package concurrentApi.waitForSimilarThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaitForSimilarThread {


    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(10);

        ThreadLocal<User> user = new ThreadLocal<>();

        service.execute(() -> {
            System.out.println("inside +");

            synchronized (user){

            }
        });


        ReentrantLock lo = new ReentrantLock();
        Condition condition = lo.newCondition();


    }


}
