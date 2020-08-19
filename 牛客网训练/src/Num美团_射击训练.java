/*
题目描述
小Q是一个专业的射击运动员，有一天他像往常一样进行n次射击训练，每次射击他都会取最高的四次得分作为最终得分来衡量他的射击状态，但是今天他制定了一个奇怪的规则：在n次射击得分中取出四次得分a,b,c,d，并且满足a*b*c=d作为最终得分来衡量他的射击状态。

但是小Q发现满足这个条件的(a,b,c,d)可能不止一个，小Q需要你来帮助他计算一共有多少个这种(a,b,c,d)

输入描述:
输入包括两行，第一行包括一个正整数n(4≤n≤500)，表示射击的次数。

第二行n个正整数w[i](1≤w[j]≤10^6)，表示每次射击的得分。
输出描述:
输出可以作为最终得分的种数。
示例1
输入
复制
6
10 2 2 7 40 160
输出
复制
2
说明
有两种满足条件的(a,b,c,d)分别是(10,2,2,40)和(2,2,40,160)。
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Num美团_射击训练 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            set.add(arr[i]);
        }
        int ans = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long cur = arr[i] * arr[j] * arr[k];
                    if (set.contains(cur)) ans++;
                    else if (cur > set.last()) break;
                }
            }
        }
        System.out.println(ans);
    }

}
