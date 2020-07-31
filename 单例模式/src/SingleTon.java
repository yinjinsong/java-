public class SingleTon {
    public static void main(String[] args) {
        new Thread(() -> {
            SingleTon4 instance = SingleTon4.getInstance();
            System.out.println(instance);
        }).start();
        new Thread(() -> {
            SingleTon4 instance = SingleTon4.getInstance();
            System.out.println(instance);
        }).start();

    }
}

class SingleTon1 {
    //饿汉式，启动加载
    private SingleTon1() { }

    private static final SingleTon1 single1 = new SingleTon1();

    public static SingleTon1 getInstance() {
        return single1;
    }
}
//懒汉式延迟加载
class SingleTon2 {
    //1.构造方法私有化
    private SingleTon2() { }

    //2.声明单例对象
    private static SingleTon2 single2 = null;

    //3.获取单例对象
    public static synchronized SingleTon2 getInstance() {
        if (single2 == null) {
            //只创建一次
            single2 = new SingleTon2();
        }
        return single2;
    }
}

//双重加锁机制DCL
class SingleTon3 {
    //1.构造方法私有化
    private SingleTon3() { }

    //2.声明单例对象
    private volatile static SingleTon3 single3 = null;

    //3.获取单例对象
    public static SingleTon3 getInstance() {
        if (single3 == null) {
            synchronized (SingleTon3.class) {
                if (single3 == null) {
                    single3 = new SingleTon3();
                }
            }
        }
        return single3;
    }
}
//静态内部类懒汉式
class SingleTon4 {
    //1.构造方法私有化
    private SingleTon4() { }

    // 使用内部类的方式来实现懒加载
    //初始化静态变量时java已经保证了线程安全性
    private static class LazyHolder {
        private static final SingleTon4 INSTANCE = new SingleTon4();
    }

    // 获取对象
    public static SingleTon4 getInstance() {
        return LazyHolder.INSTANCE;
    }

}




