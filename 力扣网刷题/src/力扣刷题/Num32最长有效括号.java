package 力扣刷题;

public class Num32最长有效括号 {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        char[] reverseArr = new char[arr.length];
        for (int i = arr.length - 1, k = 0; i >= 0; )
            reverseArr[k++] = arr[i--];
        for (int i = 0; i < reverseArr.length; i++)
            reverseArr[i] ^= 1;
        return Math.max(helper(arr), helper(reverseArr));
    }

    private int helper(char[] arr) {
        int ans = 0;
        for (int i = 0, start = 0, cnt = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                cnt++;
            } else {
                cnt--;
                if (cnt < 0) {
                    start = i + 1;
                    cnt = 0;
                } else if (cnt == 0) {
                    ans = Math.max(ans, i - start + 1);
                }
            }
        }
        return ans;
    }
}
