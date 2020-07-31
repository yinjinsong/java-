import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{for(int i=1;i<=40;i++)ticket.sale2();},"AA").start();
        new Thread(()->{for(int i=1;i<=40;i++)ticket.sale2();},"BB").start();
        new Thread(()->{for(int i=1;i<=40;i++)ticket.sale2();},"CC").start();
    }
}

class Ticket {
    private int number = 40;
    private Lock lock = new ReentrantLock();

    //采用sychronized加锁
    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() +
                    "\t" + "卖出了" + number-- + "张票" + "还剩" + number + "张票");
        }
    }

    //采用juc中的lock
    public void sale2() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() +
                        "\t" + "卖出了" + number-- + "张票" + "还剩" + number + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
