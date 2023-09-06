package concurrentApi.phaser;

import java.util.concurrent.Phaser;

public class Task implements Runnable {
    Phaser phaser;

    public Task(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println("Current Thread  :" + Thread.currentThread().getName());

      //  phaser.arrive();
        System.out.println("Beforr phaser.arrive()");


        //this line will print after number of threads set in parties reach here , in this case parties are = 3
        System.out.println("After phaser.arrive()");
        System.out.println();

        phaser.arriveAndDeregister();
    }
}
