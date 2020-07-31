package 剑指offer;

public class Num44数字序列中某一位的数字 {

    public int findNthDigit(int n) {
        long i = 1, s = 9, base = 1;
        //找到是几位数
        while (n > i * s) {
            n -= i * s;
            i++;
            s *= 10;
            base *= 10;
        }
        //找到几位数中的第几个
        long number = base + (n + i - 1) / i - 1;
        //找到number中的第几位
        long r = n % i == 0 ? i : n % i;
        for (int j = 0; j < i - r; j++) number /= 10;
        return (int)number % 10;
    }
}
