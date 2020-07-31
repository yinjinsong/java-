/*
判断一个正整数是不是回文数。

回文数的定义是，将这个数反转之后，得到的数仍然是同一个数。

样例
例1：

输入：11
输出：true

例2：

输入：1232
输出：false
解释：
1232!=2321
注意事项
给的数一定保证是32位正整数，但是反转之后的数就未必了。
 */
public class Num491回文串动规 {

    public static boolean isPalindrome(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;
        //用dp做
        //dp[i][j]代表arr[i]到arr[j]是否是回文串
        boolean[][] dp = new boolean[n][n];
        //1.初始化
        //先初始化每一个字符
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //再判断相邻的字符
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = arr[i] == arr[i + 1];
        }
        //状态转移
        //dp[i][j]依赖于dp[i+1][j-1]
        for (int i = n-1; i >= 0; i--) {
            //相邻的已经判断过了，需要从j=i+2开始判断
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && arr[i] == arr[j];
            }
        }
        return dp[0][n - 1];

    }
    public static boolean isPalindrome2(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
