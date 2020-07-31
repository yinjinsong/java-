package 力扣刷题;

public class Num275H指数II {
    public int hIndex(int[] citations) {
        if(citations.length==0) return 0;
        int left = 0, right = citations.length;
        while (left  < right) {
            int mid = left + right+1 >>> 1;
            if (citations[citations.length - mid] >= mid) left = mid;
            else right = mid + 1;
        }
//        int cnt = 0;
//        for (int citation : citations) {
//            if(citation>=right) cnt++;
//        }
//        if(cnt>=right) return right;
//        return left;
        return right;
    }
}
