package 剑指offer;

public class Num66构建乘积数组 {

    public int[] constructArr(int[] a) {
        //ans[i]=a[1]*a[2]*...*a[i+1]*..a[n-1]
        int[] ans = new int[a.length];
        //先计算出i之前的乘积
        for (int i = 0, res = 1; i < a.length; i++) {
            ans[i] = res;
            res *= a[i];
        }
        //再将i之后的乘积乘上去
        for (int i = a.length - 1, res = 1; i >= 0; i--) {
            ans[i] *= res;
            res *= a[i];
        }
        return ans;
    }
}
