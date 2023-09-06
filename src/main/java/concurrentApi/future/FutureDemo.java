package concurrentApi.future;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("LocalDateTime.now() "+Timestamp.valueOf(LocalDateTime.now()));
        System.out.println("LocalDateTime.now().with(LocalDateTime.MIN "+Timestamp.valueOf(LocalDateTime.now().with(LocalDateTime.MIN)));
        System.out.println("LocalDateTime.now().with(LocalTime.MIN "+Timestamp.valueOf(LocalDateTime.now().with(LocalTime.MIN)));
        System.out.println("LocalDateTime.now().with(LocalTime.MIN "+Timestamp.valueOf(LocalDateTime.now().with(LocalTime.MIN)));



        ExecutorService service = Executors.newSingleThreadExecutor();


//        ArrayList<Future> futuresList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Future<Integer> future = service.submit(()->{
//                return new Random().nextInt(10);
//            });
//            futuresList.add(future);
//            System.out.println("future.isDone() : " + future.isDone());
//            try {
//                System.out.println(future.get(1, TimeUnit.MICROSECONDS));
//            } catch (TimeoutException e) {
//
//                System.out.println("Exception Handled : Data is not pushed in future in given time so main thread didnt wait longer for it");
//            }
//
//
//            System.out.println("future.isCancelled() : "+future.isCancelled());
//        }
//
//
        System.out.println("After data is pushed in future");

//        for (int i = 0; i < 10; i++)
//            System.out.println("returned value from callable method : " + futuresList.get(i).get());

        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
            data.add(i);

        AtomicInteger c = new AtomicInteger();
        Future<Integer> count = service.submit(()->{
            System.out.println("outside "+Thread.currentThread().getName());
            data.parallelStream().filter(e->e.intValue()>10&&e.intValue()<1000).map(integer -> {
                System.out.println("inside "+Thread.currentThread().getName());
                return c.getAndIncrement();
            }).collect(Collectors.toList());

            return c.get();
        });

        System.out.println(count.get());
        System.out.println("all counted");
        System.out.println(count.get());

    }
}
