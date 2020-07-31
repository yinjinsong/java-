package JUC.Volatile;

import java.util.concurrent.atomic.AtomicInteger;

public class Volatile原子性测试 {
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
        public void addAtomic() { atomicInteger.getAndIncrement(); }
    }

    public static void main(String[] args) {
        System.out.println("原子性测试");
        MyData myData = new MyData();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 200; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }
        //有两个线程，1.GC线程 2.main线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("addPlusPlus：" + myData.number);
        System.out.println("addAtomic：" + myData.atomicInteger);
    }

}
