import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyWaitDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.inc();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.dec();
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource.inc();
            }
        }, "CC").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.dec();
            }
        }, "DD").start();
    }
}

class ShareResource {
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition cd = lock.newCondition();

    public void inc() {
        lock.lock();
        try {
            while (number != 0) {
                cd.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            cd.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void dec() {
        lock.lock();
        try {
            while (number != 1) {
                cd.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
