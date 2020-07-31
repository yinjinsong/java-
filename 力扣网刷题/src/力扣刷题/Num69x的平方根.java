package 力扣刷题;

public class Num69x的平方根 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 1;
        int right = x;
        //在1-x中寻找最后一个i^2小于等于x的数
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (right <= x / right) {
            return right;
        } else {
            return left;
        }
    }
}
