package JUC.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019));
        System.out.println("当前值：" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 100));
        System.out.println("当前值：" + atomicInteger.get());
    }
}
