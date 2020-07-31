public class ThreadDemo {
    /*
        多线程的创建有四种方式
        1.通过自定义类继承java.lang.Thread类,并重写Thread类中的run方法
          通过实例对象调用start方法开启线程，并自动执行run方法
        2.通过自定义类实现Runnable接口,并重写run方法
          创建自定义类的对象作为参数传给新建的java.lang.Thread的对象
          然后调用start方法开启线程
        3.通过匿名内部类的方式创建线程,在Thread的实例中传入Runnable的匿名内部类
          并重写run方法。
        4.通过线程池创建对象（推荐）
     */
    public static void main(String[] args) {
        //test1();
        test4();
    }

    /**
     * 线程的创建方法
     */
    public static void test1() {
        new MyThread().start();
        new Thread(new MyRunnable()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "通过匿名内部类Runnable对象创建的线程被执行了");
            }
        }).start();
    }

    /**
     * 线程之间不共享数据的情况
     */
    public static void  test2() {
        new MyThread("线程一").start();
        new MyThread("线程二").start();
        new MyThread("线程三").start();

    }

    /**
     * 线程之间共享数据的情况，同一个实例对象下的成员变量
     */
    public static void test3() {
        MyThread myThread = new MyThread();
        new Thread(myThread,"线程1").start();
        new Thread(myThread,"线程2").start();
        new Thread(myThread,"线程3").start();
        new Thread(myThread,"线程4").start();
    }

    /**
     * 通过runnable实现线程之间共享数据
     */
    public static void test4() {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable,"线程1").start();
        new Thread(myRunnable,"线程2").start();
        new Thread(myRunnable,"线程3").start();
        new Thread(myRunnable,"线程4").start();
    }


}

class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public MyThread() {
    }

    private int count = 100;
    @Override
    public void run() {
        while (count > 0) {
            System.out.println(MyThread.currentThread().getName() + "执行了，count--:" + count--);

        }

    }
}

class MyRunnable implements Runnable {
    private int count = 100;
    @Override
    public void run() {
        while (count > 0) {
            System.out.println(MyThread.currentThread().getName() + "执行了，count--:" + count--);

        }
    }
}