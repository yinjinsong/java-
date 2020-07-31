package dp;

/*
    动态规划可以用递归做，也可以用非递归做。
    选择第n个：opt(n)=opt(n-1)+val[n]
    不选择第n个：opt(n)=opt(n-1)
    取两者最大值

 */
public class Demo1 {
    //要求求出不相邻元素的最大和是多少[0,arr.length-1]
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
       // System.out.println(optMax(arr, 6));
        System.out.println(optMax2(arr));
    }

    //递归版本
    public static int optMax(int[] arr, int i) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (i == 0) {
            return arr[0];
        } else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            //选择当前元素的结果
            int A = optMax(arr, i - 2) + arr[i];
            //不选择当前元素的结果
            int B = optMax(arr, i - 1);
            return Math.max(A, B);
        }
    }
    //非递归版本
    public static int optMax2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //保存最优结果的数组，这样就可以查找不需要递归
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            //选择当前元素
            int A = opt[i - 2] + arr[i];
            //不选择当前元素
            int B = opt[i - 1];
            opt[i] = Math.max(A, B);
        }
        return opt[arr.length - 1];
    }

}
