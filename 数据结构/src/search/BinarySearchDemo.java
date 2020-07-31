package search;

import java.util.ArrayList;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1000, 1000, 1234};
        int[] arr2 = {1, 1, 1, 1, 1, 2};
        System.out.println(binarySearch2(arr2, 0, arr2.length - 1, 1));

    }

    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        int midVal = arr[mid];
        if (target < midVal) {
            //向左递归查找
            return binarySearch(arr, left, mid - 1, target);
        } else if (target > midVal) {
            return binarySearch(arr, mid + 1, right, target);
        } else {
            return mid;
        }


    }


    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int target) {
        ArrayList<Integer> list = new ArrayList<>();

        if (left > right) {
            return list;
        }

        int mid = left + (right - left) / 2;
        int midVal = arr[mid];
        if (target < midVal) {
            //向左递归查找
            return binarySearch2(arr, left, mid - 1, target);
        } else if (target > midVal) {
            return binarySearch2(arr, mid + 1, right, target);
        } else {
            //找到后先向左递归查找
            int tmp = mid - 1;
            while (tmp >= 0 && arr[tmp] == target) {
                list.add(tmp);
                tmp--;
            }
            //再添加当前下标
            list.add(mid);
            tmp = mid + 1;
            //向右递归
            while (tmp < arr.length && arr[tmp] == target) {
                list.add(tmp);
                tmp++;
            }
            return list;
        }
    }


}
