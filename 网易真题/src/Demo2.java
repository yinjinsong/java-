import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //人数
        int n = scanner.nextInt();
        //true被感染
        boolean[] personNum = new boolean[n];
        //聚会次数
        int m = scanner.nextInt();
        //初始携带病人的编号
        int f = scanner.nextInt();
        //置成感染
        personNum[f] = true;

        for (int i = 0; i < m; i++) {
            boolean flag = false;
            //聚会人数
            int q = scanner.nextInt();
            //聚会人员编号
            int[] personIndex = new int[q];
            for (int i1 = 0; i1 < q; i1++) {
                personIndex[i1] = scanner.nextInt();
            }
            for (int index : personIndex) {
                if (personNum[index] == true) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                //全部被感染
                for (int index : personIndex) {
                    personNum[index] = true;
                }
            }
        }
        //聚会完之后判断总共感人人数
        int count = 0;
        for (boolean b : personNum) {
            if (b == true) {
                count++;
            }
        }
        System.out.println(count);
    }
}
