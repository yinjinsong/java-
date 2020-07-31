package 趋势科技考试;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] arr = s.toCharArray();
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
        for (int i = n - 1; i >= 0; i--) {
            //相邻的已经判断过了，需要从j=i+2开始判断
            for (int j = i + 2; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && arr[i] == arr[j];

            }
        }
        int count = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j - i >= 1 && dp[i][j]) {
                    maxLen = Math.max(j - i + 1, maxLen);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("null");
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j - i + 1 == maxLen && dp[i][j]) {
                        System.out.println(s.substring(i, j + 1));
                    }
                }
            }
        }

    }

}
