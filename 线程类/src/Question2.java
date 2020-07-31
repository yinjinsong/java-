import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
两个线程，一个线程打印1-52，另一个打印字母A-Z打印顺序为12A34B...5152Z,
要求用线程间通信
 */
public class Question2 {
    public static void main(String[] args) {
        Resource3 resource3 = new Resource3();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                resource3.printNum();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                resource3.printLetter();
            }
        }, "BB").start();
    }
}

class Resource3 {
    private int number = 1;
    private int curCount = 1;
    private Character curCharacter = 'A';
    private Lock lock = new ReentrantLock();
    private Condition cd1 = lock.newCondition();
    private Condition cd2 = lock.newCondition();

    public void printNum() {
        //1.上锁
        //2.判断
        //3干活
        //4.通知
        lock.lock();
        try {
            while (number != 1) {
                cd1.await();
            }
            if (curCount <= 52) {
                for (int i = 0; i < 2; i++) {
                    System.out.print(curCount++);
                }
            }
            number = 2;
            cd2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printLetter() {
        //1.上锁
        //2.判断
        //3干活
        //4.通知
        lock.lock();
        try {
            while (number != 2) {
                cd2.await();
            }
            if (curCharacter <= 'Z') {
                System.out.print(curCharacter++);
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
