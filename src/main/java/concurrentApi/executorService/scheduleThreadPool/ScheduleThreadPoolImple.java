package concurrentApi.executorService.scheduleThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolImple {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 100; i++) {
            service.schedule(new Task(),0, TimeUnit.SECONDS);
        }

        System.out.println("Main : Thread Name : " + Thread.currentThread().getName());


    }

}
