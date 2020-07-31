package 剑指offer;

import java.util.HashMap;

public class Num48最长不含重复字符串的子字符串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int ans = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                Integer index = map.get(s.charAt(right));
                //只有最后一次出现的下标大于等于left才移动left
                if (index >= left) {
                    left = index + 1;
                }
            }
            map.put(s.charAt(right), right);
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

}
