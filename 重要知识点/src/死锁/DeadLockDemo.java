package 死锁;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    //两个锁对象
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized (obj1) {
                    System.out.println(Thread.currentThread().getName() + "获得obj1锁");
                    try {
                        //睡3秒让另一个线程先获得obj2锁
                        TimeUnit.SECONDS.sleep(3);
                        //此时另一个线程已经持有obj2锁，这里请求获取obj2锁就会发生死锁
                        synchronized (obj2) {
                            System.out.println(Thread.currentThread().getName() + "获得obj2锁");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (obj2) {
                    System.out.println(Thread.currentThread().getName() + "获得obj2锁");
                    try {
                        //睡3秒让另一个线程先获得obj1锁
                        TimeUnit.SECONDS.sleep(3);
                        synchronized (obj1) {
                            System.out.println(Thread.currentThread().getName() + "获得obj1锁");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

