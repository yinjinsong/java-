public class Num15二进制中1的个数 {
    public int hammingWeight(int n) {
        //n&(n-1)可以消除最后一个1
        int ans = 0;
        while (n != 0) {
            ans++;
            n = n & (n - 1);
        }
        return ans;
    }

}
