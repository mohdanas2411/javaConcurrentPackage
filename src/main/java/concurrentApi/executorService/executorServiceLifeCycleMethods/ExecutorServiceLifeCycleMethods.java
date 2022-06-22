package concurrentApi.executorService.executorServiceLifeCycleMethods;

import concurrentApi.executorService.fixedThreadpool.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceLifeCycleMethods {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 100; i++)
            service.submit(new Task());

        System.out.println("service.isShutdown() " + service.isShutdown());
        System.out.println("service.shutdown() ");
        service.shutdown();

        System.out.println("service.isTerminated() " + service.isTerminated());


        System.out.println("service.awaitTermination(2, TimeUnit.SECONDS : " + service.awaitTermination(1, TimeUnit.SECONDS));

        //after service.awaitTermination(1, TimeUnit.SECONDS) queue is blocked no new task can be submit
        try {
            service.submit(new Task());
        }catch (Exception ex){
            System.out.println("Queue is blocked : "+"\u001B[31m" + ex+ "\u001B[0m");
        }

        Thread.sleep(4000);

        System.out.println("List of all return tasks from queue");
        //return all pending queued task in a list of runnable
        System.out.println("service.shutdownNow() : " + service.shutdownNow());


    }


}
