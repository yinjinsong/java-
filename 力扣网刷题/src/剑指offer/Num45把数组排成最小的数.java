package 剑指offer;

import java.util.Arrays;

public class Num45把数组排成最小的数 {
    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{10, 2}));
    }
    //使用内置函数
    public static String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();

    }
    //手写快排
    public static String minNumber2(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        quickSort(strings, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static void quickSort(String[] strings, int left, int right) {
        if (left > right) {
            return;
        }
        String base = strings[left];
        int i = left;
        int j = right;
        //因为主元素定义的是左边，所以必须右边先开始走
        while (i < j) {
            while(i < j && (strings[j] + base).compareTo(base + strings[j]) >= 0) {
                j--;
            }
            while (i < j && (strings[i] + base).compareTo(base + strings[i]) <= 0) {
                i++;
            }
            if (i < j) {
                //交换
                String temp = strings[i];
                strings[i] = strings[j];
                strings[j] = temp;
            }
        }
        //主元素归位
        strings[left] = strings[i];
        strings[i] = base;
        //向左向右递归
        quickSort(strings, left, i - 1);
        quickSort(strings, i + 1, right);
    }
}
