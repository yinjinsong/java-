package 力扣刷题;

public class Num11盛最多水的容器 {
    public int maxArea(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return ans;
    }


    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            ans = height[left] < height[right] ?
                    Math.max((right - left) * height[left++], ans) :
                    Math.max((right - left) * height[right--], ans);
        }
        return ans;
    }
}
