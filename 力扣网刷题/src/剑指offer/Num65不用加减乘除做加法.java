package 剑指offer;

public class Num65不用加减乘除做加法 {
    public static void main(String[] args) {
        System.out.println(add(1, 3));
    }
    public static int add(int a, int b) {
        while (b != 0) {
            //进位位
            int c = (a & b) << 1;
            //无进位求和
            a ^= b;
            b = c;
        }
        return a;
    }
}
