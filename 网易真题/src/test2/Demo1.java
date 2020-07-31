package test2;

public class Demo1 {
    public static void main(String[] args) {

    }

    public static int[] findTwoNum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * arr[j] == target) {
                    return new int[]{i, j};
                }

            }
        }
        return new int[]{-1, -1};
    }

//    public static int demo1(int[] arr, int target) {
//        int count = 0;
//        int[] twoNum = findTwoNum(arr, target);
//        if (twoNum[0] != -1) {
//            //找到了
//            for (int i = 0; i < arr.length; i++) {
//                if(i!=twoNum[0]&&i!=twoNum)
//            }
//        }
//    }

}
