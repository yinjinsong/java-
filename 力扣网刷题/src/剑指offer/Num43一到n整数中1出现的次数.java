package 剑指offer;

public class Num43一到n整数中1出现的次数 {

    public  int countDigitOne(int n) {
        int[] arr = new int[String.valueOf(n).length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n % 10;
            n /= 10;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = 0, right = 0, t = 1;
            for (int j = arr.length - 1; j > i; j--) left = left * 10 + arr[j];
            for (int j = i - 1; j >= 0; j--) {
                right = right * 10 + arr[j];
                t *= 10;
            }
            ans += left * t;
            if(arr[i]==1) ans += right + 1;
            else if(arr[i]>1) ans += t;
        }
        return ans;
    }
}
