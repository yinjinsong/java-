import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 方法一：同步代码块
 * synchronized(同步锁){
 * 需要同步操作的代码
 * }
 * 方法二：同步方法
 * public  synchronized void sellTickets()
 *
 * 方法三：Lock锁
 * public void lock() :加同步锁。
 * public void unlock() :释放同步锁。
 * 锁住执行的程序块
 */
public class Tickets implements Runnable{
    //总共票数
    private static int ticketsNum=100;
    Lock lock2 = new ReentrantLock();
    //方法一同步代码块
//    Object lock1 = new Object();
//    @Override
//    public void run() {
//        while (true) {
//            sellTickets();
//        }
//    }
//    public void sellTickets() {
//        synchronized (lock1) {
//            if (ticketsNum > 0) {
//                //执行卖票动作花的时间
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println(Thread.currentThread().getName() + "在售卖第" + ticketsNum-- + "张票");
//            }
//        }
//
//    }
    //方法二，同步方法
//    @Override
////    public void run() {
////        while (true) {
////            sellTickets();
////        }
////    }
////    public synchronized void  sellTickets() {
////
////        if (ticketsNum > 0) {
////            //执行卖票动作花的时间
////            try {
////                Thread.sleep(100);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////
////            System.out.println(Thread.currentThread().getName() + "在售卖第" + ticketsNum-- + "张票");
////        }
////    }

    //方法三，lock锁
    @Override
    public void run() {
        while (true) {
            sellTickets();
        }
    }


    public  void sellTickets() {
        lock2.lock();
        if (ticketsNum > 0) {
            //执行卖票动作花的时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "在售卖第" + ticketsNum-- + "张票");
        }
        lock2.unlock();
    }

}
