package 二分法;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt2(148));

    }
    //o(n)超时
    public static int sqrt(int x) {
        for (int i = 0; i <= x; i++) {
            if (i * i == x) {
                return i;
            }
            if (i * i > x) {
                return i - 1;
            }
        }
        return 0;
    }
    //o(n)超时只能选用o（logn)
    //选择最后一个lastk*k<=x的
    public static int sqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        //找到第最后一个满足k*k<=x的数
        int left = 0;
        int right = x;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid < x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
        System.out.println(right);
        if (right <= x / right) {
            return right;
        }
        return left;
    }
}
