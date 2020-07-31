package 力扣刷题;

import java.util.HashSet;

public class Num202快乐数 {
    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int pow = (int) Math.pow(n % 10, 2);
            sum += pow;
            n /= 10;
        }
        return sum;
    }
    //方法1用set储存已经计算过的值，如果出现重复则说明死循环不是快乐数
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;


    }

    //每计算一个结果添加到链表判断是否有环
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && fast != slow) {
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
        }
        return fast == 1;
    }

}
