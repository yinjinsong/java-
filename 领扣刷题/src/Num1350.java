/*
给定一个正整数，返回相应的列标题，如Excel表中所示。
样例
样例1
输入: 28
输出: "AB"
样例2

输入: 29
输出: "AC"
注意事项
1 -> A
2 -> B
3 -> C
 ...
26 -> Z
27 -> AA
28 -> AB
 */
public class Num1350 {
    public static void main(String[] args) {

    }

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char c = (char) ((n % 26) + 'A');
            n /= 26;
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}





