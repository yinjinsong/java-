import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyWaitDemo2 {
    public static void main(String[] args) {
        ShareResource2 shareResource2 = new ShareResource2();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource2.print5(i);
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource2.print10(i);
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                shareResource2.print15(i);
            }
        }, "CC").start();
    }
}

class ShareResource2 {
    //1:a,2:b,3:c
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition cd1 = lock.newCondition();
    private Condition cd2 = lock.newCondition();
    private Condition cd3 = lock.newCondition();

    public void print5(int totalLoopNumber) {
        lock.lock();
        try {
            while (number != 1) {
                cd1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber:"+totalLoopNumber);
            }
            number = 2;
            cd2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10(int totalLoopNumber) {
        lock.lock();
        try {
            while (number != 2) {
                cd2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber:"+totalLoopNumber);
            }
            number = 3;
            cd3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15(int totalLoopNumber) {
        lock.lock();
        try {
            while (number != 3) {
                cd3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t totalLoopNumber:"+totalLoopNumber);
            }
            number = 1;
            cd1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}