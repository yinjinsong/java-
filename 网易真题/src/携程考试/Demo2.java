package 携程考试;

import java.util.Scanner;

/*
例如：[A,B]和[A,C,D,B]表示从城市A到达城市B的两种不同的飞行方案路径；
需要对输出的若干种飞行方案进行排序：
1，优先按照途径城市的个数升序排序,
2，当个数相等时依次按照途径城市代表字母的字母顺序排序；
3，没有方案请输出"EMPTY"；
样例输入
(A,B);(A,C);(C,B);(C,D);(D,B);
样例输出
[[A,B],[A,C,B],[A,C,D,B]]
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] split = s.split(";");

    }
}
