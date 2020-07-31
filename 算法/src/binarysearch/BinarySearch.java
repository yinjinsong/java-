package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3, 8, 10, 11, 67, 100};

        System.out.println(binarySearch2(arr, 0, arr.length - 1, 10));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;


        while (left <= right) {
            int mid = left + (right - left) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] arr,int left,int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) >>> 1;


        if (arr[mid] > target) {
            //向左递归查找
            return binarySearch2(arr, left, mid - 1, target);
        }
        else if (arr[mid] < target) {
            //向右递归查找
            return binarySearch2(arr, mid + 1, right, target);
        }
        else  {
            return mid;
        }
    }
}
