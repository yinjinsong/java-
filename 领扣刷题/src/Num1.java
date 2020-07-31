/*
给出两个整数 aa 和 bb , 求他们的和。

样例
样例 1:

输入:  a = 1, b = 2
输出: 3
样例解释: 返回a+b的结果.
样例 2:

输入:  a = -1, b = 1
输出: 0
样例解释: 返回a+b的结果.
挑战
显然你可以直接 return a + b，但是你是否可以挑战一下不这样做？（不使用++等算数运算符）
 */
public class Num1 {
    public int aplusb(int a, int b) {
        //a^b异或运算是不进位的加法
        //(a&b)<<1，是进位位
        //当进位位不为0则一直循环异或再加上进位位
        while (b != 0) {
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }
}
