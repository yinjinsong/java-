package JVM.OOM;

public class StackOverflowErrorDemo {
    private static int i = 0;
    public static void main(String[] args) {
        stackOverflowError();
    }
    private static void stackOverflowError() {
        System.out.println(i++);
        stackOverflowError();
    }
}
