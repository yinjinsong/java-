package 剑指offer;

public class Num15二进制中1的个数 {
    //与n的最后一位看是否是1，然后将n右移一位
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
    //n&(n-1)将n的最后一位1变成0，也可以用来判断是否是2的次幂
    public int hammingWeight2(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }

}
