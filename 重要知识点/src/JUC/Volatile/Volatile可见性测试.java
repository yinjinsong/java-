package JUC.Volatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Volatile可见性测试 {
    //线程操纵资源类
    static class MyData {
        //普通变量
        volatile int number = 0;
        //原子包装类
        AtomicInteger atomicInteger = new AtomicInteger();
        public void setTo60() {
            this.number = 60;
        }
        public void addPlusPlus() {
            this.number++;
        }
        public void addAtomic() {
            atomicInteger.getAndIncrement();
        }
    }

    public static void main(String[] args) {
        System.out.println("可见性测试");
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.setTo60();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t更新后的值是：" + myData.number);
        }, "t1").start();
        int i = 0;
        while (myData.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\t main线程获得的number值" + myData.number);
    }
}
