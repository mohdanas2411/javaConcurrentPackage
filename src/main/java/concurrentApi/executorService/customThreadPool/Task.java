package concurrentApi.executorService.customThreadPool;

import java.util.concurrent.Callable;

public class Task implements Callable<String > {

    @Override
    public String call() throws Exception {

        System.out.println("In task method call");
        return "call method call";
    }
}
