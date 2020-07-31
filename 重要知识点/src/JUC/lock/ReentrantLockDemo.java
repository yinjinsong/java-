package JUC.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        syncTest(phone);
        System.out.println();
        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();
    }

    public static void syncTest(Phone phone) {
        new Thread(phone::sendSMS,"t1").start();
        new Thread(phone::sendEmail, "t2").start();
    }
}

class Phone implements Runnable {
    public synchronized  void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "\t" + "sendSMS()");
    }
    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t" + "sendEmail()");
    }
    Lock lock = new ReentrantLock();
    public void get() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getId() + "\t" + "get()");
            set();
        } finally {
            lock.unlock();
        }
    }

    private void set() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getId() + "\t" + "set()");
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void run() {
        get();
    }
}