package 力扣刷题;

public class Num1095山脉数组中查找目标值 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int topIndex = findMountainTop(mountainArr, 0, mountainArr.length() - 1);
        //如果山顶元素就是目标元素
        if (mountainArr.get(topIndex) == target) {
            return topIndex;
        }
        //在升序区间查找
        int index = -1;
        index = findInSortedArray(target, mountainArr, 0, topIndex - 1);
        if (index != -1) {
            return index;
        }
        //降序区间查找
        index = findInReversedArray(target, mountainArr, topIndex + 1, mountainArr.length() - 1);
        return index;

    }

    private int findInSortedArray(int target, MountainArray mountainArr, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                right = mid;
            } else if (mountainArr.get(mid) == target) {
                return mid;
            } else {
                left = mid;
            }
        }
        if (mountainArr.get(left) == target) {
            return left;
        } else if (mountainArr.get(right) == target) {
            return right;
        } else {
            return -1;
        }
    }
    private int findInReversedArray(int target, MountainArray mountainArr, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > target) {
                left = mid;
            } else if (mountainArr.get(mid) == target) {
                return mid;
            } else {
                right = mid;
            }
        }
        if (mountainArr.get(left) == target) {
            return left;
        } else if (mountainArr.get(right) == target) {
            return right;
        } else {
            return -1;
        }
    }

    //查找山顶元素
    private int findMountainTop(MountainArray mountainArr, int left, int right) {
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid - 1)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return mountainArr.get(left) > mountainArr.get(right) ? left : right;
    }
}
interface MountainArray {
    public int get(int index) ;

    public int length();

}