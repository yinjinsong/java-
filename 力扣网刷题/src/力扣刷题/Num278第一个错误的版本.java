package 力扣刷题;

public class Num278第一个错误的版本 {
    public int firstBadVersion(int n) {
        //找到第一个错误的版本
        int left = 1, right = n;
        while (left + 1 < right) {
            int mid = left + right >>> 1;
            if(isBadVersion(mid)) right = mid;
            else left = mid;
        }
        if(isBadVersion(left)) return left;
        return right;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }

}
