public class Question1 {
    /**
     * 实现一个计数器，计数到100，在每个数字之间暂停1秒，每隔10个数字输出一个字符串
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            Thread.sleep(1000);
            if (i % 10 == 9) {
                System.out.println("我是字符串");
            }
        }

    }
}
