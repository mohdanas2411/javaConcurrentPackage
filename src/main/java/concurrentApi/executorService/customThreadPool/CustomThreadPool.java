package concurrentApi.executorService.customThreadPool;

import java.util.concurrent.*;

public class CustomThreadPool {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = new ThreadPoolExecutor(10, 100, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(90));

        for (int i = 0; i < 30; i++)
            service.submit(new Task());


        //overLoaded constructor
        System.out.println("OverLoaded constructor");

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 110, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new CustomRejectionHandler());
        threadPoolExecutor.allowsCoreThreadTimeOut();


        for (int i = 0; i < 100; i++)
            threadPoolExecutor.submit(new Task());


        threadPoolExecutor.awaitTermination(1, TimeUnit.MICROSECONDS);

        threadPoolExecutor.submit(new Task());
        threadPoolExecutor.submit(new Task());
    }
}
