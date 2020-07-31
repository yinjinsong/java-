package test2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //人数
        int n = scanner.nextInt();
        //提问次数
        int m = scanner.nextInt();
        //键存放工资，值存放人数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            Integer count = map.get(money);
            //如果取到的值为空，则存放一次进去
            if (count == null) {
                map.put(money, 1);
            } else {
                //取到的值不为空，则次数加1
                map.put(money, count + 1);
            }
        }
        for (int i = 0; i < m; i++) {
            int money = scanner.nextInt();
            //如果数据为null则打印0，
            System.out.println(map.get(money) == null ? 0 : map.get(money));
        }
    }

}
