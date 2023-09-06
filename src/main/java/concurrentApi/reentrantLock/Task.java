package concurrentApi.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task implements Runnable {
    ReentrantLock lock;

    public Task(ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.tryLock();
        System.out.println("lock get by " + Thread.currentThread().getName());
        System.out.println("thread name : " + Thread.currentThread().getName());

        System.out.println("isHeldByCurrentThread() : " + lock.isHeldByCurrentThread());
        System.out.println("isLocked() : " + lock.isLocked());
        System.out.println("getQueueLength() : " + lock.getQueueLength());
        System.out.println("getWaitQueueLength() : " + lock.getWaitQueueLength(lock.newCondition()));
        System.out.println("getWaitQueueLength() : " + lock.getHoldCount());

        reentrantSection();
        lock.unlock();

        System.out.println();
    }


    public void reentrantSection() {
        lock.tryLock();
        System.out.println("in reentrant section");
        if (lock.getHoldCount() < 2)
            reentrantSection(); //loct acquire 2 times


        System.out.println(lock.getHoldCount());
        lock.unlock();
        lock.unlock();

        System.out.println();
    }
}
