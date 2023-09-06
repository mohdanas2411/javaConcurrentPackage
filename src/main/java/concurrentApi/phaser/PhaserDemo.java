package concurrentApi.phaser;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(11);

        Phaser phaser = new Phaser(5);

        //extra parties can be add through method, post construction
        phaser.bulkRegister(2);


        for (int i = 0; i < 7; i++)
            service.submit(new Task(phaser));


        System.out.println("Before phaser.arriveAndAwaitAdvance() : ");

        //parties can arive and wait for other parties
        phaser.arriveAndAwaitAdvance();


        //this line will print after all threads complete there work
        System.out.println("After phaser.arriveAndAwaitAdvance() :");

    }
}
