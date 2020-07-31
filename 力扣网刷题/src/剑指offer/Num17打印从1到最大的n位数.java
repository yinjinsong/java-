package 剑指offer;

public class Num17打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int size = (int) Math.pow(10, n) - 1;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
