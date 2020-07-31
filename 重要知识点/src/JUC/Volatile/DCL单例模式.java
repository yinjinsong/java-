package JUC.Volatile;

public class DCL单例模式 {
    static class SingleTon {
        private static volatile SingleTon instance = null;
        private SingleTon() {
            System.out.println(Thread.currentThread().getName()+"\t 我是构造方法");
        }
        public static SingleTon getInstance() {
            if (instance == null) {
                synchronized (SingleTon.class) {
                    if (instance == null) {
                        instance = new SingleTon();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
        	new Thread(SingleTon::getInstance, String.valueOf(i+1)).start();
        }
    }
}
